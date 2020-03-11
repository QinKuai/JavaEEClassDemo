<%@page import="com.qinkuai.classdemo.dao.HomeworkDao"%>
<%@page import="com.qinkuai.classdemo.model.Homework"%>
<%@page import="com.qinkuai.classdemo.model.Student"%>
<%@page import="com.qinkuai.classdemo.util.TimeUtils"%>
<%@page import="com.qinkuai.classdemo.dao.TaskDao"%>
<%@page import="com.qinkuai.classdemo.model.Task"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<%
	String courseId = (String) request.getAttribute("cid");
	Integer taskId = (Integer) request.getAttribute("taskid");
%>
<title><%=courseId%>-作业详情</title>
</head>
<body>
	<%Task task = TaskDao.getInstance().selectById(taskId); %>
	<h2>任务内容</h2><br>
	<b><%=task.getContent() %></b>
	<h2>上传时间</h2>
	<b><%=TimeUtils.dateToString(task.getUploadTime()) %></b>
	<h2>截止时间</h2>
	<b><%=TimeUtils.dateToString(task.getStartTime(), task.getTimeLast()) %></b>
	<br><br>
	
	<h3>已提交</h3>
	<table border="1">
		<tr>
			<td>学生学号</td>
			<td>提交时间</td>			
		</tr>
		
		<%
			List<Homework> homeworks = HomeworkDao.getInstance().selectByTaskId(taskId);
			for(Homework homework: homeworks){
		%>
		<tr>
			<td><%=homework.getSid() %></td>		
			<td><%=TimeUtils.dateToString(homework.getUploadTime()) %></td>
		</tr>
		<%
			}
		%>
	</table>
</body>
</html>