<%@ page import="service.impl.UserServiceImpl" %>
<%@ page import="service.UserService" %>
<%@ page import="entity.User" %><%--
  Created by IntelliJ IDEA.
  User: HP
  Date: 2019/4/28
  Time: 14:15
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>用户注册</title>
</head>
<body>
<%
    request.setCharacterEncoding("utf-8");
    String username = request.getParameter("username");
    String password = request.getParameter("password");
    String realname = request.getParameter("realname");
    String phone = request.getParameter("phone");

    //实例一个User对象
    User user = new User(0, username, password, realname, phone);
    //实例一个UserService对象完成注册工作（插入数据库）
    UserService userService = new UserServiceImpl();
    boolean isok = userService.register(user);
    if (isok) {
%>
<script type="text/javascript">

    alert("用户注册成功！");
    window.location.href = "register2.jsp";

</script>

<%
} else {
%>
<script type="text/javascript">
    alert("用户注册失败！");
    window.history.back();
</script>
<%
    }

%>
</body>
</html>
