package zp.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;

import zp.database.Database;
import zp.entity.Diary;
import zp.entity.LiuYan;
import zp.entity.User;

public class Insert {
	private Database data = new Database();
	private PreparedStatement st = null;
	private SimpleDateFormat sim = new SimpleDateFormat("yyyy-MM-dd");

	public boolean insertUser(User user) {
		String sql = "insert into user values (?,?,?)";
		try {
			st = data.connect().prepareStatement(sql);
			st.setInt(1, user.getId());
			st.setString(2, user.getUsername());
			st.setString(3, user.getPassword());
			st.executeUpdate();
			return true;
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			data.closeCon();
		}
		return false;
	}

	public boolean insertDiary(Diary diary) {
		String sql = "insert into diary values (?,?,?,?,?)";
		try {
			st = data.connect().prepareStatement(sql);
			st.setInt(1, diary.getDiary_id());
			st.setString(2, diary.getUsername());
			st.setDate(3, diary.getDate());
			st.setString(4, diary.getTitle());
			st.setString(5, diary.getContent());
			st.executeUpdate();
			return true;
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			data.closeCon();
		}
		return false;
	}

	// ÃÌº”¡Ù—‘–≈œ¢
	public boolean insertLiuYan(LiuYan ly) {
		String sql = "insert into liuyan values (?,?,?)";
		try {
			st = data.connect().prepareStatement(sql);
			st.setInt(1, ly.getLiuyan_id());
			st.setString(2, ly.getName());
			st.setString(3, ly.getMessage());
			st.executeUpdate();
			return true;
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			data.closeCon();
		}
		return false;
	}
}
