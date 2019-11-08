<%@page import="com.ihsinformatics.gpaconvertor.services.CourseResultsService, com.ihsinformatics.gpaconvertor.entities.CourseResults,
 com.ihsinformatics.gpaconvertor.interfaces.ICrudOperations"%>  

<%  
String strId = request.getParameter("id");
ICrudOperations<CourseResults> coursResultsOprt = new CourseResultsService();

if(coursResultsOprt.delete(Integer.parseInt(strId))){
	String str = "from-delete";
	response.sendRedirect("view_courses_results.jsp?from="+str);
}else
	response.sendRedirect("delete_error.jsp");
%>  