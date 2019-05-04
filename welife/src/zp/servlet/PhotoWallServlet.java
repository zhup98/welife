package zp.servlet;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONObject;

@WebServlet("/PhotoWallServlet")
public class PhotoWallServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public PhotoWallServlet() {
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
		System.out.println("请求来了。。。");
		// 遍历文件夹得到图片文件
		// getImages(new File("../../../../img/waterFall"));
		// 用于服务器绝对位置
		
		// "C:\\Program Files\\Apache Software Foundation\\Tomcat 8.5\\webapps\\welife\\img\\waterFall"
		// "D:\\Tomcat\\apache-tomcat-8.5.38\\webapps\\welife\\img\\waterFall"
		String path = "C:\\Program Files\\Apache Software Foundation\\Tomcat 8.5\\webapps\\welife\\img\\waterFall";
		List<String> list = getImages(new File(path));
		JSONObject json = new JSONObject();
		json.put("images", list);
		out.print(json);
	}

	protected List<String> getImages(File imgFile) {
		List<String> list = new ArrayList<String>();
		File[] files = imgFile.listFiles();
		if (files != null) {
			for (File f : files) {
				if (f.isDirectory()) { // 如果是文件夹，则递归
					getImages(f);
				} else {
					// System.out.println(f.getName());
					list.add(f.getName());
				}
			}
			return list;
		}
		return null;
	}

}
