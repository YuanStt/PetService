<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page import="java.util.List"%>
<%--
  Created by IntelliJ IDEA.
  User: HP
  Date: 2019/5/5
  Time: 15:04
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>所有学生</title>
    <link rel="stylesheet" href="css/bootstrap.css" />
</head>
<body>
<div class="container">
    <br />
    <p>
        <a href="addstudent.jsp" class="btn btn-default">添加学生</a>
    </p>
    <table class="table table-striped table-hover">

        <c:forEach items="${pageModel.list }" var="student">

            <tr>

                <td>${student.id }</td>
                <td>${student.stuNo }</td>
                <td>${student.stuName }</td>
                <td>${student.stuBirthday }</td>
                <td>${student.stuAddress }</td>
                <td>${student.stuPhone }</td>
                <td>${student.stuHeight }</td>
                <td><a href="updatestudent.jsp?stuId=${student.id }"
                       class="btn btn-warning">编辑</a></td>
                <td><a href="delstu.do?stuId=${student.id }"
                       class="btn btn-danger">删除</a></td>
            </tr>
        </c:forEach>
    </table>
    总共有 ${pageModel.totalCount } 条
    <a href="studentspage.do?currPage=1&pageSize=${pageModel.pageSize }" class="btn btn-default">第一页</a>
    <c:if test="${pageModel.currPage>1 }">
        <a href="studentspage.do?currPage=${pageModel.currPage-1 }&pageSize=${pageModel.pageSize}" class="btn btn-default">上一页</a>
    </c:if>
    当前在 ${pageModel.currPage} 页
    <c:if test="${pageModel.currPage<pageModel.totalPage }">
        <a href="studentspage.do?currPage=${pageModel.currPage+1 }&pageSize=${pageModel.pageSize}" class="btn btn-default">下一页</a>
    </c:if>
    <a href="studentspage.do?currPage=${pageModel.totalPage }&pageSize=${pageModel.pageSize}" class="btn btn-default">最后一页</a>

</div>
</body>
</html>
