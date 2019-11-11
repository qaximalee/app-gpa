<%@page
	import="com.ihsinformatics.gpaconvertor.hbservices.SemesterDAO,
	com.ihsinformatics.gpaconvertor.interfaces.HCrudOperations,
	com.ihsinformatics.gpaconvertor.hbentities.Semester"
%>
<jsp:useBean id="sem"
	class="com.ihsinformatics.gpaconvertor.hbentities.Semester"></jsp:useBean>
<jsp:setProperty property="*" name="sem" />

<%
	HCrudOperations<Semester> semesterService = new SemesterDAO();
	
	if (semesterService.save(sem)) {
		String str = "from-create";
		response.sendRedirect("view_semesters.jsp?from="+str);
	} 
%>

