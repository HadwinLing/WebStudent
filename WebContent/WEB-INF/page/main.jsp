<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix ="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>首页</title>
 <style>
        *{
            margin: 0px;
            padding: 0px;
        }
        .main{
            width: 70%;
            margin-left: 15%;
            border:0px #DFDFDF solid;
            text-align: center;
        }
        table,th,td{
            border:1px #46BCAF solid;
        }
        .btn{
            display: inline-block;
            height: 30px;
            background-color: #EEEEEE;
            text-decoration: none;
            line-height: 30px;
            color: #000;

        }
        .btn:hover{
            background-color: #46BCAF;
            color: #fff;
        }
        table{
            border-collapse: collapse;
            width: 90%;
            margin-left: 5%;
        }
        table .btn{
            width: 50px;
        }
        .top{
            margin-left: 85%;
            margin-top: 10%;
        }
        .top a{
            display: inline-block;
            width: 100px;
            border-radius: 5px;
        }
        .buttom {
            /*margin-left: 90%;*/
            margin-top: 30px;
            /*width: 100px;*/
            border-radius: 5px;
        }
        .buttom a{
            display: inline-block;
            width: 100px;
            border-radius: 5px;
        }
        .deletefalse{
        	width: 100%;
			border: 0px solid red;
			height: 1%;
			font-size: 14px;
			color: red;
        }
       
    </style>
</head>
<body>
<div class=" main">
    <div class="top">
        <a href="/WebStudent/student/add" class="btn">添加</a>
        <br>
        <br>
        <a href="/WebStudent/student/search" class="btn">查询</a>
    </div>
    <div class = "deletefalse">
    	<c:if test="${param.info==1 }">
			<span>删除失败</span>
		</c:if>
    </div>
    <table>
        <tr>
            <th>学号</th>
            <th>姓名</th>
            <th>性别</th>
            <th>地址</th>
            <th>操作</th>
        </tr>
        <c:forEach items="${students}" var="student">
        <tr>
            <td>${student.getSno() }</td>
            <td>${student.getSname() }</td>
            <td>${student.getSex() }</td>
            <td>${student.getAddress() }</td>
            <td>
                <a href="/WebStudent/student/del?id=${student.getId() }" class="btn">删除</a>
                <a href="/WebStudent/student/update?id=${student.getId() }" class="btn">修改</a>
            </td>
        </tr>
        </c:forEach>
    </table>
    <div class="buttom">
        <a href="/WebStudent/student/quit" class="btn">退出登陆</a>
    </div>


</div>

</body>
</html>