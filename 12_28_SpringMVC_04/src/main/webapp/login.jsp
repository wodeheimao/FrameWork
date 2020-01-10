<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2019/12/28
  Time: 9:32
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>用户登录</title>
    <!--1.引入angularjs库-->
    <link rel="stylesheet" href="${pageContext.request.contextPath}/plugins/bootstrap/css/bootstrap.min.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/plugins/angularjs/pagination.css">
    <script src="${pageContext.request.contextPath}/plugins/jQuery/jquery-2.2.3.min.js"></script>
    <script src="${pageContext.request.contextPath}/plugins/bootstrap/js/bootstrap.min.js"></script>
    <style>
        .container{
            width: 500px;
        }
        .error{
            color:red;
        }
    </style>
</head>
<body>
<div class="container">
    <div class="panel panel-primary">
        <div class="panel-heading">
            <div class="panel-title">
                <h3>登录</h3>
            </div>
        </div>
        <div class="panel-body">
            <form class="form-signin" action="${pageContext.request.contextPath}/user/login.do" method="post">
                <label  class="sr-only">用户名</label>
                <input type="text" name="username" class="form-control" placeholder="输入用户名" required autofocus>
                <label class="sr-only">密码</label>
                <input type="password" name="password" class="form-control" placeholder="请输入密码" required>
                <br>
                <button class="btn btn-lg btn-primary btn-block" type="submit">登录</button>
            </form>
            <span class="error">${message}</span>
        </div>
        <div class="panel-footer text-right">
            泽林教育2000-2019
        </div>
    </div>
</div>
</body>
</html>
