<%--
  Created by IntelliJ IDEA.
  User: HP
  Date: 2019/4/28
  Time: 9:58
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>用户注册</title>
    <script src="js/md5.min.js"></script>
    <script type="text/javascript" src="js/jquery-3.4.0.js"></script>
    <script type="text/javascript">

        $(function () {
            $("#username").blur(function () {
                var username = $("#username").val();
                //把用户名异步传给服务器，进行重复校验
                $.ajax({
                    data: {
                        username: username
                    },
                    url: "ckun.do",
                    type: "POST",
                    success: function (data) {
                        console.log(data);
                        var jsonData = JSON.parse(data);
                        console.log(jsonData.status, jsonData.data, jsonData.msg);
                        if (jsonData.status == 400) {
                            $("#usernameTip").html(jsonData.msg);
                        } else {
                            $("#usernameTip").html("");
                        }
                    }
                });
            });
        });

        function submitForm() {
            var pwd = $("#password").val();
            pwd = md5(pwd);
            console.log(pwd);
            $("#password").val(pwd);
            return true;
        }
    </script>
</head>
<body>
<div class="container">
    <form action="reg.do" method="post" onsubmit="return submitForm()">
        用户名：<input type="text" name="username" id="username"/><span id="usernameTip"></span><br/>
        密码：<input type="password" name="password" id="password"/><br/>
        确认密码：<input type="password" name="cpassword"/><br/>
        真实姓名：<input type="text" name="realname"/><br/>
        电话号码：<input type="text" name="phone"/><br/>
        <input type="submit" value="注册"/>
    </form>
</div>
</body>
</html>
