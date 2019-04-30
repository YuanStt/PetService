package filter;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebFilter(filterName = "AuthFilterFilter")
public class AuthFilterFilter implements Filter {
    public void destroy() {
    }

    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws ServletException, IOException {

        //校验session中是否有对应的元素属性
        //强制转化成HttpServletRequest
        HttpServletRequest httpServletRequest = (HttpServletRequest) req;
        HttpServletResponse httpServletResponse = (HttpServletResponse) resp;
        //获得session
        HttpSession session = httpServletRequest.getSession();
        String path = httpServletRequest.getRequestURI();
        Object object = session.getAttribute("user");

        if (path.indexOf("auth.do") > -1) {//登录页面不过滤
            chain.doFilter(req, resp);//递交给下一个过滤器
        } else {


            if (object != null) {
                //说明用户登陆了
                chain.doFilter(req, resp);
            } else {
                httpServletResponse.sendRedirect("login.jsp");
            }

        }
    }

    public void init(FilterConfig config) throws ServletException {

    }

}
