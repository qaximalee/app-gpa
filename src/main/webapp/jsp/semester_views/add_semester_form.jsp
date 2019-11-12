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
	<div class="container">
		<a href="view_semesters.jsp" style="float: right">View All Records</a>
		<br />

		<h1>Add New Semester</h1>
		<form action="../../SemesterServlet" method="post">
			<input type="hidden" name="actionType" value="add"/>
			<div class="form-group">
				<label for="semesterNo">Semester No:</label> <input type="text"
					class="form-control" id="semesterNo"
					placeholder="Enter Semester No" name="semesterNo" onchange="return isValid()">
			</div>
			<button type="submit" class="btn btn-default">Create
				Semester</button>

		</form>
	</div>
	<script type="text/javascript">
		function isValid(){
			var value = document.getElementById("semesterNo").value;
			
		}
	</script>
</body>
</html>
