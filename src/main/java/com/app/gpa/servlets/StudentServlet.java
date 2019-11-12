package com.app.gpa.servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ihsinformatics.gpaconvertor.hbentities.Student;
import com.ihsinformatics.gpaconvertor.hbservices.StudentDAO;
import com.ihsinformatics.gpaconvertor.interfaces.HCrudOperations;

/**
 * Servlet implementation class DemoServlet
 */
public class StudentServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static final String PATH = "jsp/student_views/";
	private static final String CREATED_SUCCESS = "from-create";
	private static final String CREATED_UNSUCCESS = "from-create-error";
	private static final String UPDATED_SUCCESS = "from-edit";
	private static final String UPDATED_UNSUCCESS = "from-edit-error";
	private static final String DELETED_SUCCESS = "from-delete";
	private static final String DELETED_UNSUCCESS = "from-delete-error";

	private HCrudOperations<Student> studentOprt;

	/**
	 * Default constructor.
	 */
	public StudentServlet() {
		// TODO Auto-generated constructor stub
		super();
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
		if (request.getParameter("actionType").equals("delete"))
			doDelete(request, response);
		else {
			int studentId = Integer.parseInt(request.getParameter("studentId"));
			String firstName = request.getParameter("firstName");
			String lastName = request.getParameter("lastName");
			String registrationNo = request.getParameter("registrationNo");

			Student student = new Student(studentId, registrationNo, firstName, lastName);

			if (studentOprt.update(student))
				response.sendRedirect(PATH + "view_students.jsp?from=" + UPDATED_SUCCESS);
			else
				response.sendRedirect(PATH + "view_students.jsp?from=" + UPDATED_UNSUCCESS);
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
		String firstName = request.getParameter("firstName");
		String lastName = request.getParameter("lastName");
		String registrationNo = request.getParameter("registrationNo");

		Student student = new Student(0, registrationNo, firstName, lastName);

		if (studentOprt.save(student))
			response.sendRedirect(PATH + "view_students.jsp?from=" + CREATED_SUCCESS);
		else
			response.sendRedirect(PATH + "view_students.jsp?from=" + CREATED_UNSUCCESS);
	}

	@Override
	protected void doDelete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		int studentId = Integer.parseInt(req.getParameter("id"));

		if (studentOprt.delete(studentId))
			resp.sendRedirect(PATH + "view_students.jsp?from=" + DELETED_SUCCESS);
		else
			resp.sendRedirect(PATH + "view_students.jsp?from=" + DELETED_UNSUCCESS);
	}

}
