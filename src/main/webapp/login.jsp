<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
                      + path + "/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
	<head>
		<title>请登录校友录</title>
		<base href="<%=basePath%>">

		<link rel="stylesheet" type="text/css" href="css/style.css" />
		<link rel="stylesheet" type="text/css" href="css/animate.css" />

		<script type="text/javascript" src="js/login.js">
</script>
		<script type="text/javascript" src="js/jquery.min.js">
</script>

	</head>

	<body>
		<canvas id="christmasCanvas"
			style="top: 0px; left: 0px; z-index: 5000; position: fixed; pointer-events: none;"
			width="1285" height="100%"></canvas>

		<h2 align="center">
			王兴宇的校友录
		</h2>

		<div class="login_frame"></div>

		<div class="LoginWindow">
			<div>
				<div class="login">
					<p>
						<input type="text" name="id" id="uname" placeholder="请输入您的姓名" onkeydown="EnterPress(event)"
							value="">
					</p>
					<p align="left" style="color: red;">
						&nbsp;&nbsp;*请输入真实姓名进入
					</P>
					<p align="left" style="color: red;">
						&nbsp;&nbsp;*请使用谷歌，百度，欧朋，火狐，猎豹浏览器，勿使用360
					</P>
					<p class="login-submit">
						<button type="submit" class="login-button" id="submit">
							登录
						</button>
					</p>
				</div>
			</div>
		</div>
		<div id="timeArea">
			<script type="text/javascript">
LoadBlogParts();
</script>
		</div>
		<div style="text-align: center;">
			<p>
				技术支持：
				<a href="mailto:it_red@sina.com" target="_blank">Red</a>
			</p>
		</div>
	</body>
	<script type="text/javascript">
var snow = function() {
	if (1 == 1) {
		$("body")
				.append(
						'<canvas id="christmasCanvas" style="top: 0px; left: 0px; z-index: 5000; position: fixed; pointer-events: none;"></canvas>');
		var b = document.getElementById("christmasCanvas"), a = b
				.getContext("2d"), d = window.innerWidth, c = window.innerHeight;
		b.width = d;
		b.height = c;
		for ( var e = [], b = 0; b < 70; b++) {
			e.push( {
				x : Math.random() * d,
				y : Math.random() * c,
				r : Math.random() * 4 + 1,
				d : Math.random() * 70
			})
		}
		var h = 0;
		window.intervral4Christmas = setInterval(function() {
			a.clearRect(0, 0, d, c);
			a.fillStyle = "rgba(255, 255, 255, 0.6)";
			a.shadowBlur = 5;
			a.shadowColor = "rgba(255, 255, 255, 0.9)";
			a.beginPath();
			for ( var b = 0; b < 70; b++) {
				var f = e[b];
				a.moveTo(f.x, f.y);
				a.arc(f.x, f.y, f.r, 0, Math.PI * 2, !0)
			}
			a.fill();
			h += 0.01;
			for (b = 0; b < 70; b++) {
				if (f = e[b], f.y += Math.cos(h + f.d) + 1 + f.r / 2,
						f.x += Math.sin(h) * 2, f.x > d + 5 || f.x < -5
								|| f.y > c) {
					e[b] = b % 3 > 0 ? {
						x : Math.random() * d,
						y : -10,
						r : f.r,
						d : f.d
					} : Math.sin(h) > 0 ? {
						x : -5,
						y : Math.random() * c,
						r : f.r,
						d : f.d
					} : {
						x : d + 5,
						y : Math.random() * c,
						r : f.r,
						d : f.d
					}
				}
			}
		}, 70)
	}
}
snow();
</script>


	<script type="text/javascript">
$(function() {
	$(".btn").click(function() {
		var left = ($(window).width() * (1 - 0.35)) / 2;//box弹出框距离左边的额距离
			var height = ($(window).height() * (1 - 0.5)) / 2;

			$(".box").addClass("animated bounceIn").show().css( {
				left : left,
				top : top
			});
			$(".opacity_bg").css("opacity", "0.3").show();
		});

	$(".colse").click(function() {

		var left = ($(window).width() * (1 - 0.35)) / 2;
		var top = ($(window).height() * (1 - 0.5)) / 2;
		$(".box").show().animate( {
			width : "-$(window).width()*0.35",
			height : "-$(window).height()*0.5",
			left : "-" + left + "px",
			top : "-" + top + "px"
		}, 1000, function() {
			var width1 = $(window).width() * 0.35;
			var height1 = $(window).height() * 0.5;
			console.log(width1);
			$(this).css( {
				width : width1,
				height : height1
			}).hide();
		});
	});

	$("#submit").click(
			function() {
				var name = $("#uname").val();
				var url = "LoginServlet";
				var args = {
					"username" : name,
					"time" : new Date()
				};
				$.post(url, args, function(data) {
					if (data == 0) {
						alert("非法用户！拒绝当前操作。联系管理员phone:13671709929");
						window.location.href = "login.jsp";
					} else if (data == 1) {
						alert("管理员,您好！数据中心正在为您处理跳转。");
						window.location.href = "pwd.jsp?na="+name+"&d="+new Date().getTime();
					} else if (data == 2) {
						alert(name + "同学:您已登录成功!---欢迎使用在线同学录");
						window.location.href = "stuinfo.jsp";
					} else if (data == 3) {
						alert(name + "老师：您已登录成功!---欢迎使用在线同学录");
						window.location.href = "teainfo.jsp";
					} 
				});
			});

});
function EnterPress(e){
	var e=e||window.event;
	if(e.keyCode==13){
		var name = $("#uname").val();
				var url = "LoginServlet";
				var args = {
					"username" : name,
					"time" : new Date()
				};
				$.post(url, args, function(data) {
					if (data == 0) {
						alert("非法用户！拒绝当前操作。联系管理员phone:13671709929");
						window.location.href = "login.jsp";
					} else if (data == 1) {
						alert("管理员,您好！数据中心正在为您处理跳转。");
						window.location.href = "pwd.jsp?na="+name+"&d="+new Date().getTime();
					} else if (data == 2) {
						alert(name + "同学:您已登录成功!---欢迎使用在线同学录");
						window.location.href = "stuinfo.jsp";
					} else if (data == 3) {
						alert(name + "老师：您已登录成功!---欢迎使用在线同学录");
						window.location.href = "teainfo.jsp";
					} 
				});
	}
}
</script>
</html>
