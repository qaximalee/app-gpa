<!DOCTYPE html>

<%@page import="java.util.List"%>
<%@page
	import="com.ihsinformatics.gpaconvertor.hbservices.CourseResultsDAO"%>
<%@page import="com.ihsinformatics.gpaconvertor.pojo.CourseResultsPOJO"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>View Courses Results</title>
<meta name="viewport" content="width=device-width, initial-scale=1">
<!-- include the script -->
<script src="../../js_lib/alertify.min.js"></script>
<!-- include the style -->
<link rel="stylesheet" href="../../js_lib/css/alertify.min.css" />
<!-- include a theme -->
<link rel="stylesheet" href="../../js_lib/css/themes/default.min.css" />

<link href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css" rel="stylesheet"/>

<link href="https://fonts.googleapis.com/css?family=Roboto:300,300i,500" rel="stylesheet"/>

<link href="https://maxcdn.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css" rel="stylesheet"/>

<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>

<link rel="stylesheet" href="../../js_lib/css/bootstrap_search.css"/>
</head>
<body>
	<jsp:include page="../header/nav_bar.jsp"></jsp:include>
	<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
	<div class="row">
	<div class="container">
		<h1>Courses Results List</h1>

		<%
			if (request.getParameter("from") != null) {
		%>
		<input type="hidden" id="fromRequest"
			value="<%=request.getParameter("from")%>">
		<%
			}
			
			
			CourseResultsDAO courseResultsOprt = new CourseResultsDAO();
			
			List<CourseResultsPOJO> lists = courseResultsOprt.getAllReadableResults();
			request.setAttribute("lists", lists);
		%>
		<table class="table responsive" id="sort">
			<thead>
				<tr>
					<th scope="col">First Name</th>
					<th scope="col">Last Name</th>
					<th scope="col">Registration No</th>
					<th scope="col">Course Name</th>
					<th scope="col">Semester</th>
					<th scope="col">Percentage</th>
					<th scope="col">GPA</th>
					<th scope="col">Grade</th>
					<th scope="col">Total Points</th>
					<th scope="col">Actions</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach items="${lists}" var="courseResults">
					<tr>
						<td data-table-header="First Name">${courseResults.getFirstName()}</td>
						<td data-table-header="Last Name">${courseResults.getLastName()}</td>
						<td data-table-header="Registration No">${courseResults.getRegistrationNo()}</td>
						<td data-table-header="Course Name">${courseResults.getCourseName()}</td>
						<td data-table-header="Semester">${courseResults.getSemesterNo()}</td>
						<td data-table-header="Percentage">${courseResults.getPercentage()}</td>
						<td data-table-header="GPA">${courseResults.getGpa()}</td>
						<td data-table-header="Grade">${courseResults.getGrade()}</td>
						<td data-table-header="Total Points">${courseResults.getTotalPoints()}</td>

						<td data-table-header="Actions"><a
							href="../../DeleteCourseResults?id=${courseResults.getCourseResultId()}"
							id="delete">Delete</a></td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
		<br /> <a href="add_course_results_form.jsp">Add New Course</a>
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
		    { type : 'date', targets : [9] }
		],  
		   });
		});
		var fromRequest = document.getElementById("fromRequest").value;
		if(fromRequest != null && fromRequest == "from-create"){
			alertify.success('Course Result Added');
			document.getElementById("fromRequest").value = null;
		}else if( fromRequest == "from-delete"){
			alertify.error('Course Result Deleted');
			document.getElementById("fromRequest").value = null;
		} 
		
	</script>
</body>
<script type="text/javascript">
	var elementIsClicked = false; // declare the variable that tracks the state

	function clickHandler() { // declare a function that updates the state
		elementIsClicked = true;
		console.log("LKDJLJFL:SDJLJL:KSJ");
	}

	var element = document.getElementById('delete'); // grab a reference to your element
	element.addEventListener('click', clickHandler);
	
	if(elementIsClicked){
		alertify.confirm("Do you really want to delete this?",
			function(){
				alertify.success('Ok');
			}
		, function(){
				alertify.error('Cancel');
			}		
		);
	}
</script>
</html>