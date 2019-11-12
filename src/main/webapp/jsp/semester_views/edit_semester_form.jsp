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
		import="com.ihsinformatics.gpaconvertor.hbservices.SemesterDAO, com.ihsinformatics.gpaconvertor.hbentities.Semester,
 com.ihsinformatics.gpaconvertor.interfaces.HCrudOperations"%>

	<%
		String id = request.getParameter("id");
		HCrudOperations<Semester> semesterOprt = new SemesterDAO();
		Semester std = semesterOprt.getSingle(Integer.parseInt(id));
	%>
	<div class="container">
		<h1>Edit Form</h1>
		<form action="../../SemesterServlet" method="get">
			<input type="hidden" name="actionType" value="edit"/>
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