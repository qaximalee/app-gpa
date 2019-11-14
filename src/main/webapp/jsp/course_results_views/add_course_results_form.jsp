<!DOCTYPE html>
<%@page import="com.ihsinformatics.gpaconvertor.hbservices.SemesterDAO"%>
<%@page import="com.ihsinformatics.gpaconvertor.hbentities.Semester"%>
<%@page import="com.ihsinformatics.gpaconvertor.hbentities.Student"%>
<%@page import="java.util.List"%>
<%@page import="com.ihsinformatics.gpaconvertor.hbentities.Course"%>
<%@page import="com.ihsinformatics.gpaconvertor.hbservices.StudentDAO"%>
<%@page import="com.ihsinformatics.gpaconvertor.hbservices.CourseDAO"%>
<%@page import="com.ihsinformatics.gpaconvertor.interfaces.HCrudOperations"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Add Course Result</title>
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/css/bootstrap.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/js/bootstrap.min.js"></script>
</head>
<body onload="getSem(), getStudent()">
<jsp:include page="../header/nav_bar.jsp"></jsp:include>
	<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

	<div class="container">
		<a href="view_courses_results.jsp" style="float:right">View All Courses Results</a>
		<h1>Add Course Results</h1>

		<%
			HCrudOperations<Course> courseOprt = new CourseDAO();

			List<Course> courseList = courseOprt.getAll();
			request.setAttribute("courseList", courseList);

			HCrudOperations<Student> studentOprt = new StudentDAO();

			List<Student> studentList = studentOprt.getAll();
			request.setAttribute("studentList", studentList);
			
			HCrudOperations<Semester> semesterOprt = new SemesterDAO();
			List<Semester> semesterList = semesterOprt.getAll();
			request.setAttribute("semesterList", semesterList);
		%>

		<form action="../../CourseResultsServlet" method="post">
			<div class="form-group">
				<label for="studentId">Student Id:</label> <select name="studentId" id="studentId" onchange="getStudent()"
					required>
					<c:forEach items="${studentList}" var="student">
						<option value='<c:out value="${student.getStudentId()}"/>'><c:out
								value="${student.getRegistrationNo()}" /></option>
					</c:forEach>
				</select>
			</div>
			<h3 id="studName">Choose Student Registration NO...</h3>
			<div class="form-group" style="padding-top: 30px">
				<label for="semesterId">Semester Id:</label> <select name="semesterId" id="semesterId" onchange="getSem()"
					required >
					<c:forEach items="${semesterList}" var="semester">
								<option value='<c:out value="${semester.getSemesterId()}"/>'><c:out
										value="${semester.getSemesterNo()}" /></option>
							</c:forEach>
				</select>
			</div>
			<%-- <div class="form-group">
				<label for="courseId">Course Id:</label> <select name="courseId" id="courseId"
					required >
					<c:forEach items="${courseList}" var="course">
								<option value='<c:out value="${course.getCourseId()}"/>'><c:out
										value="${course.getCourseCode()}" /></option>
							</c:forEach>
				</select>
			</div> --%>
			<div class="form-group">
				<label for="courseId">Course Id:</label> <select name="courseId" id="courseId"
					required >
								<option value=""></option>
				</select>
			</div>
			<div class="form-group">
				<label for="percentage">Percentage:</label> <input type="text"
					class="form-control" id="percentage" placeholder="Enter Percentage"
					name="percentage">
			</div>
			<button type="submit" class="btn btn-default">Create Course Results</button>
		</form>
	</div>
	<script type="text/javascript">
	
		/*
			This function fetch Courses by semesterId and Fill the dropdown on selecting the Semester
		*/
		function getSem(){
			var s = document.getElementById("semesterId");
			var semNum = s.options[s.selectedIndex].value;
			let dropdown = $('#courseId');

			dropdown.empty();

			dropdown.append('<option selected="true" disabled>Choose Course</option>');
			dropdown.prop('selectedIndex', 0);

			const url = "../../getCoursesBySemester?semesterID="+semNum;

			// Populate dropdown with list of provinces
			$.getJSON(url, function (data) {
			  $.each(data, function (key, entry) {
			    dropdown.append($('<option></option>').attr('value', entry.courseId).text(entry.name));
			  })
			});
		}
		
		/*
			This function fetch Student full name by selecting the Registration No from the dropdown.
		*/
		function getStudent(){
			var std = document.getElementById("studentId");
			var stdId = std.options[std.selectedIndex].value; 
			
			const url = "../../getStudentByRegistration?studentID="+stdId;

			// Populate dropdown with list of provinces
			$.getJSON(url, function (data) {
				var studentDetails = "Full Name: "+data.firstName+" "+data.lastName;
				$('#studName').text(studentDetails);
				document.getElementById("studName").text = ""+data.firstName+" "+data.lastName;
				console.log(data.firstName+" "+data.lastName);
			});
			
		}
		
		
	</script>
</body>
</html>
