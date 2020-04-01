<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>学生信息修改</title>
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
		<form action="/WebStudent/student/doupdate?id=${id }" method="post">
			<input type="text" name="sno" placeholder="学号" value = ${student.getSno() }> <br />
			<br /> <input type="text" name="sname" placeholder="姓名" value = ${student.getSname() }> <br>
			<br /> <input type="text" name="sex" placeholder="性别" value = ${student.getSex() }> <br>
			<br /> <input type="text" name="address" placeholder="地址" value = ${student.getAddress() }> <br>
			<br /> <input type="submit" value="确认" class="btn">
		</form>
	</div>
</body>
</html>