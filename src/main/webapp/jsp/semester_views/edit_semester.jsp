<%@page import="com.ihsinformatics.gpaconvertor.hbservices.SemesterDAO, com.ihsinformatics.gpaconvertor.hbentities.Semester,
 com.ihsinformatics.gpaconvertor.interfaces.HCrudOperations"%>  
<jsp:useBean id="std" class="com.ihsinformatics.gpaconvertor.entities.Semester"></jsp:useBean>  
<jsp:setProperty property="*" name="std"/>  
<%  
HCrudOperations<Semester> semesterOprt = new SemesterDAO();

if(semesterOprt.update(new Semester(std.getSemesterId(), std.getSemesterNo()))){
	String str = "from-edit";
	response.sendRedirect("view_semesters.jsp?from="+str);
}else
	response.sendRedirect("update_error.jsp");
%>  