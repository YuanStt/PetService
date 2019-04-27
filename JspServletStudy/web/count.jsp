<%--
  Created by IntelliJ IDEA.
  User: HP
  Date: 2019/4/26
  Time: 11:05
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>页面计数器</title>
</head>
<body>
    <%! int count=0; %>
    <%
        count++;
    %>
    <%= count %>
</body>
</html>
