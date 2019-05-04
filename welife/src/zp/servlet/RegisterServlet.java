package zp.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import zp.dao.Insert;
import zp.dao.Query;
import zp.entity.User;

@WebServlet("/RegisterServlet")
public class RegisterServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public RegisterServlet() {
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

		User user = new User();
		Insert insert = new Insert();
		Query query = new Query();

		String username = request.getParameter("username");
		String password1 = request.getParameter("password1");
		String password2 = request.getParameter("password2");

		if (username.length() == 0 || username.equals("") || password1.length() == 0 || password1.equals("")
				|| password2.length() == 0 || password2.equals("")) {
			out.println("<script> type='text/javascript'>window.alert('�û��������벻��Ϊ�գ�');history.back()</script>");
		}else {
			if(password1.trim().equals(password2.trim())) {
				// �������һ�£������ж��Ƿ�����
				if(query.CheckRegister(username)) {
					user.setUsername(username);
					user.setPassword(password1);
					if(insert.insertUser(user)) {
						out.println("<script> type='text/javascript'>window.alert('ע��ɹ���');window.location.href='index.jsp'</script>");
					}else {
						out.println("<script> type='text/javascript'>window.alert('ע��ʧ�ܣ�');history.back()</script>");
					}
				}else {
					out.println("<script> type='text/javascript'>window.alert('��������ע�ᣡ');history.back()</script>");
				}
			}else {
				out.println("<script> type='text/javascript'>window.alert('���벻һ�£�');history.back()</script>");
			}
		}
	}

}
