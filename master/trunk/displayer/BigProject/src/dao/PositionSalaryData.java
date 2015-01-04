package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import utils.DBUtils;
import entity.HighCharts;

import java.util.ArrayList;
import java.util.List;

public class PositionSalaryData {

	public List<HighCharts> getPosSalary(int dist,int type) {
        List<HighCharts> list = new ArrayList<HighCharts>();
     
        Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		//1、组成sql语句
        try{
			conn = DBUtils.getConnection();
			System.out.println("---in update checkout");
			//System.out.println("kkkkkk---"+distriction);
			//2、更新数据checkout
			String sql = "select positionName,salary from analysisresult where type=? and city=?";
			ps = conn.prepareStatement(sql);
			
			
			ps.setInt(1,dist);
			ps.setInt(2,type);
			System.out.println(sql);
			
			rs = ps.executeQuery();
			System.out.println(rs.toString());
			
			while(rs.next()){
				HighCharts temp = new HighCharts();
				
				temp.setName(rs.getString("positionName"));
				temp.setValue(rs.getDouble("salary"));
		        System.out.println(rs.getString("positionName"));
		        System.out.println(rs.getString("salary"));
		        list.add(temp);
			}
			
		}catch(SQLException e){
			e.printStackTrace();
		}finally{
			DBUtils.closeAll(conn, ps, null);
		}
		
		return list.size()>0?list:null;
	}
}
