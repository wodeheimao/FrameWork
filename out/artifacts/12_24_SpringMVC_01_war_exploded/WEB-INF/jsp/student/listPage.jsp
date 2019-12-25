<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>学生列表</title>
    <style>
        .table {
            margin-top: 10px;
        }

        .table th, .table td {
            text-align: center;
            vertical-align: middle !important;
        }
    </style>
    <title>学生列表</title>
    <link rel="stylesheet" href="/bootstrap-3.3.7/css/bootstrap.min.css">
    <script src="/bootstrap-3.3.7/js/jquery.min.js"></script>
    <script src="/bootstrap-3.3.7/js/bootstrap.min.js"></script>
</head>
<body>

<div class="container">
    <div class="page-header">
        <h3>
            <small>
                学生列表信息
            </small>
        </h3>
    </div>

    <div class="panel panel-success">
        <div class="panel-heading">
            <div class="row">
                <div class="col-md-2">
                    <h4>学生列表(分页)</h4>
                </div>

            </div>
        </div>
        <table class="table table-bordered table-hover table-striped">
            <tr>
                <th>学号</th>
                <th>姓名</th>
                <th>性别</th>
                <th>年龄</th>
                <th>住址</th>
                <th>所在班级</th>
                <th>操作</th>
            </tr>
            <tbody id="tb">
            <c:forEach items="${pr.rows}" var="stu">
                <tr>
                    <td>${stu.sid}</td>
                    <td>${stu.sname}</td>
                    <td>${stu.sex}</td>
                    <td>${stu.age}</td>
                    <td>${stu.addr}</td>
                    <td>${stu.cname}</td>
                    <td>
                        <a href='javascript:void(0)' onclick='toUpdate(" + JSON.stringify(v) + ")'
                           class='glyphicon glyphicon-pencil btn btn-success btn-sm'>修改</a>
                        <a href='javascript:void(0)' onclick='deleteStudent(" + v.sid + ")'
                           class='glyphicon glyphicon-trash btn btn-danger btn-sm'>删除</a>
                    </td>
                </tr>
            </c:forEach>
            </tbody>
        </table>
        <div class="text-center">
            <nav aria-label="Page navigation">
                <ul class="pagination">
                    <li>
                        <a href="#" aria-label="Previous">
                            <span aria-hidden="true">&laquo;</span>
                        </a>
                    </li>
                    <c:forEach begin="1" var="p" end="${pr.totalPages}">
                        <li class="${p == pr.page ? 'active':''}"><a href="/student/listPage.do?page=${p}">${p}</a></li>
                    </c:forEach>
                    <li>
                        <a href="#" aria-label="Next">
                            <span aria-hidden="true">&raquo;</span>
                        </a>
                    </li>
                </ul>
            </nav>
        </div>
    </div>
    <div class="panel-footer text-right">
        泽林教育2000-2019.
    </div>
</div>
</div>
</body>
</html>
