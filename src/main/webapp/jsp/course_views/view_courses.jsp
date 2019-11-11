<!DOCTYPE html>

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>View Courses</title>
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/css/bootstrap.min.css">
<!-- include the script -->
<script src="../../js_lib/alertify.min.js"></script>
<!-- include the style -->
<link rel="stylesheet" href="../../js_lib/css/alertify.min.css" />
<!-- include a theme -->
<link rel="stylesheet" href="../../js_lib/css/themes/default.min.css" />
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
	<div class="container">
		<h1>Courses List</h1>
		<table class="table table-striped">
			<thead>
				<tr>
					<th>Id</th>
					<th>Course No</th>
					<th>Course Name</th>
					<th>Semester</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach items="${list}" var="std">
					<tr>
						<td>${std.getCourseId()}</td>
						<td>${std.getCourseCode()}</td>
						<td>${std.getName()}</td>
						<td>${std.getSemester().getSemesterNo()}</td>
						<td><a href="edit_course_form.jsp?id=${std.getCourseId()}">Edit</a></td>
						<td><a href="delete_course.jsp?id=${std.getCourseId()}">Delete</a></td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
		<br /> <a href="add_course_form.jsp">Add New Course</a>
	</div>
	<script type="text/javascript">
	
		var fromRequest = document.getElementById("fromRequest").value;
		if(fromRequest == "from-create"){
			alertify.success('Course Added');
			document.getElementById("fromRequest").value = null;
		}else if( fromRequest == "from-edit"){
			alertify.success('Course Updated');
			document.getElementById("fromRequest").value = null;
		}else if( fromRequest == "from-delete"){
			alertify.error('Course Deleted');
			document.getElementById("fromRequest").value = null;
		}
	</script>
	
</body>
</html>