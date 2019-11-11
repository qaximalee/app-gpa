<%@page import="com.ihsinformatics.gpaconvertor.hbentities.Student"%>
<%@page import="com.ihsinformatics.gpaconvertor.hbservices.StudentDAO"%>
<%@page import="com.ihsinformatics.gpaconvertor.interfaces.HCrudOperations"%>
 
<jsp:useBean id="std" class="com.ihsinformatics.gpaconvertor.hbentities.Student"></jsp:useBean>  
<jsp:setProperty property="*" name="std"/>  
<%  
String strId = request.getParameter("id");
HCrudOperations<Student> hStdOprt = new StudentDAO();

if(hStdOprt.delete(Integer.parseInt(strId))){
	String str = "from-delete";
	response.sendRedirect("view_students.jsp?from="+str);
}else
	response.sendRedirect("delete_error.jsp");
%>  