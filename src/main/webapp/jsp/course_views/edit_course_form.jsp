<!DOCTYPE html>
<%@page import="java.util.List"%>
<%@page import="com.ihsinformatics.gpaconvertor.hbentities.Semester"%>
<%@page import="com.ihsinformatics.gpaconvertor.hbservices.SemesterDAO"%>
<%@page import="com.ihsinformatics.gpaconvertor.hbservices.CourseDAO"%>
<%@page import="com.ihsinformatics.gpaconvertor.hbentities.Course"%>
<%@page import="com.ihsinformatics.gpaconvertor.interfaces.HCrudOperations"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Edit Form</title>
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
	<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

	<%
		String id = request.getParameter("id");
		HCrudOperations<Course> courseOprt = new CourseDAO();
		Course course = courseOprt.getSingle(Integer.parseInt(id));
	%>

	<%
		HCrudOperations<Semester> semesterOprt = new SemesterDAO();

		List<Semester> list = semesterOprt.getAll();
		request.setAttribute("list", list);
	%>

	<div class="container">
		<h1>Edit Course</h1>

		<form action="../../CourseServlet" method="get">
			<input type="hidden" name="actionType" value="edit"/>
			<input type="hidden" name="courseId"
				value="<%=course.getCourseId()%>" />
			<div class="form-group">
				<label for="courseCode">Course Code:</label> <input type="text"
					class="form-control" id="courseCode"
					value="<%=course.getCourseCode()%>" name="courseCode">
			</div>
			<div class="form-group">
				<label for="name">Course Name:</label> <input type="text"
					class="form-control" id="name" value="<%=course.getName()%>"
					name="name">
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
			<button type="submit" class="btn btn-default">Update Course</button>
		</form>
	</div>

</body>
</html>