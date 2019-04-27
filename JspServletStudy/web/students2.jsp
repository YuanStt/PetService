<%@ page import="service.StudentService" %>
<%@ page import="service.impl.StudentServiceImpl" %>
<%@ page import="java.util.List" %>
<%@ page import="entity.Student" %><%--
  Created by IntelliJ IDEA.
  User: HP
  Date: 2019/4/26
  Time: 16:17
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
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
        <%
            StudentService studentService = new StudentServiceImpl();
            List<Student> list = studentService.findAll();
            for (Student student:list){
        %>
        <tr>
            <td><%=student.getId()%></td>
            <td><%=student.getStuNo()%></td>
            <td><%=student.getStuName()%></td>
            <td><a href="updatestudent.jsp?stuId=<%=student.getId()%>" class="btn btn-warning">编辑</a> </td>
            <td><a href="opdel.jsp?stuId=<%=student.getId()%> " class="btn btn-danger">删除</a> </td>
        </tr>
        <%
            }
        %>
    </table>
</div>
</body>
</html>
