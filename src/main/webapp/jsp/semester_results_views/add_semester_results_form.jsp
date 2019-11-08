<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Add Semester Results Form</title>
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/css/bootstrap.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/js/bootstrap.min.js"></script>
</head>
<body>

<jsp:include page="../header/nav_bar.jsp"></jsp:include>
	<%@page
		import="com.ihsinformatics.gpaconvertor.services.SemesterService, com.ihsinformatics.gpaconvertor.entities.Semester,
 		com.ihsinformatics.gpaconvertor.interfaces.ICrudOperations, java.util.List, 
 		com.ihsinformatics.gpaconvertor.services.StudentService, com.ihsinformatics.gpaconvertor.entities.Student"%>
	<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>


	<%@page
		import="com.ihsinformatics.gpaconvertor.services.StudentService, com.ihsinformatics.gpaconvertor.entities.Student
 	"%>
	<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>


	<div class="container">
		<a href="view_semester_results.jsp" style="float:right">View All Semester Results</a>	
		<h1>Add Semester Results</h1>

		<%
			ICrudOperations<Semester> semesterOprt = new SemesterService();

			List<Semester> semesterList = semesterOprt.getAll();
			request.setAttribute("semesterList", semesterList);

			ICrudOperations<Student> studentOprt = new StudentService();

			List<Student> studentList = studentOprt.getAll();
			request.setAttribute("studentList", studentList);
			
			
		%>

		<form action="add_semester_results.jsp" method="post">
			<div class="form-group">
				<label for="studentId">Student Id:</label> <select name="studentId"
					required>
					<c:forEach items="${studentList}" var="student">
						<option value='<c:out value="${student.getStudentId()}"/>'><c:out
								value="${student.getRegistrationNo()}" /></option>
					</c:forEach>
				</select>
			</div>
			<div class="form-group">
				<label for="semesterId">Semester Id:</label> <select
					name="semesterId" required>
					<c:forEach items="${semesterList}" var="semester">
						<option value='<c:out value="${semester.getSemesterId()}"/>'><c:out
								value="${semester.getSemesterNo()}" /></option>
					</c:forEach>
				</select>
			</div>
			<button type="submit" class="btn btn-default">Create Semester Results</button>
		</form>

	</div>
	
	
</body>
</html>
