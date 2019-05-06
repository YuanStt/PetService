<%@ page import="javax.naming.Context" %>
<%@ page import="javax.naming.InitialContext" %><%--
  Created by IntelliJ IDEA.
  User: HP
  Date: 2019/5/5
  Time: 16:09
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>测试jndi</title>
</head>
<body>
<%
    //javax.naming.Context提供了查找JNDI 的接口
    Context ctx = new InitialContext();
    //java:comp/env/为前缀
    String testjndi = (String) ctx.lookup("java:comp/env/tjndi");
    out.println("JNDI: " + testjndi);
%>
</body>
</html>
