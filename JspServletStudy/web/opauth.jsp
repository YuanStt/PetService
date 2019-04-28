<%@ page import="service.UserService" %>
<%@ page import="service.impl.UserServiceImpl" %>
<%@ page import="entity.User" %><%--
  Created by IntelliJ IDEA.
  User: HP
  Date: 2019/4/28
  Time: 14:18
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>用户校验</title>
</head>
<body>
<%
    String username = request.getParameter("username");
    String password = request.getParameter("password");
    //用户登录，就是去数据库中比对用户的信息，比对用户名和密码。
    //常见有两种比对：1种把用户拿出来比对，2种返回该用户名和该密码的用户的个数。
    System.out.println(username + password);
    //实例一个UserService
    UserService userService = new UserServiceImpl();
    //直接返回记录个数
    //boolean isok=userService.auth(username, password);

    //返回User对象，比较密码
    User user = userService.findByUsername(username);
    boolean isok = false;
    if (password.equals(user.getPassword())) {
        isok = true;
        //保存对象到session
        //session是浏览器和服务器的一段会话，有一个超时的时间。
        //超时时间中浏览器如果没有和服务器再次联系，则session会被清掉
        //session的数据保存在服务器中，sessionId会发送到客户单的cookie。
        //关闭浏览器，session就会被清除。

        //先把密码清掉
        user.setPassword(null);
        //通过session保存对象。
        session.setAttribute("user", user);

    }
    if (isok) {
%>
<script type="text/javascript">
    alert("登录成功！");
    window.location.href = "welcome.jsp";
</script>
<%
} else {
%>
<script type="text/javascript">
    alert("登录失败！用户名或者密码错误");
    window.history.back();
</script>
<%
    }
%>
</body>
</html>
