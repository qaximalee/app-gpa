<!DOCTYPE html>
<%@page import="com.ihsinformatics.gpaconvertor.pojo.SemesterResultsPOJO"%>
<%@page import="java.util.List"%>
<%@page import="com.ihsinformatics.gpaconvertor.hbservices.SemesterResultsDAO"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>View Semester Results</title>
<meta name="viewport" content="width=device-width, initial-scale=1">

<link href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css" rel="stylesheet"/>

<link href="https://fonts.googleapis.com/css?family=Roboto:300,300i,500" rel="stylesheet"/>

<link href="https://maxcdn.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css" rel="stylesheet"/>

<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
<!-- include the script -->
<script src="../../js_lib/alertify.min.js"></script>
<!-- include the style -->
<link rel="stylesheet" href="../../js_lib/css/alertify.min.css" />
<!-- include a theme -->
<link rel="stylesheet" href="../../js_lib/css/themes/default.min.css" />
<link rel="stylesheet" href="../../js_lib/css/bootstrap_search.css"/>
</head>
<body>
<jsp:include page="../header/nav_bar.jsp"></jsp:include>
	<%
		if(request.getParameter("from") != null ){ 
		%>
			<input type="hidden" id="fromRequest" value="<%= request.getParameter("from") %>">
	<%		
		} 
	
		SemesterResultsDAO semResOprt = new SemesterResultsDAO();

		List<SemesterResultsPOJO> list = semResOprt.getAllReadableResults();
		request.setAttribute("list", list);
		
	%>
	<div class="row">
	<div class="container">
		<h1>Semester Results List</h1>
		<table class="table responsive" id="sort">
			<thead>
				<tr>
					<th scope="col">First Name</th>
					<th scope="col">Last Name</th>
					<th scope="col">Registration No</th>
					<th scope="col">Semester</th>
					<th scope="col">Semester GPA</th>
					<th scope="col">CGPA</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach items="${list}" var="semRes">
					<tr>
						<td data-table-header="First Name">${semRes.getFirstName()}</td>
						<td data-table-header="Last Name">${semRes.getLastName()}</td>
						<td data-table-header="Registration No">${semRes.getRegistrationNo()}</td>
						<td data-table-header="Semester">${semRes.getSemesterNo()}</td>
						<td data-table-header="Semester GPA">${semRes.getSemesterGPA()}</td>
						<td data-table-header="CGPA">${semRes.getcGPA()}</td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
		<br /> <a href="add_semester_results_form.jsp">Add New Semester Results</a>
	</div></div>
	<script
		src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.1.1/jquery.min.js"></script>
	<script
		src="https://cdnjs.cloudflare.com/ajax/libs/datatables/1.10.12/js/jquery.dataTables.min.js"></script>
	<script
		src="https://cdnjs.cloudflare.com/ajax/libs/datatables/1.10.12/js/dataTables.bootstrap.min.js"></script>
	<script src="https://cdn.datatables.net/plug-ins/1.10.15/sorting/stringMonthYear.js"></script>
	<script type="text/javascript">
		$(document).ready(function() {
		   $("#sort").DataTable({
		      columnDefs : [
		    			{ type : 'date', targets : [5] }
						],  
		   					});
		});
		var fromRequest = document.getElementById("fromRequest").value;
		if(fromRequest != null){
			alertify.success('Semester Result Added');
			document.getElementById("fromRequest").value = null;
		}
		
	</script>

</body>
</html>

