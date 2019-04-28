<%--
  Created by IntelliJ IDEA.
  User: HP
  Date: 2019/4/26
  Time: 14:28
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>用户登录</title>
    <script src="js/jquery-3.4.0.js"></script>
    <script src="js/md5.min.js"></script>
    <script type="text/javascript">
        function submitForm(){

            var pwd=$("#password").val();
            pwd=md5(pwd);
            $("#password").val(pwd);
            return true;

        }
    </script>
</head>
<body>
<form action="opauth.jsp" method="post" onsubmit="return submitForm()">
    <input type="text" name="username" />
    <input type="password" name="password" id="password"/>
    <input type="submit" value="登录"/>
</form>
</body>
</html>
