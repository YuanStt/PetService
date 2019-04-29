<%@ page import="entity.Student" %>
<%@ page import="service.StudentService" %>
<%@ page import="service.impl.StudentServiceImpl" %>
<%@ page import="java.util.List" %><%--
  Created by IntelliJ IDEA.
  User: HP
  Date: 2019/4/27
  Time: 9:05
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>修改学生信息</title>
    <script type="text/javascript" src="js/jquery-3.4.0.js"></script>

</head>
<body>
<%
    //获取学生Id
    String stuId = request.getParameter("stuId");
    //转化Id为整形
    int iStuId = Integer.parseInt(stuId);
    StudentService studentService = new StudentServiceImpl();
    Student student = studentService.findById(iStuId);
%>
<script type="text/javascript">
    $(function () {
        $("#sid").val("<%=student.getId()%>");
        $("#stuNo").val("<%=student.getStuNo()%>");
        $("#stuName").val("<%= student.getStuName()%>");
        $("#stuBrithday").val("<%= student.getStuBirthday()%>");
        $("#stuPhone").val("<%=student.getStuPhone()%>");
        $("#stuAdddress").val(" <%=student.getStuAddress()%>");
        $("#stuHeight").val("<%=student.getStuHeight()%>");

    });
</script>
<div class="container">
    <form action="updatestu.do" method="post">
        学生编号：<input type="text" name="sid" id="sid" ><br/>
        学生学号：<input type="text" name="stuNo" id="stuNo" ><br/>
        学生姓名：<input type="text" name="stuName" id="stuName" ><br/>
        学生生日：<input type="text" name="stuBirthday" id="stuBrithday" ><br/>
        学生电话：<input type="text" name="stuPhone" id="stuPhone" ><br/>
        学生住址：<input type="text" name="stuAddress" id="stuAdddress" ><br/>
        学生身高：<input type="text" name="stuHeight" id="stuHeight" ><br/>
        <input type="submit" value="修改">
    </form>

</div>
</body>
</html>
