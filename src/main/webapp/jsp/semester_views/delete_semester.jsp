<%@page import="com.ihsinformatics.gpaconvertor.hbservices.SemesterDAO, com.ihsinformatics.gpaconvertor.hbentities.Semester,
 com.ihsinformatics.gpaconvertor.interfaces.HCrudOperations"%>  

<%  
String strId = request.getParameter("id");
HCrudOperations<Semester> semesterOprt = new SemesterDAO();

if(semesterOprt.delete(Integer.parseInt(strId))){
	String str = "from-delete";
	response.sendRedirect("view_semesters.jsp?from="+str);
}else
	response.sendRedirect("delete_error.jsp");
%>  