package utils;
import java.sql.*;
/**
 * 获取及关闭数据库资源的工具类
 * @author wangdr
 * Jun 26, 2012
 */
public class DBUtils {
	/**
	 * 功能：获取数据库连接
	 * @return 返回获取到的数据库连接
	 */
	public static Connection getConnection(){
		Connection conn = null;
		
		String driver = "com.mysql.jdbc.Driver";
		String url = "jdbc:mysql://localhost:3306/test";
		String username = "root";
		String password = "root";
		try{
			Class.forName(driver);
			conn = DriverManager.getConnection(url, username, password);
			if(conn!=null)
			System.out.println("kkkkk");
		}catch(ClassNotFoundException e){
			e.printStackTrace();
		}catch(SQLException e){
			e.printStackTrace();
		}
		
		return conn;
	}
	
	/**
	 * 功能：释放所有数据库资源
	 * @param conn 连接对象
	 * @param st 语句对象
	 * @param rs 结果集对象
	 */
	public static void closeAll(Connection conn, Statement st, ResultSet rs){
		try{
			if(rs != null){
				rs.close();
			}
			if(st != null){
				st.close();
			}
			if(conn != null){
				conn.close();
			}
		}catch(SQLException e){
			e.printStackTrace();
		}
	}
}
