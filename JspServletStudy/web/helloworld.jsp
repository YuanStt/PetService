<%@ page import="java.text.SimpleDateFormat" %>
<%@ page import="java.util.Date" %><%--
  Created by IntelliJ IDEA.
  User: HP
  Date: 2019/4/26
  Time: 10:20
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>你好</title>
    <link rel="stylesheet" href="css/bootstrap.css">
</head>
<body>
<div class="container">
    <h1>
        <%
            out.println("你好！");
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MMa-dd");
            String dateString = simpleDateFormat.format(new Date());
        %>
    </h1>
    <p class="text-danger">
    <h1><%= "大家好"%>
    </h1></p>
    <%= dateString %>
    <%= 3 + 2 %>
    <%= 3 == 2  %>
    <%!
        //声明，用来声明成员变量和成员方法
        int a = 0;
        void speak()
        {
            a++;
            System.out.println(a);
        };
    %>
    <%= a %>
    <hr/>

</div>
</body>
</html>
