<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
                      + path + "/";
%>
<%
    int uid = Integer.parseInt(request.getParameter("uid"));
    String username = request.getParameter("uname");
    int x=1+(int)(Math.random()*10);
%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
	<head>
		<base href="<%=basePath%>">

		<title>同学录正文</title>

		<meta http-equiv="pragma" content="no-cache">
		<meta http-equiv="cache-control" content="no-cache">
		<meta http-equiv="expires" content="0">
		<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
		<meta http-equiv="description" content="This is my page">
		<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
		<embed src="bgm.mp3" loop="11" autostar="true" hidden="true" width="0"
			height="0" />
			<style type="text/css">
#bdy {
	position: absolute;
	left: 25px;
	border: 1px solid gray;
	width: 90%;
	height: 90%;
	margin: 10px;
	top: 20px;
	border: 1px dashed gray;
}

#foot {
	position: absolute;
	width: 90%;
	top: 93%;
	color: green;
}

bdy-title {
	position: relative;
	width: 100%;
	height: 4%;
	border: 1px solid blue;
	z-index: 20;
}

#cnt {
	position: relative;
	bottom: 10px;
	width: 100%;
	border: 1px solid red;
	width: 100%;
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

.fildtext {
	background: transparent;
	border: 1px solid #ffffff;
	height: 50px;
	font-family: 幼圆;
	font-size: 20px;
	huerreson: expression(this.width =             this.scrollWidth);
}

body {
	background: url("images/<%=x%>.jpg") no-repeat fixed;
	background-size: 100% 100%;
}
</style>
			<script type="text/javascript" src="js/jquery.min.js">
</script>
			<script type="text/javascript" src="js/jquery.min.js">
</script>
	</head>
	<script type="text/javascript" src="ckeditor/ckeditor.js">
</script>
	<body>
		<div id="bdy">
			<br />
			<input type="text" id="uid" value="<%=uid%>" hidden />
			<input type="text" id="uname" value="<%=username%>" hidden />
			<br />
			<marquee>
				<font size="5" face="幼圆" color="red"><font color="blue"><%=username%>同学，</font>四年之中感谢您的陪伴和支持！生命中，感谢有你！本系统将从即日起上线，并且在2015年7月1日正式下线。感谢使用。</font>
			</marquee>
			<br />
			<textarea id="alumnitext" name="alumnitext"></textarea>
			<p align="center">
				<input type="button" id="mycnt" class="common-btn"
					value="我写完了，并且确定不可修改" />
			</p>
		</div>
		<div id="foot">
			<p align="center">
				<font size="3" face="幼圆">&copy;2015.</font><font size="2">&nbsp;版权所有&nbsp;&nbsp;沈阳化工大学&nbsp;
					<a href="mailto:it_red@sina.com" style="color: blue;">王兴宇</a>&nbsp;技术支持：
					<a href="http://www.cnblogs.com/itred" style="color: red;">itRed</a>
				</font>
			</p>
		</div>
	</body>
	<script type="text/javascript">
var editor = null;
window.onload = function() {
	editor = CKEDITOR.replace('alumnitext', {
		height : '60%',
		width : '100%'
	}); //参数‘content’是textarea元素的name属性值，而非id属性值
}
</script>
	<script type="text/javascript">
$("#mycnt").click(
		function() {
			var contentinfo = CKEDITOR.instances.alumnitext.getData();
			var content = editor.document.getBody().getText();
			var uid = $("#uid").val();
			var url = "ContentServlet";
			var args = {
				"contentinfo" : contentinfo,
				"content" : content,
				"uid" : uid,
				"time" : new Date()
			};

			$.post(url, args, function(data) {
				if (data == 1) {
					alert("输入完成！谢谢");
					window.location.href = "deal.jsp?&uid=" + uid + "&d="
							+ new Date().getTime();
				} else {
					alert("添加过程中出现问题，请联系管理员");
				}
			});
		});
</script>
</html>
