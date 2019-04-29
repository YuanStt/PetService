<%--
  Created by IntelliJ IDEA.
  User: HP
  Date: 2019/4/26
  Time: 16:46
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>添加学生</title>
</head>
<body>
<div class="container">
    <form action="addstu.do" method="post">
        学生学号：<input type="text" name="stuNo"><br/>
        学生姓名：<input type="text" name="stuName"><br/>
        学生生日：<input type="text" name="stuBirthday"><br/>
        学生电话：<input type="text" name="stuPhone"><br/>
        学生住址：<input type="text" name="stuAddress"><br/>
        学生身高：<input type="text" name="stuHeight"><br/>
        <input type="submit" value="保存">
    </form>

</div>
</body>
</html>
