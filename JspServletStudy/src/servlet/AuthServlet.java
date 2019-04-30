package servlet;

import entity.User;
import service.UserService;
import service.impl.UserServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet(name = "AuthServlet")
public class AuthServlet extends HttpServlet {
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        request.setCharacterEncoding("utf-8");
        String username= request.getParameter("username");
        String password= request.getParameter("password");

        //实例UserService完成验证
        UserService userService=new UserServiceImpl();
        User user=userService.findByUsername(username);

        String url="";
        String msg="";
        if (user!=null){
            if (user.getPassword().equals(password)){
                //验证成功
                //验证成功，我们把用户的信息存入到session中
                //清空密码
                user.setPassword(null);
                //取得Session
                HttpSession session = request.getSession();
                //保存
                session.setAttribute("user",user);
                //进行跳转，跳转到用户的主页面，welcome.jsp
                msg="登录成功";
                url="success.jsp";
                String jumpUrl="allstudents.do";
                request.setAttribute("jumpUrl",jumpUrl);
            }else{
                //密码输错了
                msg="用户名或密码输错了！请重试！";
                url="fail.jsp";
            }
        }else{
            //user为空指针，说明用户名写错了，我们没有找到该用户名的用户
            msg="用户名或密码错误！请重试！";
            url="fail.jsp";
        }
        request.setAttribute("msg",msg);
        //进行分发转跳
        request.getRequestDispatcher(url).forward(request,response);

    }

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }
}
