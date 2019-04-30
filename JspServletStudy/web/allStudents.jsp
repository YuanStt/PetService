<%@ page import="java.util.List" %>
<%@ page import="entity.Student" %><%--
  Created by IntelliJ IDEA.
  User: HP
  Date: 2019/4/29
  Time: 11:11
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>所有学生</title>
    <link rel="stylesheet" href="css/bootstrap.css">
</head>
<body>
<div class="container">
    <br/>
    <p>
        <a href="addstudent.jsp" class="btn btn-default">添加学生</a>
    </p>
    <table class="table table-striped table-hover">
        <c:forEach items="${list }" var="student">
        <tr>
            <td>${student.id }
            </td>
            <td>${student.stuNo }
            </td>
            <td>${student.stuName }
            </td>
            <td>${student.stuBirthday }
            </td>
            <td>${student.stuAddress }
            </td>
            <td>${student.stuPhone }
            </td>
            <td>${student.stuHeight }
            </td>
            <td><a href="updatestudent.jsp?stuId=${student.id }" class="btn btn-warning">编辑</a></td>
            <td><a href="delstu.do?stuId=${student.id } " class="btn btn-danger">删除</a></td>
        </tr>
        </c:forEach>
    </table>
</div>
</body>
</html>
