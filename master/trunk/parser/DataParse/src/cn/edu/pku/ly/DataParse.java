package cn.edu.pku.ly;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

public class DataParse {
	private static final String ROOTDIR = "./zhaopin_all";
	
	private static Properties config = new Properties();
	private String[] contentKeys = null;
	private Object[] contentValues = null;
	
	private ArrayList<String> fileDirectorys = new ArrayList<String>();
	
	private DBManager dbManager = null;
	
	//从配置文件中获得需要提取的字段名
 	public DataParse()
	{
		InputStream in = DataParse.class.getResourceAsStream("dbConfig.properties");
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
				//将从配置文件中获得的字段，将字段分开，组装到 contentKeys 中
				String keysStr = config.getProperty("keys"); 
				setContentKeys(keysStr.split(" "));
				contentValues = new Object[contentKeys.length];
			}
			catch (Exception e)
			{
				e.printStackTrace();
			}
			
			dbManager = new DBManager();

		} catch (Exception e)
		{
			e.printStackTrace();
			throw new ExceptionInInitializerError("the file load fail!");
		}
	}

	//contentKeys getter
	public String[] getContentKeys() {
		return contentKeys;
	}

	//contentKeys setter
	public void setContentKeys(String[] contentKeys) {
		this.contentKeys = contentKeys;
	}
	
	
	/*
	* 将 zhaopin_all 文件夹下的子文件夹名取出组装到fileDirectorys中
	*/
	public void setDirectory()
	{
		File rootDir = new File(ROOTDIR);
		if(rootDir.exists())
		{
			File[] files = rootDir.listFiles();
			for(int i=0; i<files.length; i++)
			{
				fileDirectorys.add(files[i].getName());
				System.out.println(files[i].getName());
			}
		}
	}
	
	/*
	* 获得每个子文件夹下的html文件的完整路径
	*/
	public ArrayList<String> getHtmlFileNames(String dirStr)
	{
		ArrayList<String> result = new ArrayList<String>();
		File fileDir = new File(ROOTDIR+"/"+dirStr);
		if(fileDir.exists())
		{
			File[] htmlFiles = fileDir.listFiles();
			for(int i=0; i<htmlFiles.length; i++)
			{
				result.add(htmlFiles[i].getName());
			}
		}
		
		return result;
	}
	
	/*
	* 使用jsoup从html文件中解析出所需要的字段，将数据插入到数据库中
	*/
	public void insertDataToDatabase(String dir,ArrayList<String> array)
	{
		Document document = null;
		Elements contKey = null;
		Elements contValue = null;
		
		Map<String,Object> contMap = new HashMap<String,Object>();
		
		for(int i=0; i<array.size(); i++)
		{
			String url = array.get(i);
			File input = new File(ROOTDIR+"/"+dir+"/"+url);
			
			if(input.exists())
			{
				try {
					document =  Jsoup.parse(input,"UTF-8");
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				contKey = document.select("ul[class=terminal-ul clearfix]>li>span");
				contValue = document.select("ul[class=terminal-ul clearfix]>li>strong");
				
				if(contKey.size() == 0)
				{
					continue;
				}
				
				contMap.clear();
				
				for(int j=0; j<contKey.size(); j++)
				{
					contMap.put(contKey.get(j).text().toString(), contValue.get(j).text().toString());
				}
				
				// 职位名称
				contValue = document.select("div[class=inner-left fl]>h1");
				contMap.put("职位名称", contValue.text());

				//发布公司 
				contValue = document.select("div[class=inner-left fl]>h2");
				contMap.put("发布公司", contValue.text());

				//文件目录 
				contMap.put("文件目录", dir);
				
				//平均工资
				float averageSalary = 0;
				String str = (String) contMap.get("职位月薪：");
				
				if(!str.equals("面议"))
				{
					String str1[] = str.split("元");
					String str2[] = str1[0].split("-");
					if(2 == str2.length)
					{
						averageSalary = (Float.parseFloat(str2[0])+Float.parseFloat(str2[1]))/2;
					}
					else if(1 == str2.length)
					{
						averageSalary = Float.parseFloat(str2[0]);
					}
				}
				contMap.put("平均工资", averageSalary);
				
				//转换后的招聘人数
				str = (String) contMap.get("招聘人数：");
				int hireNum = 2;
				
				if(!str.equals("若干"))
				{
					String str1[] = str.split("人");
					if(str1.length>0){
						hireNum = Integer.parseInt(str1[0]);
					}
				}
				contMap.put("转换招聘人数", hireNum);
				
				//转换工作经验
				float jobExperience = 0;
				str = (String) contMap.get("工作经验：");
				
				if(!str.equals("不限") && !str.endsWith("无经验"))
				{
					String str1[] = str.split("年");
					String str2[] = str1[0].split("-");
					if(2 == str2.length)
					{
						jobExperience = (Float.parseFloat(str2[0])+Float.parseFloat(str2[1]))/2;
					}
					else if(1 == str2.length)
					{
						jobExperience = Float.parseFloat(str2[0]);
					}
				}
				contMap.put("转换工作经验", jobExperience);
				
				//组装数组
				for(int j=0; j<contMap.size(); j++)
				{
					if(contMap.get(contentKeys[j]) != null)
					{
						contentValues[j] = contMap.get(contentKeys[j]) ;
					}
					else
					{
						if(contentKeys[j].equals("发布日期："))
						{
							contentValues[j] = "0000-00-00";
						}
						else if(contentKeys[j].equals("转换招聘人数"))
						{
							contentValues[j] = 2;
						}
						else if(contentKeys[j].equals("平均工资"))
						{
							contentValues[j] = 0;
						}
						else if(contentKeys[j].equals("转换工作经验"))
						{
							contentValues[j] = 0;
						}
						else{
							contentValues[j] = "";
						}
					}
				}
				
				String sql = "insert into `jobinfo`(`month_salary`,`job_location`,`announce_time`,`job_property`,`job_experience`,`education_limit`,`hire_num`,`job_category`" +
						",`job_position`" +
						",`company`" +
						",`file_dir`" +
						",`average_salary`" +
						",`hire_num_trans`" +
						",`job_experience_trans`" +
						") values (?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
				int result =  dbManager.executeUpdateQuery(sql,contentValues);
				if(1 == result)
				{
					System.out.println(dir+"插入成功");
				}
				else
				{
					System.out.println(dir+"插入失败！");
				}
			}
			else
			{
				System.out.println(input.toString()+" 不存在！");
			}
		}
	}
	
	public void startParse()
	{
		this.setDirectory();
		
		for(int i=0; i<fileDirectorys.size(); i++)
		{
			String dirStr = this.fileDirectorys.get(i);
			ArrayList<String> lists = this.getHtmlFileNames(dirStr);
			this.insertDataToDatabase(dirStr,lists);
		}
	}
}
