<!DOCTYPE html>
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
	<%@page
		import="com.ihsinformatics.gpaconvertor.services.SemesterService, com.ihsinformatics.gpaconvertor.entities.Semester,
 com.ihsinformatics.gpaconvertor.interfaces.ICrudOperations"%>

	<%
		String id = request.getParameter("id");
		ICrudOperations<Semester> semesterOprt = new SemesterService();
		Semester std = semesterOprt.getSingle(Integer.parseInt(id));
	%>
	<div class="container">
		<h1>Edit Form</h1>
		<form action="edit_semester.jsp" method="post">
			<input type="hidden" name="semesterId"
				value="<%=std.getSemesterId()%>" />
			<div class="form-group">
				<label for="semesterNo">Semester No:</label> <input type="text"
					class="form-control" id="semesterNo"
					value="<%=std.getSemesterNo()%>" name="semesterNo">
			</div>
			<button type="submit" class="btn btn-default">Edit Semester</button>

		</form>
	</div>
</body>
</html>