package servlet;

import entity.Student;
import service.StudentService;
import service.impl.StudentServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "UpdateStuServlet")
public class UpdateStuServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
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
        String msg="";
        String url="";
        if (isok) {
            msg="修改成功！";
            url="success.jsp";
            String jumpUrl="allstudents.do";
            request.setAttribute("jumpUrl",jumpUrl);
        }else{
            msg="修改失败！";
            url="fail.jsp";
        }
        request.setAttribute("msg",msg);
        request.getRequestDispatcher(url).forward(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }
}
