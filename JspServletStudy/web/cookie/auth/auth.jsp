<%--
  Created by IntelliJ IDEA.
  User: HP
  Date: 2019/4/28
  Time: 14:41
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>校验</title>
</head>
<body>
    <%
        String username= request.getParameter("username");
        String password = request.getParameter("password");
        if ("zs".equals(username)&&"123456".equals(password)){
            Cookie cookie = new Cookie("username","zs");
            cookie.setMaxAge(24*60*60);
            response.addCookie(cookie);
        }else {
            //用户名或者密码错误
            Cookie cookie = new Cookie("username",null);
            cookie.setMaxAge(0);
            response.addCookie(cookie);
        }
        response.sendRedirect("welcome.jsp");
    %>
</body>
</html>
