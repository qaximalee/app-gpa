<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Add Semester Form</title>
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
 	com.ihsinformatics.gpaconvertor.interfaces.ICrudOperations, java.util.List"%>
	<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

	<%
		ICrudOperations<Semester> semesterOprt = new SemesterService();

		List<Semester> list = semesterOprt.getAll();
		request.setAttribute("list", list);
	%>

	<div class="container">
		<a href="view_courses.jsp" style="float:right">View All Courses</a>
		<h1>Add Course</h1>

		<form action="add_course.jsp" method="post">
			<div class="form-group">
				<label for="courseCode">Course Code:</label> <input type="text"
					class="form-control" id="courseCode" placeholder="Enter CourseCode"
					name="courseCode">
			</div>
			<div class="form-group">
				<label for="name">Semester No:</label> <select name="semesterId" 
					required>
					<c:forEach items="${list}" var="semester">
						<option value='<c:out value="${semester.getSemesterId()}"/>'><c:out
								value="${semester.getSemesterNo()}" /></option>
					</c:forEach>
				</select>
			</div>
			<div class="form-group">
				<label for="name">Course Name:</label> <input type="text"
					class="form-control" id="name" placeholder="Enter Course Name"
					name="name">
			</div>
			<button type="submit" class="btn btn-default">Create Course</button>
		</form>
	</div>
	
</body>
</html>
