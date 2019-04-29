package servlet;

import entity.User;
import service.UserService;
import service.impl.UserServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "RegisterServlet")
public class RegisterServlet extends HttpServlet {
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        request.setCharacterEncoding("utf-8");
        //读取参数
        String username=request.getParameter("username");
        String password=request.getParameter("password");
        String realname=request.getParameter("realname");
        String phone=request.getParameter("phone");

        //实例化User
        User user= new User(0,username,password,realname,phone);

        //实例化UserService
        UserService userService=new UserServiceImpl();
        //
        boolean isok=userService.register(user);

        String msg="";
        String url="";
        if (isok){
            msg="恭喜你，注册成功！";
            String jumpUrl="login.jsp";
            request.setAttribute("jumpUrl",jumpUrl);
            url="success.jsp";
        }else{
            msg="对不起，注册失败，请重试！";
            url="fail.jsp";
        }

        request.setAttribute("msg",msg);
        request.getRequestDispatcher(url).forward(request,response);

    }

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
