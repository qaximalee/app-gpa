package com.app.gpa.servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class DemoServlet
 */
public class DemoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * Default constructor.
	 */
	public DemoServlet() {
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

		System.out.println("Value: " + request.getParameter("data"));
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
		// doGet(request, response);
		System.out.println("Values of Course Form: ---------------");
		System.out.println("Course Code: " + request.getParameter("courseCode"));
		System.out.println("Course Name: " + request.getParameter("name"));
		System.out.println("Course Semester: " + request.getParameter("semester"));

		System.out.println(request.getContextPath());

		String url = request.getPathTranslated();
		System.out.println("Url: " + url);

		String url1 = request.getRequestURL().toString();
		String queryString = request.getQueryString();

		System.out.println("queryString: " + url1);

	}
}
