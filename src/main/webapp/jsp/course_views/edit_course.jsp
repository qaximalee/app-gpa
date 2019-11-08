<%@page import="com.ihsinformatics.gpaconvertor.services.CourseService, com.ihsinformatics.gpaconvertor.entities.Course,
 com.ihsinformatics.gpaconvertor.interfaces.ICrudOperations"%>  
<jsp:useBean id="course" class="com.ihsinformatics.gpaconvertor.entities.Course"></jsp:useBean>  
<jsp:setProperty property="*" name="course"/>  
<%  
ICrudOperations<Course> courseOprt = new CourseService();

if(courseOprt.update(new Course(course.getCourseId(), course.getCourseCode(), course.getName(), course.getSemesterId()))){
	String str = "from-edit";
	response.sendRedirect("view_courses.jsp?from="+str);
}else
	response.sendRedirect("update_error.jsp");
%>  