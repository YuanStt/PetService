package servlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Random;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUpload;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.RequestContext;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.FileCleanerCleanup;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.apache.commons.fileupload.servlet.ServletRequestContext;
import org.apache.commons.io.FileCleaningTracker;
import org.apache.commons.io.FilenameUtils;
import org.apache.commons.lang3.ArrayUtils;


@WebServlet(name = "UploadServlet")
public class UploadServlet extends HttpServlet {

    /** 允许上传的扩展名 */
    private static final String[] extensionPermit = { "jpg", "png", "gif" };
    // 新文件的名字
    private String newFileName = "";

    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        request.setCharacterEncoding("utf-8");
        response.setCharacterEncoding("utf-8");

        // 读取目录路径
        String curProjectPath = this.getServletContext().getRealPath("/");
        String saveDirectoryPath = curProjectPath + "/upload";
        String tempDirectoryPath = curProjectPath + "/tmp";
        File saveDirectory = new File(saveDirectoryPath);
        File tempDirectory = new File(tempDirectoryPath);

        RequestContext requestContext = new ServletRequestContext(request);

        if (FileUpload.isMultipartContent(requestContext)) {
            DiskFileItemFactory factory = new DiskFileItemFactory();
            // DiskFileItemFactory中DEFAULT_SIZE_THRESHOLD=10240表示如果上传文件大于10K则会产生上传临时文件
            // 重新设置临时文件保存目录
            factory.setRepository(tempDirectory);

            // 设置文件清除追踪器，文件上传过程中产生的临时文件会在
            FileCleaningTracker fileCleaningTracker = FileCleanerCleanup
                    .getFileCleaningTracker(this.getServletContext());
            factory.setFileCleaningTracker(fileCleaningTracker);

            ServletFileUpload upload = new ServletFileUpload(factory);
            // 设置文件上传的大小限制 20M
            upload.setSizeMax(20 * 1024 * 1024);

            // 解析请求包
            List items = new ArrayList();
            try {
                items = upload.parseRequest(request);

                Iterator it = items.iterator();
                while (it.hasNext()) {
                    FileItem fileItem = (FileItem) it.next();

                    if (fileItem.isFormField()) { // 表单数据
                        System.out.println(fileItem.getFieldName() + "   " + fileItem.getName() + "   "
                                + new String(fileItem.getString().getBytes("iso8859-1"), "utf-8") + "   "
                                + fileItem.getString());
                    } else { // 文件域，读取文件名。

                        if (fileItem.getSize() > 0) {
                            //获取文件后缀名
                            String fileExtension = FilenameUtils.getExtension(fileItem.getName());
                            if (!ArrayUtils.contains(extensionPermit, fileExtension)) {
                                throw new FileUploadException("No Support extension.");		//抛出一个不支持的错误
                            }

                            //打印上传文件的原始信息
                            System.out.println(fileItem.getFieldName() + "   " + fileItem.getName() + "   "
                                    + fileExtension + "   " + fileItem.isInMemory() + "    " + fileItem.getContentType()
                                    + "   " + fileItem.getSize());

                            if (fileItem.getName() != null && fileItem.getSize() != 0) {

                                //生成随机名字
                                String ext=FilenameUtils.getExtension(fileItem.getName());
                                String randomString=String.format("%06d",new Random().nextInt(100001));
                                newFileName=System.currentTimeMillis()+randomString+"."+ext;


//								File fullFile = new File(fileItem.getName());
                                File fullFile = new File(newFileName);
                                File newFile = new File(saveDirectory, fullFile.getName());
                                try {
                                    fileItem.write(newFile);
                                    System.out.println("成功了，"+fullFile.getName());
                                    //把文件的名称写入到数据库。

                                } catch (Exception e) {
                                    e.printStackTrace();
                                }
                            } else {
                                System.out.println("文件没有选择 或 文件内容为空");
                            }
                        }
                    }
                }

            } catch (FileUploadException e1) {
                System.out.println("文件上传发生错误：" + e1.getMessage());
            }
        }

        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        out.println("<!DOCTYPE HTML PUBLIC \"-//W3C//DTD HTML 4.01 Transitional//EN\">");
        out.println("<HTML>");
        out.println(" <HEAD><TITLE>A Servlet</TITLE></HEAD>");
        out.println(" <BODY>");
        out.println(newFileName);
        out.println(" </BODY>");
        out.println("</HTML>");
        out.flush();
        out.close();

    }

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        out.println("<!DOCTYPE HTML PUBLIC \"-//W3C//DTD HTML 4.01 Transitional//EN\">");
        out.println("<HTML>");
        out.println("  <HEAD><TITLE>A Servlet</TITLE></HEAD>");
        out.println("  <BODY>");
        out.println(" Get方法不支持！");
        out.println("  </BODY>");
        out.println("</HTML>");
        out.flush();
        out.close();

    }
}
