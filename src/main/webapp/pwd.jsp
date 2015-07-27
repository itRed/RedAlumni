<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
                      + path + "/";
%>
<%
    String username = request.getAttribute("username") + "";
    String na = request.getParameter("na");
%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
	<head>
		<base href="<%=basePath%>">

		<title>管理员验证</title>

		<meta http-equiv="pragma" content="no-cache">
		<meta http-equiv="cache-control" content="no-cache">
		<meta http-equiv="expires" content="0">
		<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
		<meta http-equiv="description" content="This is my page">
		<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->

		<script type="text/javascript" src="js/jquery.min.js">
</script>
	</head>

	<body>
		<input type="text" id="uname" value="<%=na%>" hidden />
		<table align="center" border="0">
			<tr align="center">
				<td>
					系统密码：
				</td>
				<td>
					<input type="password" id="pwd" />
				</td>
			</tr>
			<tr align="center">
				<td colspan="2">
					<input type="button" id="button" value="确认提交" />
				</td>
			</tr>
		</table>
	</body>
	<script type="text/javascript">
$("#button").click(function() {
	var pwd = $("#pwd").val();
	var uname = $("#uname").val();
	var url = "CheckPwd";
	var args = {
		"pwd" : pwd,
		"uname" : uname,
		"data" : new Date()
	};
	$.post(url, args, function(data) {
		alert(data);
		if (data == 2) {
			window.location.href = "manage.jsp";
		} else
			alert("密码不正确!");
	});
});
</script>
</html>
