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
 * Servlet implementation class CourseServlet
 */
public class CourseServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private HCrudOperations<Semester> semesterOprt;
	private HCrudOperations<Course> courseOprt;

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
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		int semesterId = Integer.parseInt(request.getParameter("semester"));
		int courseCode = Integer.parseInt(request.getParameter("courseCode"));
		String name = request.getParameter("name");

		Semester semester = semesterOprt.getSingle(semesterId);
		Course course = new Course(0, courseCode, name, semester);

		if (courseOprt.save(course))
			System.out.println("SAVED>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>");
		else
			System.out.println("EEEERRRRRRRRRRRRRRROOOOOOOOOOOOORRRRRRRRRRR FOUND");
	}

}
