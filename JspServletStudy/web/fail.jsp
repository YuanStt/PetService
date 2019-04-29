<%--
  Created by IntelliJ IDEA.
  User: HP
  Date: 2019/4/29
  Time: 10:16
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>系统失败提示</title>
</head>
<body>
    <%
        String msg=(String)request.getAttribute("msg");
    %>
<script type="text/javascript">
    alert("<%=msg%>");
    window.history.back();
</script>
</body>
</html>
