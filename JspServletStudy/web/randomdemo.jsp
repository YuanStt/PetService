<%@ page import="java.util.regex.Pattern" %>
<%@ page import="java.util.regex.Matcher" %>
<%@ page import="java.util.Random" %><%--
  Created by IntelliJ IDEA.
  User: HP
  Date: 2019/4/26
  Time: 14:41
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>猜数字</title>
</head>
<body>
<%!
    int result = new Random().nextInt(100);
    void resume(){
        result=new Random().nextInt(100);
    }
%>
<div class="container">
    <form action="randomdemo.jsp" method="post">
        <label>请输入0-99的整数:</label>
        <input type="number" name="random" min="0" max="99">
        <input type="submit">
    </form>
    <%
        //request传递的参数全部都是字符串
        request.setCharacterEncoding("utf-8");
        String random = request.getParameter("random");
        //将字符串转成数字
        if (random != null) {   //避免第一次进入页面，表单还未提交数据，num即为null
            int iNum = Integer.parseInt(random);        //把字符串转成数字
            if (iNum > result) {
                out.println("大了");
            } else if (iNum < result) {
                out.println("小了");
            } else {
                out.println("相等");
                resume();
            }
        }
    %>
</div>

</body>
</html>
