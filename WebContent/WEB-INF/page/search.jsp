<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@	taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>查询</title>
<script type="text/javascript" src="http://apps.bdimg.com/libs/jquery/1.11.1/jquery.min.js"></script>
 <script type="text/javascript">
	function getCilck(){
		$.ajax({
			url:"/WebStudent/student/dosearch?sname="+ $(".search_txt").val(),
			dataType:"json",
			success:function(data){
				$.each(data,function(i,obj){
					$(".stulist").append("<tr><td>"+obj.sno+"</td><td>"+obj.sname+"</td><td>"+obj.sex+"</td><td>"+obj.address+"</td></tr>");
				});					
			};
			error:function(data){
				$(".stulist").append("<span>没有该信息</span>")
			}
		});
	}
 </script>
<style>
* {
	margin: 0;
	padding: 0;
}

.main {
	margin-top: 50px;
	width: 80%;
	margin-left: 10%;
	border: 0px #DFDFDF solid;
	text-align: center;
}

table, th, td {
	border: 1px #46BCAF solid;
}

.btn {
	display: inline-block;
	height: 30px;
	background-color: #EEEEEE;
	text-decoration: none;
	line-height: 30px;
	color: #000;
}

.btn:hover {
	background-color: #46BCAF;
	color: #fff;
}

table {
	border-collapse: collapse;
	width: 90%;
	margin-left: 5%;
}

table .btn {
	width: 70px;
}

.addDiv {
	text-align: left;
	width: 90%;
	margin-left: 5%;
	margin-bottom: 30px;
}

.addDiv a {
	width: 100px;
	text-align: center;
}

.search_txt {
	display: inline-block;
	height: 30px;
	margin-left: 30%;
}

.search_btn {
	display: inline-block;
	height: 30px;
	width: 70px;
	background-color: #EEEEEE;
	text-decoration: none;
	line-height: 30px;
	color: #000;
	border: none;
	outline: medium;
}

.search_btn:hover {
	background-color: #46BCAF;
	color: #fff;
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
	<div class="main">
		<div class="top">
			<c:if test="${param.info==1 }">
				<span>没有该信息</span>
			</c:if>
		</div>
		<div class="addDiv">
			<input type="text" class="search_txt" name="sname" placeholder="请输入想要查找的内容"> 
			<input type="button"class="search_btn" value="搜索"  onclick = "getCilck()">
		</div>

		<table class = "stulist">
			<tr>
            	<th>学号</th>
           		<th>姓名</th>
            	<th>性别</th>
            	<th>地址</th>
        	</tr>
		</table>
	</div>
</body>
</html>