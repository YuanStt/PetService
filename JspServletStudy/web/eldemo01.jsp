<%@ page import="entity.User" %><%--
  Created by IntelliJ IDEA.
  User: HP
  Date: 2019/4/29
  Time: 16:02
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>EL表达式</title>
</head>
<body>
    ${"哈哈哈"}=<%="哈哈哈"%>
    ${123+456}=<%=123+456%>
    ${true}
    <hr/>
    <%
        pageContext.setAttribute("novel","金某梅");
    %>
    ${novel}
    <hr/>
    ${3>2}
    ${3>2||2>1}
    ${3>2&&2>1}
    <hr/>
    ${empty novel}
    ${not empty novel}
    <hr/>
    ${param.name} request.getPararmter("name");

    <%
        User user=new User(1,"zs","123","zs","1231231231");
        pageContext.setAttribute("user",user);
    %>
    ${user.username}
    ${user.phone}
    ${user["password"]}
    <hr/>
    <ul>
        <li>pageContext：当前页面可以用</li>
        <li>request:一次请求</li>
        <li>session:一次会话</li>
        <li>application:应用内</li>
    </ul>
    <%
        pageContext.setAttribute("realName","吴彦祖");
        request.setAttribute("realName","梁朝伟");
        session.setAttribute("realName","刘德华");
        application.setAttribute("realName","帅");
    %>
    ${realName}
    ${pageScope.realName}
    ${requestScope.realName}
    ${sessionScope.realName}
    ${applicationScope.realName}
</body>
</html>
