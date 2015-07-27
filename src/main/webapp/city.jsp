<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
                      + path + "/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
	<head>
		<base href="<%=basePath%>">

		<title>My JSP 'city.jsp' starting page</title>

		<meta http-equiv="pragma" content="no-cache">
		<meta http-equiv="cache-control" content="no-cache">
		<meta http-equiv="expires" content="0">
		<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
		<meta http-equiv="description" content="This is my page">
		<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
		<style type="text/css">
html,body,p,th,td,input,select,textarea,button,div {
	padding: 0;
	margin: 0;
	font-family: "microsoft yahei", Tahoma, sans-serif;
	font-size: 12px;
	line-height: 180%;
}

html,body {
	background: #F6F6F6;
}

dl,ol,dt,dd,ul,li,form,h1,h2,h3,h4,h5,h6 {
	margin: 0;
	padding: 0;
	list-style: none;
}

input,select,textarea,button {
	vertical-align: middle;
	resize: none;
}

.clear {
	clear: both;
	overflow: hidden;
	height: 1px;
}

.clearfix {
	overflow: auto;
	height: 1%
}

img {
	border: 0;
	vertical-align: middle
}

body,a,a:visited {
	font-size: 12px;
	color: #000;
	text-decoration: none;
}

a:hover {
	text-decoration: underline;
	color: #333
}

a,a:hover {
	text-decoration: none
}

img {
	border: 0
}

ul {
	list-style: none;
	margin: 0;
}

label {
	color: #6CBD45;
	font-size: 14px;
	font-weight: bold;
	padding-bottom: 0.5em;
	margin: 0;
}

.city_input {
	border: 1px solid #d6d6d6;
	width: 180px;
	height: 30px;
	background: url(images/ts-indexcity.png) no-repeat;
	line-height: 30px;
	margin-top: 5px;
	text-indent: 5px;
}
</style>

		<link href="css/cityLayout.css" type="text/css" rel="stylesheet">

	</head>
	<body>


		<div align="center">
			<input name="" id="start1" autocomplete="off" type="text"
				value="请选择/输入城市名称"
				class="city_input  inputFocus proCityQueryAll proCitySelAll"
				ov="请选择/输入城市名称">
		</div>

		<!--弹出省省市-->
		<div class="provinceCityAll">

			<div class="tabs clearfix">
				<ul>
					<li>
						<a href="javascript:" class="current" tb="hotCityAll">热门城市</a>
					</li>
					<li>
						<a href="javascript:" tb="provinceAll">省份</a>
					</li>
					<li>
						<a href="javascript:" tb="cityAll" id="cityAll">城市</a>
					</li>
					<li>
						<a href="javascript:" tb="countyAll" id="countyAll">区县</a>
					</li>
				</ul>
			</div>

			<div class="con">
				<div class="hotCityAll invis">
					<div class="pre">
						<a></a>
					</div>
					<div class="list">
						<ul></ul>
					</div>
					<div class="next">
						<a class="can"></a>
					</div>
				</div>
				<div class="provinceAll invis">
					<div class="pre">
						<a></a>
					</div>
					<div class="list">
						<ul></ul>
					</div>
					<div class="next">
						<a class="can"></a>
					</div>
				</div>
				<div class="cityAll invis">
					<div class="pre">
						<a></a>
					</div>
					<div class="list">
						<ul></ul>
					</div>
					<div class="next">
						<a class="can"></a>
					</div>
				</div>
				<div class="countyAll invis">
					<div class="pre">
						<a></a>
					</div>
					<div class="list">
						<ul></ul>
					</div>
					<div class="next">
						<a class="can"></a>
					</div>
				</div>
			</div>

		</div>


		<script type="text/javascript" src="js/jquery-1.6.2.min.js">
</script>
		<script type="text/javascript" src="js/public.js">
</script>

	</body>
</html>
