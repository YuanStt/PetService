<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>获取Cookie</title>
</head>
<body>
<%
	Cookie[] cs=request.getCookies();
	for(Cookie cookie:cs){
		out.print(cookie.getName()+":"+cookie.getValue());
		out.println("<br/>");
	}
 %>
</body>
</html>