<%@ page import="java.util.List" %>
<%@ page import="entity.Student" %><%--
  Created by IntelliJ IDEA.
  User: HP
  Date: 2019/4/29
  Time: 11:11
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
            List<Student> list = (List) request.getAttribute("list");
            for (int i = 0; i < list.size(); i++) {
                Student student = list.get(i);

        %>
        <tr>
            <td><%=student.getId()%>
            </td>
            <td><%=student.getStuNo()%>
            </td>
            <td><%=student.getStuName()%>
            </td>
            <td><%=student.getStuBirthday()%>
            </td>
            <td><%=student.getStuAddress()%>
            </td>
            <td><%=student.getStuPhone()%>
            </td>
            <td><%=student.getStuHeight()%>
            </td>
            <td><a href="updatestudent.jsp?stuId=<%=student.getId()%>" class="btn btn-warning">编辑</a></td>
            <td><a href="delstu.do?stuId=<%=student.getId()%> " class="btn btn-danger">删除</a></td>
        </tr>
        <%
            }
        %>

    </table>
</div>
</body>
</html>
