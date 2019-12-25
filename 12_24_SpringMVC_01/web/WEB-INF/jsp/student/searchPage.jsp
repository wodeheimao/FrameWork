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
                <div class="col-md-3">
                    <h4>学生列表(条件查询分页)</h4>
                </div>
                <div class="col-md-9">
                    <form id="form1" method="post" class="form-inline" action="/student/searchPage.do">
                        <input type="hidden" id="page" name="page">
                        <label >姓名</label>
                        <input type="text" name="sname" id="sname" value="${student.sname}" class="form-control">&nbsp;&nbsp;
                        <label >地址</label>
                        <input type="text" name="addr" id="addr"  value="${student.addr}" class="form-control">&nbsp;&nbsp;
                        <label >班级</label>
                        <select name="cid" id="cid" class="form-control">
                            <option value="0">请选择</option>
                            <c:forEach items="${classes}" var="c">
                                <option ${c.cid == student.cid?'selected':''} value="${c.cid}">${c.cname}</option>
                            </c:forEach>
                        </select>&nbsp;&nbsp;
                        <input type="submit" value="查询">
                    </form>
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

    </div>
    <div class="panel-footer">
        <div class="text-center">
            <nav aria-label="Page navigation" >
                <ul class="pagination">
                    <li>
                        <a href="#" aria-label="Previous">
                            <span aria-hidden="true">&laquo;</span>
                        </a>
                    </li>
                    <c:forEach begin="1" var="p" end="${pr.totalPages}">
                        <li class="${p == pr.page ? 'active':''}"><a href="javascript:searchPage(${p})">${p}</a></li>
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
</div>
</div>
</body>
</html>
<script>
    function searchPage(v) {
        $("#page").val(v);
        $("#form1").submit();
    }
</script>