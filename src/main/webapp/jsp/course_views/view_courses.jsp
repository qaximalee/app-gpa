<!DOCTYPE html>

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>View Courses</title>
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
	<%@page
		import="com.ihsinformatics.gpaconvertor.hbservices.CourseDAO, 
		com.ihsinformatics.gpaconvertor.hbentities.Course,
 com.ihsinformatics.gpaconvertor.interfaces.HCrudOperations, java.util.List"%>
	<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>


	<%
		if(request.getParameter("from") != null){ 
		%>
			<input type="hidden" id="fromRequest" value="<%= request.getParameter("from") %>">
	<%		
		} 
		HCrudOperations<Course> courseOprt = new CourseDAO();

		List<Course> list = courseOprt.getAll();
		request.setAttribute("list", list);
	%>
	<div class="row">
	<div class="container">
		<h1>Courses List</h1>
		<table class="table responsive" id="sort">
			<thead>
				<tr>
					<th scope="col">Id</th>
					<th scope="col">Course No</th>
					<th scope="col">Course Name</th>
					<th scope="col">Semester</th>
					<th scope="col">Edit</th>
					<th scope="col">Delete</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach items="${list}" var="std">
					<tr>
						<td data-table-header="Id">${std.getCourseId()}</td>
						<td data-table-header="Course No">${std.getCourseCode()}</td>
						<td data-table-header="Course Name">${std.getName()}</td>
						<td data-table-header="Semester">${std.getSemester().getSemesterNo()}</td>
						<td data-table-header="Edit"><a href="edit_course_form.jsp?id=${std.getCourseId()}">Edit</a></td>
						<td data-table-header="Delete"><a href="../../CourseServlet?actionType=delete&id=${std.getCourseId()}">Delete</a></td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
		<br /> <a href="add_course_form.jsp">Add New Course</a>
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
		if(fromRequest == "from-create"){
			alertify.success('Course Added');
			document.getElementById("fromRequest").value = null;
		}else if(fromRequest == "from-create-error"){
			alertify.error('Course is not Created');
			document.getElementById("fromRequest").value = null;
		}else if( fromRequest == "from-edit"){
			alertify.success('Course Updated');
			document.getElementById("fromRequest").value = null;
		}else if(fromRequest == "from-edit-error"){
			alertify.error('Course is not Updated');
			document.getElementById("fromRequest").value = null;
		}else if( fromRequest == "from-delete"){
			alertify.error('Course Deleted');
			document.getElementById("fromRequest").value = null;
		}else if(fromRequest == "from-delete-error"){
			alertify.error('Course is not Deleted');
			document.getElementById("fromRequest").value = null;
		}
	</script>
	
</body>
</html>