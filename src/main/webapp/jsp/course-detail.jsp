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
<title><%=courseId %>-课程详情</title>
</head>
<body>
	<h2>学生列表</h2>
	<table border="1">
		<tr>
			<td>学号</td>
			<td>名字</td>
		</tr>
		<%
			List<Student> students = StudentDao.getInstance().selectByCourseId(courseId);
			for(Student student : students){
		%>
		<tr>
			<td><%=student.getId() %></td>
			<td><%=student.getFirstName() + student.getLastName() %></td>
		</tr>
		
		<%
			} 
		%>
	</table>
	<b>输入学生学号添加学生：</b>
	<input type="text">
	<button>添加学生</button>
	
	<h2>任务列表</h2>
	<table border="1">
		<tr>
			<td>内容</td>
			<td>上传时间</td>
			<td>截止日期</td>
		</tr>
		<%
			List<Task> tasks = TaskDao.getInstance().selectByCourseId(courseId);
			for(Task task : tasks){
		%>
		<tr>
			<td><%=task.getContent() %></td>
			<td><%=TimeUtils.dateToString(task.getUploadTime()) %></td>
			<td><%=TimeUtils.dateToString(task.getStartTime(), task.getTimeLast()) %></td>
		</tr>
		
		<%
			} 
		%>
	</table>
	
	<input type="button" value="添加新任务" onclick="jumpToAddNewTask()">
	<script type="text/javascript">
		function jumpToAddNewTask(){
			window.location.href = "add-task"
		}
	</script>
</body>
</html>