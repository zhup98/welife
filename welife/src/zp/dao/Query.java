package zp.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import zp.database.Database;
import zp.entity.Diary;
import zp.entity.LiuYan;
import zp.entity.User;

public class Query {
	private Database data = new Database();
	private PreparedStatement st = null;
	private ResultSet rs = null;

	// 判断用户名是否重复
	public boolean CheckRegister(String username) {
		String sql = "select username from user where username = ?";
		try {
			st = data.connect().prepareStatement(sql);
			st.setString(1, username);
			rs = st.executeQuery();
			while (rs.next()) {
				return false;
			}
			return true;
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			data.closeCon();
		}
		return false;
	}

	public boolean CheckLogin(User user) {
		String sql = "select * from user where username = ? and password =?";
		try {
			st = data.connect().prepareStatement(sql);
			st.setString(1, user.getUsername());
			st.setString(2, user.getPassword());
			rs = st.executeQuery();
			while (rs.next()) {
				return true;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			data.closeCon();
		}
		return false;
	}

	public static void main(String[] args) {
		Query query = new Query();
		System.out.println(query.CheckRegister("张三"));
	}
	// 查询所有日记信息 -------------》 用于日记墙

	public List<Diary> queryAllDiarys() {
		String sql = "select * from diary";
		List<Diary> diaryList = new ArrayList<Diary>();
		try {
			st = data.connect().prepareStatement(sql);
			rs = st.executeQuery();
			while (rs.next()) {
				Diary diary = new Diary();
				diary.setDiary_id(rs.getInt("diary_id"));
				diary.setUsername(rs.getString("username"));
				diary.setDate(rs.getDate("date"));
				diary.setTitle(rs.getString("title"));
				diary.setContent(rs.getString("content"));

				diaryList.add(diary);
			}
			return diaryList;
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			data.closeCon();
		}
		return null;
	}

	// 查询个人日记信息 -------------》 用于个人日记
	public List<Diary> queryMyDiarys(String username) {
		String sql = "select * from diary where username = ?";
		List<Diary> diaryList = new ArrayList<Diary>();
		try {
			st = data.connect().prepareStatement(sql);
			st.setString(1, username);
			rs = st.executeQuery();
			while (rs.next()) {
				Diary diary = new Diary();
				diary.setDiary_id(rs.getInt("diary_id"));
				diary.setUsername(rs.getString("username"));
				diary.setDate(rs.getDate("date"));
				diary.setTitle(rs.getString("title"));
				diary.setContent(rs.getString("content"));

				diaryList.add(diary);
			}
			return diaryList;
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			data.closeCon();
		}
		return null;
	}
	
	// 查询留言信息
	public List<LiuYan> queryLiuYanMessages() {
		String sql = "select * from liuyan";
		List<LiuYan> liuYanList = new ArrayList<LiuYan>();
		try {
			st = data.connect().prepareStatement(sql);
			rs = st.executeQuery();
			while (rs.next()) {
				LiuYan ly = new LiuYan();
				ly.setLiuyan_id(rs.getInt("liuyan_id"));
				ly.setName(rs.getString("name"));
				ly.setMessage(rs.getString("message"));
				liuYanList.add(ly);
			}
			return liuYanList;
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			data.closeCon();
		}
		return null;
	}
}
