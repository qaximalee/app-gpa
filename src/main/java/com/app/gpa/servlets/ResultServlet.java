package com.app.gpa.servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.JSONObject;

import com.ihsinformatics.gpaconvertor.hbentities.Student;
import com.ihsinformatics.gpaconvertor.hbservices.StudentDAO;
import com.ihsinformatics.gpaconvertor.interfaces.HCrudOperations;

/**
 * Servlet implementation class ResultServlet
 */
public class ResultServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ResultServlet() {
		super();
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
		if (path.equals("/ResultsAvailable")) {
			isResultsAvailable(request, response);
		}
	}

	private void isResultsAvailable(HttpServletRequest request, HttpServletResponse response) {
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

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
