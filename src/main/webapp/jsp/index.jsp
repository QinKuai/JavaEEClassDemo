<%@page import="com.qinkuai.classdemo.dao.StudentDao"%>
<%@page import="java.util.List"%>
<%@page import="com.qinkuai.classdemo.model.Student"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<b>HelloWorld!!</b>
	<% 
		List<Student> students = StudentDao.getInstance().selectAll();
		for(Student student : students){
	%>
	<b><%=student.toString()%></b><br>
	
	<% }%>
</body>
</html>