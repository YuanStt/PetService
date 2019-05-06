package servlet;

import service.StudentService;
import service.impl.StudentServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "DelStuServlet")
public class DelStuServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        //获取学生Id
        String stuId = request.getParameter("stuId");
        //转化Id为整形
        int iStuId = Integer.parseInt(stuId);

        //实例Service
        StudentService studentService = new StudentServiceImpl();
        boolean isok = studentService.delete(iStuId);
        String msg="";
        String url="";
        if (isok) {
            msg="删除成功！";
            url="success.jsp";
            String jumpUrl="studentspage.do";
            request.setAttribute("jumpUrl",jumpUrl);
        }else{
            msg="删除失败！";
            url="fail.jsp";
        }
        request.setAttribute("msg",msg);
        request.getRequestDispatcher(url).forward(request,response);

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }
}
