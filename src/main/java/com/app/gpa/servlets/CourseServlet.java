package com.app.gpa.servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ihsinformatics.gpaconvertor.hbentities.Course;
import com.ihsinformatics.gpaconvertor.hbentities.Semester;
import com.ihsinformatics.gpaconvertor.hbservices.CourseDAO;
import com.ihsinformatics.gpaconvertor.hbservices.SemesterDAO;
import com.ihsinformatics.gpaconvertor.interfaces.HCrudOperations;

/**
 * Servlet implementation class CourseServlet It will provide all Operations on
 * Course Entity
 */
public class CourseServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private HCrudOperations<Semester> semesterOprt;
	private HCrudOperations<Course> courseOprt;

	private static final String PATH = "jsp/course_views/";
	private static final String CREATED_SUCCESS = "from-create";
	private static final String CREATED_UNSUCCESS = "from-create-error";
	private static final String UPDATED_SUCCESS = "from-edit";
	private static final String UPDATED_UNSUCCESS = "from-edit-error";
	private static final String DELETED_SUCCESS = "from-delete";
	private static final String DELETED_UNSUCCESS = "from-delete-error";

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public CourseServlet() {
		super();
		semesterOprt = new SemesterDAO();
		courseOprt = new CourseDAO();
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
		// Below Code Update The Course
		if (request.getParameter("actionType").equals("delete")) {
			doDelete(request, response);
		} else {
			int courseId = Integer.parseInt(request.getParameter("courseId"));
			int courseCode = Integer.parseInt(request.getParameter("courseCode"));
			String name = request.getParameter("name");
			int semesterId = Integer.parseInt(request.getParameter("semesterId"));

			Semester semester = semesterOprt.getSingle(semesterId);
			Course course = new Course(courseId, courseCode, name, semester);

			if (courseOprt.update(course))
				response.sendRedirect(PATH + "view_courses.jsp?from=" + UPDATED_SUCCESS);
			else
				response.sendRedirect(PATH + "view_courses.jsp?from=" + UPDATED_UNSUCCESS);
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
		// Below Code Add New Course
		int semesterId = Integer.parseInt(request.getParameter("semester"));
		int courseCode = Integer.parseInt(request.getParameter("courseCode"));
		String name = request.getParameter("name");

		Semester semester = semesterOprt.getSingle(semesterId);
		Course course = new Course(0, courseCode, name, semester);

		if (courseOprt.save(course))
			response.sendRedirect(PATH + "view_courses.jsp?from=" + CREATED_SUCCESS);
		else
			response.sendRedirect(PATH + "view_courses.jsp?from=" + CREATED_UNSUCCESS);
	}

	@Override
	protected void doDelete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String courseId = req.getParameter("id");

		if (courseOprt.delete(Integer.parseInt(courseId)))
			resp.sendRedirect(PATH + "view_courses.jsp?from=" + DELETED_SUCCESS);
		else
			resp.sendRedirect(PATH + "view_courses.jsp?from=" + DELETED_UNSUCCESS);
	}

}
