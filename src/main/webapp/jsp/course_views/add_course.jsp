<%@page
	import="com.ihsinformatics.gpaconvertor.services.CourseService,
	com.ihsinformatics.gpaconvertor.interfaces.ICrudOperations,
	com.ihsinformatics.gpaconvertor.entities.Course"
%>
<jsp:useBean id="course"
	class="com.ihsinformatics.gpaconvertor.entities.Course"></jsp:useBean>
<jsp:setProperty property="*" name="course" />

<%
	ICrudOperations<Course> courseService = new CourseService();
	
	if (courseService.save(course)) {
		String str = "from-create";
		response.sendRedirect("view_courses.jsp?from="+str);
	} else {
		response.sendRedirect("add_course_error.jsp");
	} 
%>

