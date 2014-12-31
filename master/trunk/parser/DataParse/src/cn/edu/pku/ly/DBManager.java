package cn.edu.pku.ly;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Properties;

import com.mysql.jdbc.ResultSetMetaData;


public class DBManager {
	private static Properties config = new Properties();

	private static String jdbcDriver = null;
	private static String jdbcUrl = null;
	private static String userName = null;
	private static String password = null;
	
	/*
	 * 加载驱动程序
	 */
	static
	{
		InputStream in = DBManager.class.getResourceAsStream("dbConfig.properties");
		if (in == null)
		{
			throw new RuntimeException("not found the file");
		}
		
		try
		{
			config.load(in);
			in.close();
			
			try
			{
				jdbcDriver = config.getProperty("driver");
				jdbcUrl = config.getProperty("url");
				userName = config.getProperty("user");
				password = config.getProperty("password");
				Class.forName(jdbcDriver);
			}catch(ClassNotFoundException e)
			{
				e.printStackTrace();
			}
			catch (Exception e)
			{
				e.printStackTrace();
			}

		} catch (Exception e)
		{
			e.printStackTrace();
			throw new ExceptionInInitializerError("the file load fail!");
		}

	}

	/*
	 * 获取数据库连接
	 */
	private Connection getConnection()
	{
		Connection connection = null;
		try
		{
			connection = DriverManager.getConnection(jdbcUrl, userName, password);
		} catch (Exception e)
		{
			e.printStackTrace();
		}

		return connection;
	}

	/*
	 * 执行查询
	 */
	public ResultSet executeQueryWithSqlStr(String sql)
	{
		Connection conn = getConnection();
		Statement stat = null;
		ResultSet rs = null;

		try
		{
			stat = conn.createStatement();
			rs = stat.executeQuery(sql);
		} catch (SQLException e)
		{
			e.printStackTrace();
			free(conn, stat, rs);
		} finally {
        }

		return rs;

	}

	/*
	 * 执行查询
	 */
	public ResultSet executeQueryRS(String sql, Object[] obj)
	{
		Connection conn = getConnection();
		PreparedStatement pstat = null;
		ResultSet rs = null;

		try
		{
			pstat = conn.prepareStatement(sql);
			if(null != obj){
				for (int i = 0; i < obj.length; i++)
					pstat.setObject(i + 1, obj[i]);
			}
			rs = pstat.executeQuery();
		} catch (SQLException e)
		{
			e.printStackTrace();
			free(conn, pstat, rs);
		} finally {
        }

		return rs;

	}
	
	/*
	 * 执行查询
	 */
	public List<Object> excuteQuery(String sql, Object[] obj) {
		Connection conn = getConnection();
		PreparedStatement pstat = null;
		ResultSet rs = null;

		try
		{
			pstat = conn.prepareStatement(sql);
			if(obj != null){
				for (int i = 0; i < obj.length; i++)
					pstat.setObject(i + 1, obj[i]);
			}

			rs = pstat.executeQuery();
		} catch (SQLException e)
		{
			e.printStackTrace();
			free(conn, pstat, rs);
		} finally {
			
        }

		// 创建ResultSetMetaData对象  
        ResultSetMetaData rsmd = null;
        // 结果集列数  
        int columnCount = 0; 
        
        try {  
            rsmd = (ResultSetMetaData) rs.getMetaData();  
              
            // 获得结果集列数  
            columnCount = rsmd.getColumnCount();  
        } catch (SQLException e) {  
            e.printStackTrace(); 
        }
		
		List<Object> list = new ArrayList<Object>();
		 try {  
	            // 将ResultSet的结果保存到List中  
	            while (rs.next()) {  
	                Map<String, Object> map = new HashMap<String, Object>();  
	                for (int i = 1; i <= columnCount; i++) {  
	                    map.put(rsmd.getColumnLabel(i), rs.getObject(i));  
	                }  
	                list.add(map);  
	            }  
	        } catch (SQLException e) {  
	            System.out.println(e.getMessage());  
	        } finally {  
	            // 关闭所有资源  
	        	free(conn, pstat, rs);
	        }  

		return list;
		
	}

	/*
	 * 执行查询
	 */
	public boolean isExist(String sql, Object[] obj)
	{
		Connection conn = getConnection();
		PreparedStatement pstat = null;
		ResultSet rs = null;
		int count = 0;
		try
		{
			pstat = conn.prepareStatement(sql);
			for (int i = 0; i < obj.length; i++)
				pstat.setObject(i + 1, obj[i]);

			rs = pstat.executeQuery();
			rs.last();
			count = rs.getRow();

		} catch (SQLException e)
		{
			e.printStackTrace();
			free(conn, pstat, rs);
		} finally {
            free(conn, pstat, rs);
        }

		if (count >= 1)
			return true;
		else
			return false;
	}

	/*
	 * 执行更新操作
	 */
	public int executeUpdateQuery(String sql, Object[] obj)
	{
		Connection conn = getConnection();
		PreparedStatement pstat = null;
		int result = 0;

		try
		{
			pstat = conn.prepareStatement(sql);
			for (int i = 0; i < obj.length; i++)
				pstat.setObject(i + 1, obj[i]);

			result = pstat.executeUpdate();
		} catch (SQLException e)
		{
			e.printStackTrace();
			free(conn, pstat, null);
		} finally {
            free(conn, pstat, null);
        }

		return result;
	}

	/*
	 * 释放连接
	 */
	private void free(Connection conn)
	{

		try
		{
			if (conn != null)
				conn.close();
		} catch (SQLException e)
		{
			e.printStackTrace();
		}
	}

	/*
	 * 释放stat
	 */
	private void free(Statement stat)
	{

		try
		{
			if (stat != null)
				stat.close();
		} catch (SQLException e)
		{
			e.printStackTrace();
		}
	}

	/*
	 * 释放结果集
	 */
	private void free(ResultSet rs)
	{

		try
		{
			if (rs != null)
				rs.close();
		} catch (SQLException e)
		{
			e.printStackTrace();
		}
	}

	private void free(Connection conn, Statement stat, ResultSet rs)
	{
		free(rs);
		free(stat);
		free(conn);
	}
}
