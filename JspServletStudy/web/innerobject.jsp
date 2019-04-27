<%--
  Created by IntelliJ IDEA.
  User: HP
  Date: 2019/4/26
  Time: 14:21
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>内置对象</title>
</head>
<body>
    <%
        //out就是一个jsp的内置对象
        //作用就是在输出流输出
        out.println("<h1>你好!</h1>");
    %>
    <%
        //设置request字符串类型为utf-8
        request.setCharacterEncoding("utf-8");
        //通过表单name属性设置参数名称
        String username = request.getParameter("username");
    %>
    <%= username%>
    访问路径：<%= request.getRequestURI() %>
    <br />
    <%
        request.setAttribute("chun","zs");
        String name=(String)request.getAttribute("chun");
        out.println("name为："+name);
        String s= request.getHeader("User-Agent");
        out.println(s);
    %>
</body>
</html>
