<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
                      + path + "/";
%>
<%
    String username = session.getAttribute("username") + "";
    String userid = session.getAttribute("userid") + "";
    
    int x=1+(int)(Math.random()*10);
%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
	<head>
		<base href="<%=basePath%>">

		<title></title>

		<meta http-equiv="pragma" content="no-cache">
		<meta http-equiv="cache-control" content="no-cache">
		<meta http-equiv="expires" content="0">
		<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
		<meta http-equiv="description" content="This is my page">
		<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
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
	huerreson: expression(this.width =                                           
		         this.scrollWidth);
}
body
  { 
  background:url("images/<%=x%>.jpg") no-repeat fixed;
  background-size:100% 100%;
  }
</style>
		<embed src="bgm.mp3" loop="11" autostar="true" hidden="true" width="0"
			height="0" />
	</head>
	<script type="text/javascript" src="ckeditor/ckeditor.js">
</script>
	<body>
		<body >
			<form action="SavaTea" method="post">
				<div id="bdy">
					<br />
					<br />
					<marquee>
						<font size="5" face="幼圆" color="red"><font color="blue"><%=username%>老师，</font>感谢您的陪伴和支持，正式因为有了您的教诲，我才有能力和勇气开启我的未来！生命中，感谢有您！本系统将从即日起上线，并且在2015年7月1日正式下线。感谢使用。</font>
					</marquee>
					<p align="center">
						<input type="text" value="<%=username%>" name="uname" hidden />
						<input type="text" value="<%=userid%>" name="uid" hidden />
						<input type="text" class="fildtext" name="uemail"
							placeholder="请在此输入您的联系邮箱" style="width: 300px;" />
						<input type="text" class="fildtext" name="uphone"
							placeholder="请在此输入您的联系电话" style="width: 300px;" />
						<input type="text" class="fildtext" name="uqq"
							placeholder="留下您的QQ号吧" style="width: 300px;" />
						&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
					</p>
					<p align="center">
						<input type="text" class="fildtext" name="umotto"
							placeholder="写下您的座右铭" style="width: 650px;" />
						&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
					</p>
					<textarea id="alumnitext" name="alumnitext"
						value="给我一点忠告！让我铭记一生"></textarea>
					<p align="center">
						<input type="submit" class="common-btn" id=""
							value="我写完了，并且确定不可修改" />
					</p>
				</div>
			</form>
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
	editor = CKEDITOR.replace('alumnitext'); //参数‘content’是textarea元素的name属性值，而非id属性值
	config.dialog_backgroundCoverOpacity = 0;
}
</script>
</html>
