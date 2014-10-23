<%@ page language="java" contentType="text/html; charset=UTF-8" 
    pageEncoding="UTF-8" isELIgnored="false"%>
<!DOCTYPE html>
<html lang="zh-CN">
<head>
	<title>用户登录</title>
	<meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no">
	<meta http-equiv="Content-Type" content="text/html;charset=UTF-8"/>
	<link rel="stylesheet" type="text/css" href="css/index.css"/>
	<script type="text/javascript" src="js/jquery-2.1.1.min.js" charset="UTF-8"></script>
	<script type="text/javascript" src="js/jquery.validate.min.js" charset="UTF-8"></script>
	<script type="text/javascript" charset="UTF-8">
		$(document).ready(function(){
			init();
			$("#loginForm").validate({
				
				rules:{
					username:"required",
					password:"required",
					code:"required"
				},
				messages:{
					username:"用户名不能为空",
					password:"密码不能为空",
					code:"验证码不能为空"
				},
				submitHandler:function(data){
					$.ajax({
						url:$(data).attr("action"),
						data:$(data).serialize(),
						dataType:'json',
						type:'post',
						success:function(data){
							if(data.result==1){
								location.href="users/users!selInfo.do";
							}
							var prompt=$(".login_prompt");
							prompt.text(data.message);
							prompt.css({"left":($(window).width()-prompt.width())/2}).slideDown("slow");
						},error:function(e){
							alert("异步失败！");
						}
					});
				}
			});
		});
		
		//初始化
		function init(){
			$("img").attr("src","validateCode?time="+new Date().getTime());//设置验证码
			$("img").bind("click",function(){
				$(this).attr("src","validateCode?time="+new Date().getTime());
			});
			$("input").focus(function(){
				$(".login_prompt").slideUp("slow");
			});
		}
	</script>
</head>
<body>
	<div id="login_main">
		<p class="login_title">用户登录</p>
		<p class="login_prompt"></p>
		<form action="login/login!login.do" method="post" id="loginForm">
			<ul>
				<li><input type="text" name="username" placeholder="请输入用户名"/></li>
				<li><input type="password" name="password" placeholder="请输入密码"/></li>
				<li><input type="text" name="code" placeholder="请输入验证码"/><img src="" class="codeImg"/></li>
			</ul>
			<div class="login_sub">
				<input type="submit" value="登录"/>
				<input type="button" value="注册" onclick="location.href='users/register.html'"/>
			</div>
		</form>
		<p class="login_foot">版权所有&nbsp;&nbsp;&nbsp;&nbsp;腾虎科技有限公司</p>
	</div>
</body>
</html>
