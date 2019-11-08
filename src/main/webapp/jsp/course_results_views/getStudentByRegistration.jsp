<%@page import="org.json.JSONObject"%>
<%@page import="com.ihsinformatics.gpaconvertor.entities.Student"%>
<%@page import="com.ihsinformatics.gpaconvertor.services.StudentService"%>
<%

int studentID = Integer.parseInt(request.getParameter("studentID"));

StudentService courseOprt = new StudentService();
Student students = courseOprt.getSingle(studentID);

JSONObject studentJson = new JSONObject(students);


response.getWriter().print(studentJson.toString());
%>