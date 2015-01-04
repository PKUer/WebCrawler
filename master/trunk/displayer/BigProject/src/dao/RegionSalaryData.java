package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import utils.DBUtils;
import entity.HighCharts;
import entity.RegionSalary;

public class RegionSalaryData {
	
	public ArrayList<Double> getRegionSalaryData(int dist,int type) {
		ArrayList<Double> list = new ArrayList<Double>();
     
        Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		//1、组成sql语句
        try{
			conn = DBUtils.getConnection();
			System.out.println("---in update checkout");
			//System.out.println("kkkkkk---"+distriction);
			//2、更新数据checkout
			String sql = "select salary from analysisresult where city=? and type=? order by positionName";
			ps = conn.prepareStatement(sql);
			
			
			ps.setInt(1,dist);
			ps.setInt(2,type);
			System.out.println(sql);
			
			rs = ps.executeQuery();
			System.out.println(rs.toString());
			
			while(rs.next()){
				double temp;
				temp=rs.getDouble("salary");
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

