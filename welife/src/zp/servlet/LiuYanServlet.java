package zp.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import zp.dao.Insert;
import zp.entity.LiuYan;

@WebServlet("/LiuYanServlet")
public class LiuYanServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public LiuYanServlet() {
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
		// 获取前端的信息
		String name = request.getParameter("name");
		String message = request.getParameter("message");
		Insert insert = new Insert();
		LiuYan ly = new LiuYan();
		ly.setName(name);
		ly.setMessage(message);
		if (name.length() == 0 || name.equals("") || message.length() == 0 || message.equals("")) {
			out.println("<script> type='text/javascript'>window.alert('相关信息不能为空！');history.back()</script>");
		} else {
			if (insert.insertLiuYan(ly)) {
				out.println("<script> type='text/javascript'>window.alert('留言成功！');history.back()</script>");
			} else {
				out.println("<script> type='text/javascript'>window.alert('留言失败！');history.back()</script>");
			}
		}

	}

}
