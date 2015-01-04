package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import utils.DBUtils;

public class RegionNumberData {
	
	public ArrayList<Integer> getRegionNumberData(int dist,int type) {
		ArrayList<Integer> list = new ArrayList<Integer>();
     
        Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		//1、组成sql语句
        try{
			conn = DBUtils.getConnection();
			System.out.println("---in update checkout");
			//System.out.println("kkkkkk---"+distriction);
			//2、更新数据checkout
			String sql = "select peopleNum from analysisresult where city=? and type=? order by positionName";
			ps = conn.prepareStatement(sql);
			
			
			ps.setInt(1,dist);
			ps.setInt(2,type);
			System.out.println(sql);
			
			rs = ps.executeQuery();
			System.out.println(rs.toString());
			
			while(rs.next()){
				int temp;
				temp=rs.getInt("peopleNum");
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
