<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>新增cookie</title>
</head>
<body>
	<%
		
		//实例Cookie
		Cookie cookie=new Cookie("username","jd");
		//设置Cookie的生存周期，24*60*60秒
		cookie.setMaxAge(24*60*60);
		//response添加到客户端
		response.addCookie(cookie);
		
	 %>
</body>
</html>