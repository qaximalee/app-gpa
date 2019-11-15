<nav class="navbar navbar-inverse">
	<div class="container-fluid">
		<div class="navbar-header">
			<a class="navbar-brand" href="#">CGPA SYS</a>
		</div>
		<ul class="nav navbar-nav">
			<li class="active"><a href="${pageContext.request.contextPath}">Home</a>
			</li>
			<li><a
				href="${pageContext.request.contextPath}/jsp/student_views/add_student_form.jsp">Students</a></li>
			<li><a
				href="${pageContext.request.contextPath}/jsp/semester_views/add_semester_form.jsp">Semesters</a></li>
			<li><a
				href="${pageContext.request.contextPath}/jsp/course_views/add_course_form.jsp">Courses</a></li>
			<li><a
				href="${pageContext.request.contextPath}/jsp/course_results_views/add_course_results_form.jsp">Courses
					Results</a></li>
			<li><a
				href="${pageContext.request.contextPath}/jsp/semester_results_views/add_semester_results_form.jsp">Semesters
					Results</a></li>
			<li><a
				href="${pageContext.request.contextPath}/jsp/overall_results/generate_result.jsp">Generate
					Results</a></li>
		</ul>
	</div>
</nav>
<script type="text/javascript">
	$(document).ready(
			function() {
				$('li.active').removeClass('active');
				$('a[href="' + location.pathname + '"]').closest('li')
						.addClass('active');
			});
</script>
