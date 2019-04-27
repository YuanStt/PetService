<%@ page import="service.impl.StudentServiceImpl" %>
<%@ page import="service.StudentService" %><%--
  Created by IntelliJ IDEA.
  User: HP
  Date: 2019/4/26
  Time: 17:25
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>删除学生</title>
</head>
<body>
<%
    //获取学生Id
    String stuId = request.getParameter("stuId");
    //转化Id为整形
    int iStuId = Integer.parseInt(stuId);

    //实例Service
    StudentService studentService = new StudentServiceImpl();
    boolean isok = studentService.delete(iStuId);
    if (isok) {
%>
<script type="text/javascript">
    alert("删除成功！");
</script>
<%
} else {
%>
<script type="text/javascript">
    alert("删除失败！");
</script>
<%
    }
%>
<script type="text/javascript">
    window.location.href = "students2.jsp";
</script>
</body>
</html>
