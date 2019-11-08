<%@page import="com.ihsinformatics.gpaconvertor.services.StudentService, com.ihsinformatics.gpaconvertor.entities.Student,
 com.ihsinformatics.gpaconvertor.interfaces.ICrudOperations"%>  
<jsp:useBean id="std" class="com.ihsinformatics.gpaconvertor.entities.Student"></jsp:useBean>  
<jsp:setProperty property="*" name="std"/>  
<%  
String strId = request.getParameter("id");
ICrudOperations<Student> stdOprt = new StudentService();

if(stdOprt.delete(Integer.parseInt(strId))){
	String str = "from-delete";
	response.sendRedirect("view_students.jsp?from="+str);
}else
	response.sendRedirect("delete_error.jsp");
%>  