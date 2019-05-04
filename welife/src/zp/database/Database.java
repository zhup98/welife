package zp.database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;


public class Database {
	public static Connection con;
	private PreparedStatement st;
	private ResultSet rs;
	
	public Connection connect() throws SQLException{
		String username = "root";
		String password = "";
		try {
			Class.forName("com.mysql.jdbc.Driver");
			String url = "jdbc:mysql://localhost:3306/welife?characterEncoding=UTF-8&characterSetResults=UTF-8";
			con = DriverManager.getConnection(url, username, password);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		return con;
	}
	//关闭数据库
	public void closeCon(){
		if(con != null){
			try {
				con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		if(st != null){
			try {
				st.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		if(rs != null){
			try {
				rs.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}

	/*public static void main(String[] args) throws SQLException {
		Database data = new Database();
		data.connect();
		String sql = "select * from user";
//		st.setString(1, "张三");
//		st.setString(2, "123");
		st = con.prepareStatement(sql);
		rs = st.executeQuery();
		while (rs.next()) {
			System.out.println(rs.getString("username"));
		}
		data.closeCon();
	}*/
}
