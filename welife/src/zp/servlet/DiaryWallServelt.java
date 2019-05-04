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

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import zp.dao.Query;
import zp.entity.Diary;

@WebServlet("/DiaryWallServelt")
public class DiaryWallServelt extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public DiaryWallServelt() {
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

		JSONObject resultJson = new JSONObject();
		JSONArray jsonArray = new JSONArray();

		Query query = new Query();
		List<Diary> diaryList = query.queryAllDiarys(); // 查询所有日记信息
		for (int i = 0; i < diaryList.size(); i++) {// 遍历
			Diary diary = diaryList.get(i);
			JSONObject json = new JSONObject();
//			json.put("diaryId", diary.getDiary_id());
			json.put("username", diary.getUsername());
			json.put("title", diary.getTitle());
			Date date = diary.getDate();
			json.put("date", sim.format(date)); // 一定要字符串
			json.put("content", diary.getContent());
			jsonArray.add(json);
		}
		resultJson.put("diary", jsonArray);
		System.out.println(jsonArray);
		out.print(resultJson);
		out.flush();
		out.close();
	}

}
