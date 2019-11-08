<%@page
	import="com.ihsinformatics.gpaconvertor.services.StudentService,
	com.ihsinformatics.gpaconvertor.interfaces.ICrudOperations,
	com.ihsinformatics.gpaconvertor.entities.Student"
%>
<jsp:useBean id="std"
	class="com.ihsinformatics.gpaconvertor.entities.Student"></jsp:useBean>
<jsp:setProperty property="*" name="std" />

<%
	ICrudOperations<Student> stdService = new StudentService();
	
	if (stdService.save(std)) {
		String str = "from-create";
		response.sendRedirect("view_students.jsp?from="+str);
	} 
%>

