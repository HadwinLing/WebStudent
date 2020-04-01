<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>注册</title>
<style>
.formDiv {
	width: 70%;
	margin-left: 15%;
	border: 1px #DFDFDF solid;
	text-align: center;
	margin-top: 10%;
	padding-top: 5%;
	padding-bottom: 5%;
}

.formDiv input {
	width: 200px;
	height: 30px;
	outline: none;
	border: 1px #EEEEEE solid;
	border-radius: 5px;
}

.formDiv input:focus {
	border: 1px #46BCAF solid;
}

.formDiv .btn {
	background-color: #EEEEEE;
	color: #000;
}

.formDiv .btn:hover {
	background-color: #46BCAF;
	color: #fff;
	cursor: pointer;
	border: 1px #46BCAF solid;
}

.top {
	width: 100%;
	border: 0px solid red;
	height: 1%;
	font-size: 14px;
	color: red;
}
</style>
</head>
<body>
	<div class="formDiv">
		<div class="top">
			<c:if test="${param.info==1 }">
				<span>账号重复了,请重新录入</span>
			</c:if>
			<c:if test="${param.info==2 }">
				<span>密码两次不一致</span>
			</c:if>
		</div>
		<form action="/WebStudent/regist/doregist" method="post">
			<input type="text" name="username" placeholder="账号" /> <br />
			<br /> <input type="password" name="password" placeholder="密码" /> <br>
			<br /> <input type="password" name="password1" placeholder="请重新输入密码" /> <br>
			<br /> <input type="submit" value="确认" class="btn">
		</form>
	</div>
</body>
</html>