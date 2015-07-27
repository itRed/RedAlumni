<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
                      + path + "/";
%>
<%
    String username = session.getAttribute("username") + "";
    int x = 1 + (int) (Math.random() * 10);
%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
	<head>
		<base href="<%=basePath%>">

		<title>系统管理</title>

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
#page {
	position: relative;
	left: 25px;
	border: 1px solid gray;
	width: 90%;
	height: 90%;
	margin: 10px;
	top: 20px;
	border: 1px dashed gray;
}

#left {
	position: absolute;
	width: 10%;
	height: 100%;
	border: 1px solid blue;
}

#content {
	position: absolute;
	height: 100%;
	border: 1px solid red;
	left: 14%;
	width: 84%;
}

body {
	background: url("images/<%=x%>.jpg") no-repeat fixed;
	background-size: 100% 100%;
}
</style>
	</head>

	<body>
		<div id="page">
			<p>
				<font face="幼圆" size="5px" color="gray" style="font-weight: bold;">&nbsp;&nbsp;&nbsp;&nbsp;管理员<%=username%>,您好！欢迎使用在线同学录系统</font>
			</p>
			<div id="left">
				<p align="center">
					<button id="ads">
						添加同学
					</button>
				</p>
				<p align="center">
					<button id="adt">
						添加老师
					</button>
				</p>
				<p align="center">
					<button id="mkpdf">
						创建PDF
					</button>
				</p>
				<p align="center">
					<button id="lsuser">
						用户列表
					</button>
				</p>
			</div>
			<div id="content">
				<br />
				<div id="makepdf" style="display: block">
					<form action="DealReportServlet" method="post">
						<input type="text" name="uid" placeholder="输入系统ID" />
						<input type="submit" id="btn" value="导出PDF" />
					</form>
				</div>

				<div id="addstu" style="display: none">
					<input type="text" id="addstutext" placeholder="添加学生的名单,分割" />
					<input type="button" id="addstubtn" value="添加" />
				</div>

				<div id="addtea" style="display: none">
					<input type="text" id="addteatext" placeholder="添加老师的名单,分割" />
					<input type="button" id="addteabtn" value="添加" />
				</div>

				<div id="listuser" style="display: none">

				</div>
			</div>
		</div>
	</body>
	<script type="text/javascript">
$(document)
		.ready(
				function() {
					$("#ads").click(function() {
						$("#addstu").css("display", "block");
						$("#addtea").css("display", "none");
						$("#listuser").css("display", "none");
						$("#makepdf").css("display", "none");
					});
					$("#adt").click(function() {
						$("#addstu").css("display", "none");
						$("#addtea").css("display", "block");
						$("#listuser").css("display", "none");
						$("#makepdf").css("display", "none");
					});
					$("#mkpdf").click(function() {
						$("#addstu").css("display", "none");
						$("#addtea").css("display", "none");
						$("#listuser").css("display", "none");
						$("#makepdf").css("display", "block");
					});
					$("#lsuser")
							.click(
									function() {
										$("#addstu").css("display", "none");
										$("#addtea").css("display", "none");
										$("#listuser").css("display", "block");
										$("#makepdf").css("display", "none");
										var url = "QueryAll";
										var html = '<table align="center"><tr><td>系统ID</td><td>&nbsp;</td><td>用户名称</td></tr>';
										var args = {};
										$
												.post(
														url,
														args,
														function(data) {
															var arrayjson = eval(data);
															$
																	.each(
																			arrayjson,
																			function() {
																				html += "<tr><td>"
																						+ this.uid
																						+ "</td><td>&nbsp;</td><td>"
																						+ this.username
																						+ "</td></tr>";
																			});
															html += "</table>";
															$("#listuser")
																	.html(html);
														});
									});

					$("#addstubtn").click(function() {
						var url = "AddStu";
						var stus = $("#addstutext").val();
						alert(stus);
						var args = {
							"stus" : stus,
							"time" : new Date()
						};
						$.post(url, args, function(data) {
							if (data != 0) {
								alert("添加成功！");
								$("#addstutext").text('');
							} else {
								alert("添加失败！");
							}
						});
					});
					$("#addteabtn").click(function() {
						var url = "AddTea";
						var stus = $("#addteatext").val();
						alert(stus);
						var args = {
							"stus" : stus,
							"time" : new Date()
						};
						$.post(url, args, function(data) {
							if (data != 0) {
								alert("添加成功！");
								$("#addteatext").text('');
							} else {
								alert("添加失败！");
							}
						});
					});
				});
</script>
</html>
