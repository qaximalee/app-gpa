<%@page import="com.ihsinformatics.gpaconvertor.hbservices.StudentDAO, com.ihsinformatics.gpaconvertor.hbentities.Student,
 com.ihsinformatics.gpaconvertor.interfaces.HCrudOperations"%>  
<jsp:useBean id="std" class="com.ihsinformatics.gpaconvertor.entities.Student"></jsp:useBean>  
<jsp:setProperty property="*" name="std"/>  
<%  
HCrudOperations<Student> stdOprt = new StudentDAO();

if(stdOprt.update(new Student(std.getStudentId(), std.getRegistrationNo(), std.getFirstName(), std.getLastName()))){
	String str = "from-edit";
	response.sendRedirect("view_students.jsp?from="+str);
}
else
	response.sendRedirect("update_error.jsp");
%>  