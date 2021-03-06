package com.app.gpa.servlets;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.JSONArray;
import org.json.JSONObject;

import com.ihsinformatics.gpaconvertor.hbentities.Course;
import com.ihsinformatics.gpaconvertor.hbentities.CourseResults;
import com.ihsinformatics.gpaconvertor.hbentities.Lookup;
import com.ihsinformatics.gpaconvertor.hbentities.Student;
import com.ihsinformatics.gpaconvertor.hbservices.CourseDAO;
import com.ihsinformatics.gpaconvertor.hbservices.CourseResultsDAO;
import com.ihsinformatics.gpaconvertor.hbservices.LookupDAO;
import com.ihsinformatics.gpaconvertor.hbservices.StudentDAO;
import com.ihsinformatics.gpaconvertor.interfaces.HCrudOperations;

/**
 * Servlet implementation class CourseResultsServlet It will provide all
 * Operations on CourseResults Entity
 */
public class CourseResultsServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private static final String PATH = "jsp/course_results_views/";
	private static final String CREATED_SUCCESS = "from-create";
	private static final String CREATED_UNSUCCESS = "from-create-error";
	private static final String UPDATED_SUCCESS = "from-edit";
	private static final String UPDATED_UNSUCCESS = "from-edit-error";
	private static final String DELETED_SUCCESS = "from-delete";
	private static final String DELETED_UNSUCCESS = "from-delete-error";

	private HCrudOperations<Student> studentOprt;
	private HCrudOperations<Course> courseOprt;
	private HCrudOperations<CourseResults> courseResultOprt;
	private HCrudOperations<Lookup> lookupOprt;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public CourseResultsServlet() {
		super();
		studentOprt = new StudentDAO();
		courseOprt = new CourseDAO();
		courseResultOprt = new CourseResultsDAO();
		lookupOprt = new LookupDAO();
		// TODO Auto-generated constructor stub
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

		if (path.equals("/DeleteCourseResults")) {
			doDelete(request, response);
		} else if (path.equals("/GetCoursesBySemester")) {
			getCoursesBySemester(request, response);
		} else if (path.equals("/GetStudentByRegistration")) {
			getStudentByRegistration(request, response);
		}
	}

	/*
	 * This will output JSONObject of Student, It is used in add_course_results.jsp
	 * file. And used for populating Student Name in a h3 tag by Selecting
	 * Registration No.
	 */
	private void getStudentByRegistration(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		int studentID = Integer.parseInt(request.getParameter("studentID"));

		HCrudOperations<Student> courseOprt = new StudentDAO();
		Student students = courseOprt.getSingle(studentID);

		JSONObject studentJson = new JSONObject(students);

		try {
			response.getWriter().print(studentJson.toString());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			System.out.println("JSON of Student by registration is not generated");
			e.printStackTrace();
		}
	}

	/*
	 * This will output JSONArray of Course, It is used in add_course_results.jsp
	 * file. And used for populating Course Name in a drop-down by Selecting
	 * Semester.
	 */
	private void getCoursesBySemester(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		int semesterID = Integer.parseInt(request.getParameter("semesterID"));

		CourseDAO courseOprt = new CourseDAO();
		List<Course> courses = courseOprt.getCoursesBySemester(semesterID);

		JSONArray courseJson = new JSONArray(courses);

		try {
			response.getWriter().print(courseJson.toString());
		} catch (IOException e) {
			// TODO Auto-generated catch block
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
		int studentId = Integer.parseInt(request.getParameter("studentId"));
		int courseId = Integer.parseInt(request.getParameter("courseId"));
		double percentage = Double.parseDouble(request.getParameter("percentage"));

		Course course = courseOprt.getSingle(courseId);
		Student student = studentOprt.getSingle(studentId);

		StringBuilder grade = new StringBuilder();
		double gpa = 0.0;

		List<Lookup> listOfLookup = lookupOprt.getAll();
		for (Lookup lookup : listOfLookup) {
			if (percentage >= lookup.getStartParcentage() && percentage <= lookup.getEndPercentage()) {
				gpa = lookup.getGpa();
				grade.append(lookup.getGrade());
			}
		}

		// GPA Multiply by 3 (ie 3 is credit hours)
		double totalPoints = gpa * 3;

		CourseResults courseResults = new CourseResults(0, course, student, percentage, gpa, grade.toString(),
				totalPoints);
		grade.replace(0, grade.length(), "");
		if (courseResultOprt.save(courseResults))
			response.sendRedirect(PATH + "view_courses_results.jsp?from=" + CREATED_SUCCESS);
		else
			response.sendRedirect(PATH + "view_courses_results.jsp?from=" + CREATED_UNSUCCESS);

	}

	@Override
	protected void doDelete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		// super.doDelete(req, resp);

		String strId = req.getParameter("id");

		if (courseResultOprt.delete(Integer.parseInt(strId)))
			resp.sendRedirect(PATH + "view_courses_results.jsp?from=" + DELETED_SUCCESS);
		else
			resp.sendRedirect(PATH + "view_courses_results.jsp?from=" + DELETED_UNSUCCESS);
	}

}
