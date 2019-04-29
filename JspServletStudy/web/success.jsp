<%--
  Created by IntelliJ IDEA.
  User: HP
  Date: 2019/4/29
  Time: 10:13
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>系统消息</title>
</head>
<body>
    <%
        String msg=(String)request.getAttribute("msg");
        String jumpUrl=(String)request.getAttribute("jumpUrl");
    %>
<script type="text/javascript">
    alert("<%=msg%>");
    window.location.href="<%=jumpUrl%>";
</script>
</body>
</html>
