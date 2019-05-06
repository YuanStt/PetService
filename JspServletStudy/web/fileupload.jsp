<%--
  Created by IntelliJ IDEA.
  User: HP
  Date: 2019/5/5
  Time: 17:11
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>文件上传</title>
</head>
<body>
<form action="upload.do" method="post" enctype="multipart/form-data">
    <input type="file" name="picture" />
    <input type="text" name="filename" />
    <input type="submit" />
</form>
</body>
</html>
