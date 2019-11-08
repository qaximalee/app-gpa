<%@page import="com.ihsinformatics.gpaconvertor.services.SemesterService, com.ihsinformatics.gpaconvertor.entities.Semester,
 com.ihsinformatics.gpaconvertor.interfaces.ICrudOperations"%>  

<%  
String strId = request.getParameter("id");
ICrudOperations<Semester> semesterOprt = new SemesterService();

if(semesterOprt.delete(Integer.parseInt(strId))){
	String str = "from-delete";
	response.sendRedirect("view_semesters.jsp?from="+str);
}else
	response.sendRedirect("delete_error.jsp");
%>  