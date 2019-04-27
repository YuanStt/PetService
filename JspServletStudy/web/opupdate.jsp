<%@ page import="entity.Student" %>
<%@ page import="service.StudentService" %>
<%@ page import="service.impl.StudentServiceImpl" %><%--
  Created by IntelliJ IDEA.
  User: HP
  Date: 2019/4/27
  Time: 9:03
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>修改学生信息</title>
</head>
<body>
<%

    //读取学生信息
    request.setCharacterEncoding("utf-8");
    //获取学生Id
    String stuId = request.getParameter("sid");
    //转化Id为整形
    int iStuId = Integer.parseInt(stuId);
    String stuNo = request.getParameter("stuNo");
    String stuName = request.getParameter("stuName");
    String stuBirthday = request.getParameter("stuBirthday");
    String stuPhone = request.getParameter("stuPhone");
    String stuAddress = request.getParameter("stuAddress");
    String stuHeight = request.getParameter("stuHeight");

    //构造实体类
    Student student = new Student(iStuId,stuNo, stuName, stuBirthday, stuPhone, stuAddress, stuHeight);
    //实例Serveice
    StudentService studentService = new StudentServiceImpl();
    //保存学生
    boolean isok = studentService.update(student);
    if (isok) {
%>
<script type="text/javascript">
    alert("修改成功！");
</script>
<%
} else {
%>
<script type="text/javascript">
    alert("修改失败！");
</script>
<%
    }

%>
<script type="text/javascript">
    window.location.href = "students2.jsp";
</script>
</body>
</html>
