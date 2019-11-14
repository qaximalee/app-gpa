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
<!-- include the script -->
<script src="../../js_lib/alertify.min.js"></script>
<!-- include the style -->
<link rel="stylesheet" href="../../js_lib/css/alertify.min.css" />
<!-- include a theme -->
<link rel="stylesheet" href="../../js_lib/css/themes/default.min.css" />
</head>
<body>
	<jsp:include page="../header/nav_bar.jsp"></jsp:include>
	<div class="container">
		<a href="view_semesters.jsp" style="float: right">View All Records</a>
		<br />

		<h1>Add New Semester</h1>
		<form action="../../SemesterServlet" method="post">
			<input type="hidden" name="actionType" value="add" />
			<div class="form-group">
				<label for="semesterNo">Semester No:</label> <input type="number" min="1" max="8"
					class="form-control" id="semesterNo"
					placeholder="Enter Semester No" name="semesterNo"
					required>
			</div>
			<button type="submit" class="btn btn-default">Create
				Semester</button>

		</form>
	</div>
	<script type="text/javascript">
	
	</script>
</body>
</html>
