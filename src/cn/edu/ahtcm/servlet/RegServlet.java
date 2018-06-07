package cn.edu.ahtcm.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.codec.digest.DigestUtils;

import cn.edu.ahtcm.bean.User;
import cn.edu.ahtcm.dao.UserDao;


/**
 * @author hufoxcn@qq.com
 * 2018年5月26日
 * version 1.0
 */
@WebServlet("/RegServlet")
public class RegServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	    String name = request.getParameter("name");
	    String password = request.getParameter("password");
	    System.out.println(name);
	    System.out.println(password);
	    User user = new User();
        user.setName(name);
        user.setPassword(password);
        UserDao userdao = new UserDao();
        userdao.saveUser(user);
        //response.sendRedirect("/ok.html");
        request.setAttribute("message", "注册成功");
        request.getRequestDispatcher("ok.jsp").forward(request, response);
    
	    /*
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        String title = "注册成功";
        String docType = "<!DOCTYPE html> \n";
        out.println(docType +
                "<html>\n" +
                "<head><title>" + title + "</title></head>\n" +
                "<body bgcolor=\"#f0f0f0\">\n" +
                "<h1 align=\"center\">" + title + "</h1>\n" +
                "<ul>\n" +
                "  <li><b>用户名：</b>: "
                + request.getParameter("name") + "\n" +
                "  <li><b>密码：</b>: "
                + request.getParameter("password") + "\n" +
                "</ul>\n" +
                "</body></html>");
        */
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
