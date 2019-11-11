<%@page import="com.ihsinformatics.gpaconvertor.hbservices.StudentDAO"%>
<%@page import="com.ihsinformatics.gpaconvertor.interfaces.HCrudOperations"%>

<jsp:useBean id="std"
	class="com.ihsinformatics.gpaconvertor.hbentities.Student"></jsp:useBean>
<jsp:setProperty property="*" name="std" />

<%	
	HCrudOperations<com.ihsinformatics.gpaconvertor.hbentities.Student> hStdService = new StudentDAO();
	if (hStdService.save(std)) {
		String str = "from-create";
		response.sendRedirect("view_students.jsp?from="+str);
	} 
%>

