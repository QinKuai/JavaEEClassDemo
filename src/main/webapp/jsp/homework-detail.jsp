<%@page import="com.qinkuai.classdemo.util.TimeUtils"%>
<%@page import="java.util.List"%>
<%@page import="com.qinkuai.classdemo.dao.HomeworkDao"%>
<%@page import="com.qinkuai.classdemo.model.Homework"%>
<%@page import="com.qinkuai.classdemo.model.Student"%>
<%@page import="com.qinkuai.classdemo.dao.StudentDao"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<%
	String courseId = (String) request.getAttribute("cid");
	String studentId = (String) request.getAttribute("sid");
	Integer taskId = (Integer) request.getAttribute("taskid");
%>
<title><%=courseId%>-作业详情</title>
</head>
<body>
	<%
			Student student = StudentDao.getInstance().selectById(studentId);
	%>
	<h2><%=student.getFirstName() + student.getLastName()%>提交的作业</h2>
	<table border="1">
		<tr>
			<td>作业内容</td>
			<td>作业提交时间</td>
		</tr>
		
		<%
			List<Homework> homeworks = HomeworkDao.getInstance().selectByCourseId(studentId, taskId);
			for (Homework homework : homeworks) {
		%>
		<tr>
			<td><%=homework.getContent() %></td>
			<td><%=TimeUtils.dateToString(homework.getUploadTime()) %></td>
		</tr>

		<%
			}
		%>
	</table>

	<input type="button" value="上传作业" onclick="jumpToAddNewHomework()">
	<script type="text/javascript">
		function jumpToAddNewHomework() {
			window.location.href = "add-homework"
		}
	</script>
</body>
</html>