<%--
  Created by IntelliJ IDEA.
  User: HP
  Date: 2019/4/28
  Time: 14:36
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>欢迎</title>
</head>
<body>
访问本网页需要有Cookie。如果没有Cookie，请跳转到同文件夹下的login.jsp进行登录。
<%
    //检测Cookie
    Cookie[] cs = request.getCookies();
    //定义一个布尔型
    boolean isAuth = false;
    String username="";
    for (Cookie cookie : cs) {
        if (cookie.getName().equals("username")) {
            isAuth = true;
            username=cookie.getValue();
            break;
        }
    }
    if (!isAuth) {
        response.sendRedirect("login.jsp");
    }
%>
欢迎你，<%=username %>
</body>
</html>
