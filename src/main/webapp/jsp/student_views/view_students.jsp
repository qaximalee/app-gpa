<!DOCTYPE html>

<%@page import="com.ihsinformatics.gpaconvertor.hbentities.Student"%>
<%@page import="java.util.List"%>
<%@page import="com.ihsinformatics.gpaconvertor.hbservices.StudentDAO"%>
<%@page import="com.ihsinformatics.gpaconvertor.interfaces.HCrudOperations"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>View Students</title>
<meta name="viewport" content="width=device-width, initial-scale=1">
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/js/bootstrap.min.js"></script>
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


	<%
		if(request.getParameter("from") != null){ 
		%>
	<input type="hidden" id="fromRequest"
		value="<%= request.getParameter("from") %>">
	<%		
		} 
			
		HCrudOperations<Student> hStdOprt = new StudentDAO();
		List<Student> hStdList = hStdOprt.getAll();
		request.setAttribute("list", hStdList);
		
		
	%>
	<div class="row">
	<div class="container">
		<h2>All Students</h2>
		<table class="table responsive" id="sort">
			<thead>
				<tr>
					<th scope="col">Id</th>
					<th scope="col">First Name</th>
					<th scope="col">Last Name</th>
					<th scope="col">Registration No</th>
					<th scope="col">Edit</th>
					<th scope="col">Delete</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach items="${list}" var="std">
					<tr>
						<td data-table-header="Id">${std.getStudentId()}</td>
						<td data-table-header="First Name">${std.getFirstName()}</td>
						<td data-table-header="Last Name">${std.getLastName()}</td>
						<td data-table-header="Registration No">${std.getRegistrationNo()}</td>
						<td data-table-header="Edit"><a href="edit_student_form.jsp?id=${std.getStudentId()}">Edit</a></td>
						<td data-table-header="Delete" id="delete-student" onclick="deleteARecord()")><a href="../../StudentServlet?actionType=delete&id=${std.getStudentId()}">Delete</a></td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
		<br /> <a href="add_student_form.jsp">Add New Student</a>
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
		function deleteARecord(){
			alertify.confirm(" Do you want to delete the record.",
					  function(){
					    alertify.success('Ok');
					  },
					  function(){
					    alertify.error('Cancel');
					  });
		}
	
		var fromRequest = document.getElementById("fromRequest").value;
		if(fromRequest == "from-create"){
			alertify.success('Student Added');
			document.getElementById("fromRequest").value = null;
		}else if(fromRequest == "from-create-error"){
			alertify.error('Student is not Created');
			document.getElementById("fromRequest").value = null;
		}else if( fromRequest == "from-edit"){
			alertify.success('Student Updated');
			document.getElementById("fromRequest").value = null;
		}else if(fromRequest == "from-edit-error"){
			alertify.error('Student is not Updated');
			document.getElementById("fromRequest").value = null;
		}else if( fromRequest == "from-delete"){
			alertify.error('Student Deleted');
			document.getElementById("fromRequest").value = null;
		}else if(fromRequest == "from-delete-error"){
			alertify.error('Student is not Deleted');
			document.getElementById("fromRequest").value = null;
		}
	</script>
</body>
</html>