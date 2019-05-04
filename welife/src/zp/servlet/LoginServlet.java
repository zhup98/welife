package zp.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import zp.dao.Query;
import zp.entity.User;

@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public LoginServlet() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("utf-8"); // 1
		response.setContentType("text/html;charset=utf-8"); // 2
		response.setCharacterEncoding("utf-8"); // 3
		PrintWriter out = response.getWriter();
		HttpSession session = request.getSession();

		// 获取字段信息
		String username = request.getParameter("username");
		String password = request.getParameter("password");

		User user = new User();
		Query query = new Query();
		user.setUsername(username);
		user.setPassword(password);
		// 判断是否为空
		if (username.equals("") || username.length() == 0 || password.equals("") || password.length() == 0) {
			out.println("<script> type='text/javascript'>window.alert('用户名或密码不能为空！');history.back()</script>");
		} else {
			if (query.CheckLogin(user)) {
				session.setAttribute("user", username);
				out.println(
						"<script> type='text/javascript'>window.alert('登录成功！');window.location.href='home.jsp'</script>");
			} else {
				out.println("<script> type='text/javascript'>window.alert('用户名或密码错误！');history.back()</script>");
			}
		}

	}

}
