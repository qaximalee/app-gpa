package com.app.gpa.servlets;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.JSONObject;

import com.ihsinformatics.gpaconvertor.hbentities.CourseResults;
import com.ihsinformatics.gpaconvertor.hbentities.Semester;
import com.ihsinformatics.gpaconvertor.hbentities.SemesterResults;
import com.ihsinformatics.gpaconvertor.hbentities.Student;
import com.ihsinformatics.gpaconvertor.hbservices.CourseResultsDAO;
import com.ihsinformatics.gpaconvertor.hbservices.SemesterDAO;
import com.ihsinformatics.gpaconvertor.hbservices.SemesterResultsDAO;
import com.ihsinformatics.gpaconvertor.hbservices.StudentDAO;
import com.ihsinformatics.gpaconvertor.interfaces.HCrudOperations;
import com.ihsinformatics.gpaconvertor.pojo.Result;

/**
 * Servlet implementation class SemesterResultsServlet It will provide all
 * Operations on SemesterResults Entity
 */
public class SemesterResultsServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private HCrudOperations<CourseResults> courseOprt;
	private HCrudOperations<SemesterResults> semesterResultsOprt;
	private HCrudOperations<Semester> semesterOprt;
	private HCrudOperations<Student> studentOprt;

	private static final String PATH = "jsp/semester_results_views/";
	private static final String CREATED_SUCCESS = "from-create";
	private static final String CREATED_UNSUCCESS = "from-create-error";

	private static final int CREDIT_HOUR = 3;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public SemesterResultsServlet() {
		super();
		// TODO Auto-generated constructor stub
		courseOprt = new CourseResultsDAO();
		semesterResultsOprt = new SemesterResultsDAO();
		semesterOprt = new SemesterDAO();
		studentOprt = new StudentDAO();
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		String path = request.getServletPath();
		if (path.equals("/GetResultByStudent")) {
			getSemesterResultByStudent(request, response);
		}
	}

	private void getSemesterResultByStudent(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		int studentId = Integer.parseInt(request.getParameter("id"));

		SemesterResultsDAO semResOprt = new SemesterResultsDAO();
		CourseResultsDAO courseResOprt = new CourseResultsDAO();
		List<SemesterResults> list = semResOprt.getSemResEntityByStudent(studentId);
		List<Result> results = new ArrayList<>();
		String message = "NOT-NULL";
		if (list.size() <= 0) {
			message = "NULL";
			JSONObject jsonObject = new JSONObject();
			jsonObject.put("message", message);
			jsonObject.put("results", new ArrayList<>());

			try {
				response.getWriter().print(jsonObject.toString());
			} catch (IOException e) {
				// TODO Auto-generated catch block
				System.out.println("------------============= RESULTSERVLET JSON ERROR =============---------------");
				e.printStackTrace();
			}
			return;
		}

		int counter = 0;
		while (counter < list.size()) {
			List<CourseResults> courseResults = courseResOprt
					.getAllCourseResultsBySemester(list.get(counter).getSemester().getSemesterId(), studentId);
			for (CourseResults courseResult : courseResults) {
				Result result = new Result(list.get(counter).getSemesterResultId(),
						courseResult.getCourse().getCourseCode(), courseResult.getCourse().getName(),
						list.get(counter).getSemester().getSemesterNo(), courseResult.getPercentage(), CREDIT_HOUR,
						courseResult.getGpa(), courseResult.getGrade(), courseResult.getTotalPoints(),
						list.get(counter).getSemesterGPA(), list.get(counter).getcGPA());
				results.add(result);
			}
			counter++;
		}

		JSONObject jsonObject = new JSONObject();
		jsonObject.put("message", message);
		jsonObject.put("results", results);

		// JSONArray jsonResults = new JSONArray(results);

		try {
			response.getWriter().print(jsonObject.toString());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			System.out.println("------------============= RESULTSERVLET JSON ERROR =============---------------");
			e.printStackTrace();
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		CourseResultsDAO courseResultsOprt = new CourseResultsDAO();
		int semesterId = Integer.parseInt(request.getParameter("semesterId"));
		int studentId = Integer.parseInt(request.getParameter("studentId"));
		List<CourseResults> listOfCourseResults = courseResultsOprt.getAllCourseResultsBySemester(semesterId,
				studentId);

		// Semester GPA can be get by below formula
		// gpa = totalPoints / gradableCredit
		// where,
		// totalPoints = gpa * credit hours
		// gradableCredit = total credit hours
		double totalPoints = 0.0;

		for (CourseResults courseResults : listOfCourseResults) {
			totalPoints += courseResults.getTotalPoints();
		}

		double gradableCredit = 3 * listOfCourseResults.size();

		double semesterGPA = totalPoints / gradableCredit;

		Semester semester = semesterOprt.getSingle(semesterId);
		Student student = studentOprt.getSingle(studentId);

		SemesterResults semesterResults = new SemesterResults(0, semester, student, semesterGPA, semesterGPA);

		boolean isSemesterResultPresent = new SemesterResultsDAO().getSemesterResultsBy(studentId, semesterId);

		if (isSemesterResultPresent) {
			response.sendRedirect(PATH + "view_std_semester_results.jsp?id=" + studentId + "&from=retrieve");
		} else if (semesterResultsOprt.save(semesterResults))
			response.sendRedirect(PATH + "view_std_semester_results.jsp?id=" + studentId + "&from=" + CREATED_SUCCESS);
		else
			response.sendRedirect(
					PATH + "view_std_semester_results.jsp?id=" + studentId + "&from=" + CREATED_UNSUCCESS);

	}

}
