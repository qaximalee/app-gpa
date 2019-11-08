
<%@page
	import="com.ihsinformatics.gpaconvertor.services.CourseResultsService,
	com.ihsinformatics.gpaconvertor.services.LookupService,
	com.ihsinformatics.gpaconvertor.interfaces.ICrudOperations,
	com.ihsinformatics.gpaconvertor.entities.CourseResults,
	com.ihsinformatics.gpaconvertor.entities.Lookup,
	java.util.List"%>
<jsp:useBean id="courseResults"
	class="com.ihsinformatics.gpaconvertor.entities.CourseResults"></jsp:useBean>
<jsp:setProperty property="*" name="courseResults" />

<%
	ICrudOperations<CourseResults> courseResultsService = new CourseResultsService();
	ICrudOperations<Lookup> lookupService = new LookupService();
	
	double percentage = courseResults.getPercentage();
	StringBuilder grade = new StringBuilder();
	double gpa = 0.0;
	
	List<Lookup> listOfLookup = lookupService.getAll();
	for(Lookup lookup: listOfLookup){
		if(percentage >= lookup.getStartParcentage() && percentage <= lookup.getEndPercentage()){
			gpa = lookup.getGpa();
			grade.append(lookup.getGrade());
		}
	}
	
	double totalPoints = Double.parseDouble(String.format("%.2f",gpa * 3));
	
	CourseResults courseResultUpdated = new CourseResults(0, courseResults.getCourseId(), courseResults.getStudentId(), percentage, gpa, grade.toString(), totalPoints);
	grade.replace(0, grade.length(), "");
	if (courseResultsService.save(courseResultUpdated)) {
		String str = "from-create";
		response.sendRedirect("view_courses_results.jsp?from="+str);
	} else {
		response.sendRedirect("add_course_results_error.jsp");
	} 
%>

