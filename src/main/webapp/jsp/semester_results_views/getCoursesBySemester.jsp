<%@page import="org.json.JSONArray"%>
<%@page import="org.json.JSONException"%>
<%@page import="org.json.JSONObject"%>
<%@page import="com.ihsinformatics.gpaconvertor.entities.Course"%>
<%@page import="java.util.List"%>
<%@page import="com.ihsinformatics.gpaconvertor.services.CourseService"%>
<%@page import="java.io.PrintWriter"%>
<%

int semesterID = 1;//Integer.parseInt(request.getParameter("semesterID"));

CourseService courseOprt = new CourseService();
List<Course> courses = courseOprt.getCoursesBySemester(semesterID);

int courseC = courses.get(3).getCourseCode();

JSONArray courseJson = new JSONArray(courses);


response.getWriter().print(courseJson.toString());
%>