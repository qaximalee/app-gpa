<%@page import="com.ihsinformatics.gpaconvertor.services.StudentService, com.ihsinformatics.gpaconvertor.entities.Student,
 com.ihsinformatics.gpaconvertor.interfaces.ICrudOperations"%>  
<jsp:useBean id="std" class="com.ihsinformatics.gpaconvertor.entities.Student"></jsp:useBean>  
<jsp:setProperty property="*" name="std"/>  
<%  
ICrudOperations<Student> stdOprt = new StudentService();

if(stdOprt.update(new Student(std.getStudentId(), std.getRegistrationNo(), std.getFirstName(), std.getLastName()))){
	String str = "from-edit";
	response.sendRedirect("view_students.jsp?from="+str);
}
else
	response.sendRedirect("update_error.jsp");
%>  