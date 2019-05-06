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

@WebServlet(name = "AddStuServlet")
public class AddStuServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        request.setCharacterEncoding("utf-8");
        String stuNo=request.getParameter("stuNo");
        String stuName=request.getParameter("stuName");
        String stuBirthday = request.getParameter("stuBirthday");
        String stuPhone = request.getParameter("stuPhone");
        String stuAddress = request.getParameter("stuAddress");
        String stuHeight = request.getParameter("stuHeight");

        //构造实体类
        Student student = new Student(0, stuNo, stuName, stuBirthday, stuPhone, stuAddress, stuHeight);
        //实例Serveice
        StudentService studentService = new StudentServiceImpl();
        //保存学生
        boolean isok = studentService.save(student);
        String msg="";
        String url="";
        if (isok){
            msg="保存成功！";
            url="success.jsp";
            String jumpUrl="studentspage.do";
            request.setAttribute("jumpUrl",jumpUrl);
        }else{
            msg="保存失败！";
            url="fail.jsp";
        }
        request.setAttribute("msg",msg);
        request.getRequestDispatcher(url).forward(request,response);

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
