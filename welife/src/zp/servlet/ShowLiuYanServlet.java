package zp.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import zp.dao.Query;
import zp.entity.LiuYan;

@WebServlet("/ShowLiuYanServlet")
public class ShowLiuYanServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public ShowLiuYanServlet() {
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

		Query query = new Query();
		JSONObject resultJson = new JSONObject();
		JSONArray jsonArray = new JSONArray();
		List<LiuYan> lists = query.queryLiuYanMessages();
		for (int i = 0; i < lists.size(); i++) {
			LiuYan ly = lists.get(i);
			JSONObject json = new JSONObject();
			// json.put("diaryId", diary.getDiary_id());
			json.put("name", ly.getName());
			json.put("message", ly.getMessage());
			jsonArray.add(json);
		}
		resultJson.put("liuYanMessages", jsonArray);
		out.print(resultJson);
		out.flush();
		out.close();
	}

}
