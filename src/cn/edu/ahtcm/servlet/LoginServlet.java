package cn.edu.ahtcm.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.codec.digest.DigestUtils;

import cn.edu.ahtcm.bean.User;
import cn.edu.ahtcm.dao.UserDao;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
     
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	    String name = request.getParameter("name");
        String password = request.getParameter("password");
        System.out.println(name);
        System.out.println(password);
        UserDao dao = new UserDao();
        User u = dao.existUser(name, password);
        if (u!=null){
            request.getSession().setAttribute("user", u);
            response.sendRedirect("/admin/manage.jsp");  
        }else{
            //String errorMessage = "用户名或密码错误";
            request.setAttribute("error", "无法登录");
            //response.sendRedirect("/error.jsp");
            request.getRequestDispatcher("/error.jsp").forward(request, response);
        }
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
