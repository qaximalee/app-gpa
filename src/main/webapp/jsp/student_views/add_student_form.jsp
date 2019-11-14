<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Add Student Form</title>
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/css/bootstrap.min.css">
<!-- include the script -->
<script src="../../js_lib/alertify.min.js"></script>
<!-- include the style -->
<link rel="stylesheet" href="../../js_lib/css/alertify.min.css" />
<!-- include a theme -->
<link rel="stylesheet" href="../../js_lib/css/themes/default.min.css" />
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>

</head>
<body>
	<jsp:include page="../header/nav_bar.jsp"></jsp:include>

	<div class="container">
		<a href="view_students.jsp" style="float: right">View All Records</a>
		<br />

		<h1>Add New Student</h1>
		<form action="../../StudentServlet" method="post" name="studentForm"
			id="studentForm" onsubmit="return getValidated()">
			<input type="hidden" name="actionType" value="add"/>
			<div class="form-group">
				<label for="firstName">First Name:</label> <input type="text"
					class="form-control" id="firstName" placeholder="Enter First Name"
					name="firstName" onchange="fnameValidation(this.value)" required>
				<span class="error"><p id="fname_error"></p></span>
			</div>
			<div class="form-group">
				<label for="lastName">Last Name:</label> <input type="text"
					class="form-control" id="lastName" placeholder="Enter Last Name"
					name="lastName" onchange="lnameValidation(this.value)" required>
					<span class="error"><p id="lname_error"></p></span>
			</div>
			<div class="form-group">
				<label for="registrationNo">Registration No:</label> <input type="text"
					class="form-control" id="registrationNo"
					placeholder="Enter Registration No" name="registrationNo"
					onchange="return isRegNoValid()" required>
					<span class="error"><p id="reg_no_error"></p></span>
			</div>
			<button type="submit" class="btn btn-default">Create Student</button>
		</form>
	</div>
	<script type="text/javascript">
	
		var isValidated = true;
	
		function fnameValidation(value){
			var regName = /^[a-zA-Z]+$/;
			var name = value;
			document.getElementById('fname_error').innerHTML = '';
			if(!regName.test(name)){
				document.getElementById('fname_error').innerHTML = 'Enter Correct First Name';
				isValidated = false;
			}else if(name == ""){
				document.getElementById('fname_error').innerHTML = 'First Name should be filled';
				isValidated = false;
			}
		}
		
		function lnameValidation(value){
			var regName = /^[a-zA-Z]+$/;
			var name = value;
			document.getElementById('lname_error').innerHTML = '';
			if(!regName.test(name)){
				document.getElementById('lname_error').innerHTML = 'Enter Correct Last Name';
				isValidated = false;
			}else if(name == ""){
				document.getElementById('lname_error').innerHTML = 'Last Name should be filled';
				isValidated = false;
			}
		}
		
		function isRegNoValid() {
			var value = document.getElementById("registrationNo").value;
			var ins = value.search(/^EP-\d{7}$/);
			document.getElementById('reg_no_error').innerHTML = '';
			if (ins != 0) {
				document.getElementById('reg_no_error').innerHTML = 'Enter Correct Registration No (i.e EP-1234567)';
				isValidated = false;
				return false; 
			}else if(value == ""){
				document.getElementById('reg_no_error').innerHTML = 'Registration No should be filled';
				isValidated = false;
				return false;
			}
			isValidated = true;
			return true;
		}
		
		function getValidated(){
			return isValidated;
		}
	</script>
</body>

</html>
