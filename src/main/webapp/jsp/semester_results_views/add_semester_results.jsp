
<%@page
	import="com.ihsinformatics.gpaconvertor.services.CourseResultsService,
	com.ihsinformatics.gpaconvertor.services.SemesterResultsService,
	com.ihsinformatics.gpaconvertor.entities.CourseResults,
	com.ihsinformatics.gpaconvertor.entities.SemesterResults,
	java.util.List"%>


<%

	CourseResultsService courseResultsService = new CourseResultsService();
	List<CourseResults> listOfCourseResults = courseResultsService.getAllCourseResultsBySemester(Integer.parseInt(request.getParameter("semesterId")), Integer.parseInt(request.getParameter("studentId")));
	
	//	Semester GPA can be get by below formula
	//	gpa = totalPoints / gradableCredit
	//	where,
	//		totalPoints = gpa * credit hours
	//		gradableCredit = total credit hours
	double totalPoints = 0.0;
	
	for(CourseResults courseResults: listOfCourseResults){
		totalPoints += courseResults.getTotalPoints();
	}
	
	double gradableCredit = 3 * listOfCourseResults.size();
	
	double semesterGPA = totalPoints/gradableCredit;
	
	SemesterResultsService semesterResultsService = new SemesterResultsService();
	SemesterResults semesterResultsUpdated = new SemesterResults(0, Integer.parseInt(request.getParameter("semesterId")), 
			Integer.parseInt(request.getParameter("studentId")), semesterGPA, semesterGPA);
	
	if (semesterResultsService.save(semesterResultsUpdated)) {
		String str = "from-create";
		response.sendRedirect("view_semester_results.jsp?from="+str);
	} else {
		response.sendRedirect("add_semester_results_error.jsp");
	} 
%>

