<%@page
	import="com.ihsinformatics.gpaconvertor.hbservices.CourseDAO,
	com.ihsinformatics.gpaconvertor.interfaces.HCrudOperations,
	com.ihsinformatics.gpaconvertor.hbentities.Course
	"
%>
<jsp:useBean id="course"
	class="com.ihsinformatics.gpaconvertor.hbentities.Course"></jsp:useBean>
<jsp:setProperty property="*" name="course" />


<%

	HCrudOperations<Course> courseService = new CourseDAO();

	if (courseService.save(course)) {
		System.out.println("Printing course properties : >>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>");
		System.out.println("Courses Prop: "+course.getCourseCode()+" "+course.getSemester().getSemesterId());
		String str = "from-create";
		response.sendRedirect("view_courses.jsp?from="+str);
	} else {
		response.sendRedirect("add_course_error.jsp");
	} 
%>

