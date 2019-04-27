<%--
  Created by IntelliJ IDEA.
  User: HP
  Date: 2019/4/26
  Time: 11:17
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head>
    <title>循环输出100表格</title>
    <link rel="stylesheet" href="css/bootstrap.css">
    <script type="text/javascript" src="js/jquery-3.4.0.js"></script>

</head>
<body>
<div class="container">
    <table class="table table-bordered table-hover">
        <%
            /**
             *
             */
            String color;
            for (int i=1;i<101;i++){
                if (i%3==0){
                    color="success";
                }else if (i%3==1){
                    color="warning";
                }else{
                    color="info";
                }
        %>

        <tr>
            <td class="<%=color %>">第<%= i %>行</td>
        </tr>
        <%
            }
        %>


    </table>
</div>
</body>
</html>
