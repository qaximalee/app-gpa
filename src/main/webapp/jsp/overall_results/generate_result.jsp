<!DOCTYPE html>
<%@page import="com.ihsinformatics.gpaconvertor.hbentities.Student"%>
<%@page import="com.ihsinformatics.gpaconvertor.interfaces.HCrudOperations"%>
<%@page import="com.ihsinformatics.gpaconvertor.hbservices.StudentDAO"%>
<%@page import="com.ihsinformatics.gpaconvertor.pojo.SemesterResultsPOJO"%>
<%@page import="java.util.List"%>
<%@page import="com.ihsinformatics.gpaconvertor.hbservices.SemesterResultsDAO"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>View Semester Results</title>
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
	<%
 
		
		HCrudOperations<Student> studentOprt = new StudentDAO();

		List<Student> studentList = studentOprt.getAll();
		request.setAttribute("studentList", studentList);
	%>

	<div class="container">
		<form onchange="generateResult()">
			<div class="form-group">
				<label for="studentId">Student Id:</label> <select name="studentId" id="studentId" onchange="getStudent()">
					<c:forEach items="${studentList}" var="student">
						<option value='<c:out value="${student.getStudentId()}"/>'><c:out
								value="${student.getRegistrationNo()}" /></option>
					</c:forEach>
				</select>
			</div>
			<span id="studName">Choose Student Registration NO...</span><br>
		</form>
		<h3 id="error"></h3>
		<div id="result"></div>
		<table class="table table-striped">
			<!-- here goes our data! -->
		</table>
	</div>
	<script type="text/javascript">
		function getStudent(){
			var std = document.getElementById("studentId");
			var stdId = std.options[std.selectedIndex].value; 
			const url = "../../getStudentByRegistration?studentID="+stdId;
	
			// Populate dropdown with list of students
			$.getJSON(url, function (data) {
				var studentDetails = "Full Name: "+data.firstName+" "+data.lastName;
				$('#studName').text(studentDetails);
				document.getElementById("studName").text = ""+data.firstName+" "+data.lastName;
				console.log(data.firstName+" "+data.lastName);
			});
		}

		function generateResult(){
			var std = document.getElementById("studentId");
			var stdId = std.options[std.selectedIndex].value; 
			var tableHead = ["Semester No", "Course Code", "Course Name", 
				"Percentage", "Credit Hours", "Grade", "GPA", "Total Points", "Semester GPA", "CGPA"];
			var tableSequence = ["semesterNo", "courseCode", "courseName", 
				"percentage", "creditHours", "grade", "gpa", "totalPoints", "semesterGPA", "cgpa"];
			
			document.getElementById("error").innerHTML = "";

			const url = "../../GetResultByStudent?id="+stdId;
			$.getJSON(url, function (data) {
				var table = document.querySelector("table");
				var resultData = data.results;
				console.log(resultData[0]);			
				generateTableHead(table, tableHead);
				generateTable(table, resultData, tableSequence);

			});
		}

		function generateTableHead(table, tableHead){
			var table = table.createTHead();
			var row = table.insertRow();
			
			for(var i = 0; i < tableHead.length; i++){
				let th = document.createElement("th");
				let text = document.createTextNode(tableHead[i]);
				th.appendChild(text);
				row.appendChild(th);
			}
		}

		function generateTable(table, data, tableSequence) {
			var semesterCompare = data[0].semesterNo;
			
			for (var i = 0; i < data.length; i++) {
				let row = table.insertRow();

				let cell1 = row.insertCell();
				let text1 = document.createTextNode(data[i].semesterNo);
				cell1.appendChild(text1);

				let cell2 = row.insertCell();
				let text2 = document.createTextNode(data[i].courseCode);
				cell2.appendChild(text2);

				let cell3 = row.insertCell();
				let text3 = document.createTextNode(data[i].courseName);
				cell3.appendChild(text3);

				let cell4 = row.insertCell();
				let text4 = document.createTextNode(data[i].percentage);
				cell4.appendChild(text4);

				let cell5 = row.insertCell();
				let text5 = document.createTextNode(data[i].creditHours);
				cell5.appendChild(text5);

				let cell6 = row.insertCell();
				let text6 = document.createTextNode(data[i].grade);
				cell6.appendChild(text6);

				let cell7 = row.insertCell();
				let text7 = document.createTextNode(data[i].gpa);
				cell7.appendChild(text7);

				let cell8 = row.insertCell();
				let text8 = document.createTextNode(data[i].totalPoints);
				cell8.appendChild(text8);
				
				if(i <= data.length-1){
					if(data[i].semesterNo != data[i+1].semesterNo){		
						let cell9 = row.insertCell();
						let text9 = document.createTextNode(data[i].semesterGPA);
						cell9.appendChild(text9);
	
						let cell0 = row.insertCell();
						let text0 = document.createTextNode(data[i].cgpa);
						cell0.appendChild(text0);	
						semesterCompare = data[i].semesterNo;	
					}	
				}
			}
		}
	</script>
	<!-- for (let element of data) {
				let row = table.insertRow();

				let cell1 = row.insertCell();
				let text1 = document.createTextNode(element.semesterNo);
				cell1.appendChild(text1);

				let cell2 = row.insertCell();
				let text2 = document.createTextNode(element.courseCode);
				cell2.appendChild(text2);

				let cell3 = row.insertCell();
				let text3 = document.createTextNode(element.courseName);
				cell3.appendChild(text3);

				let cell4 = row.insertCell();
				let text4 = document.createTextNode(element.percentage);
				cell4.appendChild(text4);

				let cell5 = row.insertCell();
				let text5 = document.createTextNode(element.creditHours);
				cell5.appendChild(text5);

				let cell6 = row.insertCell();
				let text6 = document.createTextNode(element.grade);
				cell6.appendChild(text6);

				let cell7 = row.insertCell();
				let text7 = document.createTextNode(element.gpa);
				cell7.appendChild(text7);

				let cell8 = row.insertCell();
				let text8 = document.createTextNode(element.totalPoints);
				cell8.appendChild(text8);

				if(semesterCompare == element.semesterNo){
					continue;
				}else{						
					let cell9 = row.insertCell();
					let text9 = document.createTextNode(element.semesterGPA);
					cell9.appendChild(text9);

					let cell0 = row.insertCell();
					let text0 = document.createTextNode(element.cgpa);
					cell0.appendChild(text0);	
					semesterCompare = element.semesterNo;		
				}
			} -->
</body>
</html>

