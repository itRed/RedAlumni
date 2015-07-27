<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
                      + path + "/";
%>
<%
    int uid = Integer.parseInt(request.getParameter("uid"));
    int x = 1 + (int) (Math.random() * 10);
%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
	<head>
		<base href="<%=basePath%>">

		<title>处理</title>

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
		<style type="text/css">
body {
	background: url("images/<%=x%>.jpg") no-repeat fixed;
	background-size: 100% 100%;
}

.common-btn {
	position: relative;
	border: none;
	font-size: 13px;
	font-weight: 700;
	text-transform: uppercase;
	margin: 10px 0 20px;
	padding: 0px 20px;
	line-height: 50px;
	height: 50px;
	letter-spacing: 1px;
	width: 30%;
	cursor: pointer;
	display: block;
	font-family: 'Lato', Calibri, Arial, sans-serif;
	box-shadow: 0 3px 0 rgba(0, 0, 0, 0.1);
	-webkit-touch-callout: none;
	-webkit-user-select: none;
	-khtml-user-select: none;
	-moz-user-select: none;
	-ms-user-select: none;
	user-select: none;
	height: 50px;
	border: none;
}
#cont{
	top: 50px;
	height: 200px;
	
}
</style>
	</head>

	<body>
		&nbsp;
		<form id="form1" action="DealReportServlet" method="post">
			<input type="text" value="<%=uid%>" name="uid" hidden />
			<div id="cont"><br /><br /><br /><br />
				<a href="ExitSystem" />已完成，退出系统</a>
				<br /><br />
				<input type="submit" id="export" class="common-btn" value="导出校友录PDF" />
			</div>
		</form>
	</body>
	<%--	<script type="text/javascript">--%>
	<%--$("#export").click(function() {--%>
	<%--	var uid = $("#uid").val();--%>
	<%--	var url = "DealReportServlet";--%>
	<%--	var args = {--%>
	<%--		"uid" : uid,--%>
	<%--		"time" : new Date()--%>
	<%--	};--%>
	<%--	$.post(url, args, function(data) {--%>
	<%----%>
	<%--	});--%>
	<%--});--%>
	<%--</script>--%>
</html>
