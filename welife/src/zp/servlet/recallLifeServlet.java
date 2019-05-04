package zp.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import zp.dao.Insert;
import zp.entity.Diary;

@WebServlet("/recallLifeServlet")
public class recallLifeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public recallLifeServlet() {
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
		SimpleDateFormat sim = new SimpleDateFormat("yyyy-MM-dd");

		PrintWriter out = response.getWriter();
		HttpSession session = request.getSession();

		String title = request.getParameter("title");
		String time = request.getParameter("time");
		String username = (String) session.getAttribute("user"); // 获取已经登录的用户名
		String content = request.getParameter("area"); // 获取内容

		Insert insert = new Insert();
		Diary diary = new Diary();
		diary.setUsername(username);
		diary.setDate(Date.valueOf(time));
		diary.setTitle(title);
		diary.setContent(content);

		if (title.length() == 0 || title.equals("") || content.length() == 0 || content.equals("")) {
			out.println("<script> type='text/javascript'>window.alert('标题或内容不能为空！');window.history.back()</script>");
		} else {
			if (username == null) {
				out.println("<script> type='text/javascript'>window.alert('请先登录！');window.location.href='index.jsp'</script>");
			} else {
				if (insert.insertDiary(diary)) {
					out.println("<script> type='text/javascript'>window.alert('写入成功！');window.location.href='myDiary.jsp'</script>");
				} else {
					out.println("<script> type='text/javascript'>window.alert('写入失败！');window.history.back()</script>");
				}
			}

		}
	}

}
