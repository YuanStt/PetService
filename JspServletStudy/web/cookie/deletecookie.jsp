<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>删除Cookie</title>
</head>
<body>
<%
	//用设置替换删除
	Cookie cookie=new Cookie("username",null);
	//生存周期设置为0
	cookie.setMaxAge(0);
	response.addCookie(cookie);
 %>
</body>
</html>