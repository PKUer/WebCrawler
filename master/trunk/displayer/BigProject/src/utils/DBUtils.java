package utils;
import java.sql.*;
/**
 * ��ȡ���ر����ݿ���Դ�Ĺ�����
 * @author wangdr
 * Jun 26, 2012
 */
public class DBUtils {
	/**
	 * ���ܣ���ȡ���ݿ�����
	 * @return ���ػ�ȡ�������ݿ�����
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
	 * ���ܣ��ͷ��������ݿ���Դ
	 * @param conn ���Ӷ���
	 * @param st ������
	 * @param rs ���������
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
