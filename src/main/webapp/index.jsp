<html>
<title>Main Page</title>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/css/bootstrap.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/js/bootstrap.min.js"></script>
<body>
	<h2>CGPA Calculator System</h2>
	<jsp:include page="jsp/header/nav_bar.jsp"></jsp:include>
	<form action="DemoServlet" method="GET">
		<input type="text" placeHolder="Enter Value" id="data" name="data" />
		<button>Send Data</button>
	</form>
</body>

</html>