<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>登录</title>
<style>
	.formDiv{
		width: 70%;
		
		margin-left: 15%;
		border:1px #DFDFDF solid;
		text-align: center;
		margin-top: 10%;
		padding-top: 5%;
		padding-bottom:5%;
	}
	.formDiv input{
		width: 200px;
		height: 30px;
		outline: none;
		border:1px #EEEEEE solid;
		border-radius: 5px;
	}
	.formDiv input:focus{
		border:1px #46BCAF solid;
	}
	.formDiv .btn{
		background-color: #EEEEEE;
		color:#000;
	}
	.formDiv .btn:hover{
		background-color: #46BCAF;
		color: #fff;
		cursor: pointer;
		border:1px #46BCAF solid;
	}
	.top{
		width: 100%;
		border:0px solid red;
		height: 1%;
		font-size: 14px;
		color: red;
	}
	a{
		display :inline-block;
		width: 200px;
		height: 30px;
		outline: none;
		border:1px #EEEEEE solid;
		border-radius: 5px;
		text-decoration:none;
		line-height:30px;
		color:#000;
	}
</style>
</head>
<body>
	<div class="formDiv">
		<div class="top">
			<c:if test="${param.info==1 }">
				<span>账号或密码错误，请重新登录</span>
			</c:if>
			<c:if test="${param.info==2 }">
				<span>请先登录</span>
			</c:if>
			<c:if test="${param.info==3 }">
				<span>注册失败</span>
			</c:if>
		</div>
		<form action="login" method="post">
			<input type="text" name="username" placeholder="账号"/>
			<br/><br/>
			<input type="password" name="password" placeholder="密码"/>
			<br><br/>
			<input type="submit" value="登录" class="btn">
			<br><br/>
		</form>
			<a href="regist.jsp" class = "btn">注册</a>
		
	</div>
</body>
</html>