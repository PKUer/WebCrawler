package cn.edu.pku.ly;

import java.io.File;
import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

public class Main {

	public static void main(String[] args) throws IOException, ClassNotFoundException, SQLException {
		
		DataParse parse = new DataParse();
		parse.startParse();
		
		/*
		String[] ContentKeys = {"招聘人数：","工作地点：","发布日期：","工作性质：","工作经验：","最低学历：","招聘人数：","职位类别："};
		String[] contentValues = new String[ContentKeys.length];
		
		ArrayList<String> htmlStrArray = new ArrayList<String>();
		Map<String,String> contMap = new HashMap<String,String>();
		
		Document document = null;
		Elements contKey = null;
		Elements contValue = null;
		
		File htmlSrcDir = new File("./zhaopin/jobs.zhaopin.com");  
		
		if(htmlSrcDir.exists())
		{
			//存在
			File[] lists = htmlSrcDir.listFiles();
			for(int i=0; i<lists.length; i++)
			{
				htmlStrArray.add("./zhaopin/jobs.zhaopin.com/"+lists[i].getName());
			}
		}
		else
		{
			//不存在
		}
		
		DBManager db = new DBManager();
		for(int i=0; i<htmlStrArray.size(); i++)
		{
			String url = htmlStrArray.get(i);
			File input = new File(url);
			
			document =  Jsoup.parse(input,"UTF-8");
			contKey = document.select("ul[class=terminal-ul clearfix]>li>span");
			contValue = document.select("ul[class=terminal-ul clearfix]>li>strong");
			
			for(int j=0; j<contKey.size(); j++)
			{
				contMap.put(contKey.get(j).text().toString(), contValue.get(j).text().toString());
			}
			
			for(int j=0; j<ContentKeys.length; j++)
			{
				if(contMap.get(ContentKeys[j]) != null)
				{
					contentValues[j] = contMap.get(ContentKeys[j]) ;
				}
				else
				{
					if(ContentKeys[j].equals("发布日期："))
					{
						contentValues[j] = "0000-00-00";
					}
					else{
						contentValues[j] = "";
					}
				}
			}
			
			String sql = "insert into `jobinfo`(`month_salary`,`job_location`,`announce_time`,`job_property`,`job_experience`,`education_limit`,`hire_num`,`job_category`) values (?,?,?,?,?,?,?,?)";
			//db.executeUpdateQuery(sql,contentValues);
		}
//		List<Object> list = (List<Object>) db.excuteQuery("select * from jobinfo", null);
//		System.out.println(list.size());
//		for(int i=0;i<list.size();i++)
//		{
//			Map<String, Object> map = new HashMap<String, Object>(); 
//			map = (Map<String, Object>) list.get(i);
//			System.out.println(map.get("job_experience"));
//		}
		
		ResultSet rs = db.executeQueryRS("select * from jobinfo",null);
		while (rs.next())   
		{   
			System.out.println(new String(rs.getString(2).getBytes(),"utf8"));
			System.out.println(rs.getString(3));
		}
		*/
	}
	
}
