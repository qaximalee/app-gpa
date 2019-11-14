package com.app.gpa.servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ihsinformatics.gpaconvertor.hbentities.Semester;
import com.ihsinformatics.gpaconvertor.hbservices.SemesterDAO;
import com.ihsinformatics.gpaconvertor.interfaces.HCrudOperations;

/**
 * Servlet implementation class SemesterServlet It will provide all Operations
 * on Semester Entity
 */
public class SemesterServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private static final String PATH = "jsp/semester_views/";
	private static final String CREATED_SUCCESS = "from-create";
	private static final String CREATED_UNSUCCESS = "from-create-error";
	private static final String UPDATED_SUCCESS = "from-edit";
	private static final String UPDATED_UNSUCCESS = "from-edit-error";
	private static final String DELETED_SUCCESS = "from-delete";
	private static final String DELETED_UNSUCCESS = "from-delete-error";

	private HCrudOperations<Semester> semesterOprt;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public SemesterServlet() {
		super();
		semesterOprt = new SemesterDAO();
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

		if (request.getParameter("actionType").equals("delete"))
			doDelete(request, response);
		else {

			int semesterId = Integer.parseInt(request.getParameter("semesterId"));
			int semesterNo = Integer.parseInt(request.getParameter("semesterNo"));

			Semester semester = new Semester(semesterId, semesterNo);

			if (semesterOprt.update(semester))
				response.sendRedirect(PATH + "view_semesters.jsp?from=" + UPDATED_SUCCESS);
			else
				response.sendRedirect(PATH + "view_semesters.jsp?from=" + UPDATED_UNSUCCESS);
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

		int semesterNo = Integer.parseInt(request.getParameter("semesterNo"));

		Semester semester = new Semester(0, semesterNo);

		if (semesterOprt.save(semester))
			response.sendRedirect(PATH + "view_semesters.jsp?from=" + CREATED_SUCCESS);
		else
			response.sendRedirect(PATH + "view_semesters.jsp?from=" + CREATED_UNSUCCESS);

	}

	@Override
	protected void doDelete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		int semesterId = Integer.parseInt(req.getParameter("id"));

		if (semesterOprt.delete(semesterId))
			resp.sendRedirect(PATH + "view_semesters.jsp?from=" + DELETED_SUCCESS);
		else
			resp.sendRedirect(PATH + "view_semesters.jsp?from=" + DELETED_UNSUCCESS);
	}

}
