<%@ page import="entity.User" %><%--
  Created by IntelliJ IDEA.
  User: HP
  Date: 2019/4/28
  Time: 14:19
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>欢迎</title>
</head>
<body>
欢迎你，
<%
    //通过session获取数据
    Object o=session.getAttribute("user");
    if(o!=null){
        User user=(User)o;
        out.println(user.getRealname());
    }else{
%>
<script type="text/javascript">
    alert("请登录！");
    window.location.href="login.jsp";
</script>
<%
    }

%>
</body>
</html>
