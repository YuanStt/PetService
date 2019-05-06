package servlet;

import com.fasterxml.jackson.databind.ObjectMapper;
import entity.JsonMsg;
import service.UserService;
import service.impl.UserServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "CheckUsernameServlet")
public class CheckUsernameServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        String username = request.getParameter("username");
        //通过username，调用service，进行判断，判断的方式就是和数据库对比。统计有这个username的用户的记录条数。
        UserService userService = new UserServiceImpl();
        boolean isok = userService.countByUsername(username);
        JsonMsg jsonMsg = null;
        if (isok) {
            jsonMsg = JsonMsg.makeSuccess("", null);
        } else {
            jsonMsg = JsonMsg.makeFail("用户名已存在！", null);
        }
        //序列化jsonMsg
        ObjectMapper objectMapper = new ObjectMapper();
        String writeValueAsString = objectMapper.writeValueAsString(jsonMsg);
        out.println(writeValueAsString);
        out.flush();
        out.close();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }
}
