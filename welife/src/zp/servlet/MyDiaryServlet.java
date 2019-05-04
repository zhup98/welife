package zp.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import zp.dao.Query;
import zp.entity.Diary;

@WebServlet("/MyDiaryServlet")
public class MyDiaryServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public MyDiaryServlet() {
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
		SimpleDateFormat sim = new SimpleDateFormat("yyyy-MM-dd");
		HttpSession session = request.getSession();

		JSONObject resultJson = new JSONObject();
		JSONArray jsonArray = new JSONArray();
		Query query = new Query();
		String username = (String) session.getAttribute("user");

		List<Diary> myDiarys = query.queryMyDiarys(username);
		for (int i = 0; i < myDiarys.size(); i++) {
			Diary diary = myDiarys.get(i);
			JSONObject json = new JSONObject();
			// json.put("diaryId", diary.getDiary_id());
			json.put("username", diary.getUsername());
			json.put("title", diary.getTitle());
			Date date = diary.getDate();
			json.put("date", sim.format(date)); // Ò»¶¨Òª×Ö·û´®
			json.put("content", diary.getContent());
			jsonArray.add(json);
		}
		resultJson.put("myDiary", jsonArray);
		out.print(resultJson);
		out.flush();
		out.close();
	}

}
