package servlet;

import entity.Student;
import service.StudentService;
import service.impl.StudentServiceImpl;
import vo.PageModel;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "AllStudentByPageServlet")
public class AllStudentByPageServlet extends HttpServlet {

    private final static String PAGESIZE="2";

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        //获取currPage和pageSize

        String currPage=request.getParameter("currPage");
        if(currPage==null){
            currPage="1";
        }
        String pageSize=request.getParameter("pageSize");
        if(pageSize==null){
            pageSize=PAGESIZE;
        }

        int iCurrPage=1;
        int iPageSize=Integer.parseInt(PAGESIZE);
        try {
            //进行转整形
            iCurrPage=Integer.parseInt(currPage);
            iPageSize=Integer.parseInt(pageSize);
        } catch (NumberFormatException e) {
            e.printStackTrace();
        }
        if(iCurrPage<1)iCurrPage=1;
        if(iPageSize<1)iPageSize=Integer.parseInt(PAGESIZE);

        StudentService studentService=new StudentServiceImpl();
        List<Student> list = studentService.findByPage(iCurrPage, iPageSize);

        //总页数的计算
        //记录总条数
        int totalCount=studentService.count();
        //计算总页数
        int totalPage=countTotalPage(totalCount, iPageSize);

        PageModel<Student> pageModel=new PageModel<Student>();
        pageModel.setList(list);
        pageModel.setCurrPage(iCurrPage);
        pageModel.setPageSize(iPageSize);
        pageModel.setTotalCount(totalCount);
        pageModel.setTotalPage(totalPage);
        request.setAttribute("pageModel", pageModel);

        /*request.setAttribute("list", list);
        request.setAttribute("currPage", iCurrPage);
        request.setAttribute("pageSize", iPageSize);
        request.setAttribute("totalCount", totalCount);
        request.setAttribute("totalPage", totalPage);*/
        request.getRequestDispatcher("allStudentsPage.jsp").forward(request, response);

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }

    private int countTotalPage(int totalCount,int pageSize){
        return totalCount%pageSize>0?totalCount/pageSize+1:totalCount/pageSize;
    }
}
