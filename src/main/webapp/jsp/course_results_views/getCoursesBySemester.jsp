<%@page import="org.json.JSONArray"%>
<%@page import="com.ihsinformatics.gpaconvertor.entities.Course"%>
<%@page import="java.util.List"%>
<%@page import="com.ihsinformatics.gpaconvertor.services.CourseService"%>
<%@page import="java.io.PrintWriter"%>
<%

int semesterID = Integer.parseInt(request.getParameter("semesterID"));//1;//Integer.parseInt(request.getParameter("semesterID"));

CourseService courseOprt = new CourseService();
List<Course> courses = courseOprt.getCoursesBySemester(semesterID);

JSONArray courseJson = new JSONArray(courses);


response.getWriter().print(courseJson.toString());
%>