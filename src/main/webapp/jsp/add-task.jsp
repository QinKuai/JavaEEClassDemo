<%@page import="com.qinkuai.classdemo.util.TimeUtils"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="com.qinkuai.classdemo.dao.TaskDao"%>
<%@page import="com.qinkuai.classdemo.model.Task"%>
<%@page import="com.qinkuai.classdemo.model.Student"%>
<%@page import="com.qinkuai.classdemo.dao.StudentDao"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<%String courseId = (String)request.getAttribute("courseId"); %>
<title><%=courseId %>-添加任务</title>
</head>
<body>
	<h1><%=courseId %>-添加新任务</h1>
	<b>任务内容：</b><input type="text"><br><br>
	<b>开始时间：</b><input type="datetime"><br><br>
	<b>持续时间(h)：</b><input type="text"><br><br>
	<input type="submit" onclick="submitTask()">
	
	<script type="text/javascript">
		function submitTask(){
			
		}
	</script>
</body>
</html>