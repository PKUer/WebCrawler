package dao;

import java.util.Iterator;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import config.*;     //  HibernateSessionFactory.java
import entity.*;

public class NumDao {
		private Session session;
		private Query query;
		private Transaction transaction;
		public NumDao(){
		}
		
		//添加新的一条记录
		public void addResult(Integer city, Integer peopleNum, String positionName, double salary, Integer type){
			session = HibernateSessionFactory.getSession();		
			transaction = session.beginTransaction();
			AnalysisResult result = new AnalysisResult();
			result.setCity(city);
			result.setPeopleNum(peopleNum);
			result.setPositionName(positionName);
			result.setSalary(salary);
			result.setType(type);
			session.save(result);					
			transaction.commit();								
			session.close();
		}
		
		//web工程师招聘数量
		public int getWebNum(int type){
			AnalysisResult result = null;
			session = HibernateSessionFactory.getSession();
			String position = null;
			String hql = null;
			if (type == 1)
				position = "北京";
			if (type == 2)
				position = "上海";
			if (type == 3)
				position = "广州";
			if (type == 4)
				position = "深圳";
			if (type == 5)
				position = "杭州";
			
			if (type == 0)
				 hql = "select sum(hire_num_trans) from jobinfo where month_salary !='面议' and( job_position like '%网站%' or job_position like '%web%' or job_position like '%php%')";
			else
				hql = "select sum(hire_num_trans) from jobinfo where  month_salary !='面议' and( job_position like '%网站%' or job_position like '%web%' or job_position like '%php%')and job_location like '"+position+"';";
			
			query = session.createSQLQuery(hql);
			Iterator<AnalysisResult> iterator = query.list().iterator();
			if(iterator.hasNext()){
				result = iterator.next();
			}	
			Integer totalNum = (Integer)result.getTotalNum();
			session.close();
			return totalNum;
		}
		//java工程师招聘数量
		public int getJavaNum(int type){
			AnalysisResult result = null;
			session = HibernateSessionFactory.getSession();
			String position = null;
			String hql = null;
			
			if (type == 1)
				position = "北京";
			if (type == 2)
				position = "上海";
			if (type == 3)
				position = "广州";
			if (type == 4)
				position = "深圳";
			if (type == 5)
				position = "杭州";
			if (type == 0)
				 hql = "select sum(hire_num_trans) from jobinfo where month_salary !='面议' and( job_position like '%java%')";
			else
				hql = "select sum(hire_num_trans) from jobinfo where  month_salary !='面议' and( job_position like '%java%')and job_location like '"+position+"';";
			query = session.createSQLQuery(hql);
			Iterator<AnalysisResult> iterator = query.list().iterator();
			if(iterator.hasNext()){
				result = iterator.next();
			}	
			Integer totalNum = (Integer)result.getTotalNum();
			session.close();
			return totalNum;
		}
		
		//android工程师招聘数量
		public int getAndroidNum(int type){
			AnalysisResult result = null;
			session = HibernateSessionFactory.getSession();
			String position = null;
			String hql = null;
			if (type == 1)
				position = "北京";
			if (type == 2)
				position = "上海";
			if (type == 3)
				position = "广州";
			if (type == 4)
				position = "深圳";
			if (type == 5)
				position = "杭州";
			if (type == 0)
				 hql = "select sum(hire_num_trans) from jobinfo where month_salary !='面议' and( job_position like '%Android%' and job_position like '%安卓%')";
			else
				hql = "select sum(hire_num_trans) from jobinfo where  month_salary !='面议' and( job_position like '%Android%' and job_position like '%安卓%')and job_location like '"+position+"';";
			query = session.createSQLQuery(hql);
			Iterator<AnalysisResult> iterator = query.list().iterator();
			if(iterator.hasNext()){
				result = iterator.next();
			}	
			Integer totalNum = (Integer)result.getTotalNum();
			session.close();
			return totalNum;
		}
		//IOS工程师招聘数量
		public int getIOSNum(int type){
			AnalysisResult result = null;
			session = HibernateSessionFactory.getSession();
			String position = null;
			String hql = null;
			
			if (type == 1)
				position = "北京";
			if (type == 2)
				position = "上海";
			if (type == 3)
				position = "广州";
			if (type == 4)
				position = "深圳";
			if (type == 5)
				position = "杭州";
			if (type == 0)
				 hql = "select sum(hire_num_trans) from jobinfo where month_salary !='面议' and( job_position like '%IOS%')";
			else
				hql = "select sum(hire_num_trans) from jobinfo where  month_salary !='面议' and( job_position like '%IOS%')and job_location like '"+position+"';";
			query = session.createSQLQuery(hql);
			Iterator<AnalysisResult> iterator = query.list().iterator();
			if(iterator.hasNext()){
				result = iterator.next();
			}	
			Integer totalNum = (Integer)result.getTotalNum();
			session.close();
			return totalNum;
		}
		//CPP工程师招聘数量
		public int getCppNum(int type){
			AnalysisResult result = null;
			session = HibernateSessionFactory.getSession();
			String position = null;
			String hql = null;
			
			if (type == 1)
				position = "北京";
			if (type == 2)
				position = "上海";
			if (type == 3)
				position = "广州";
			if (type == 4)
				position = "深圳";
			if (type == 5)
				position = "杭州";
			if (type == 0)
				 hql = "select sum(hire_num_trans) from jobinfo where month_salary !='面议' and( job_position like '%C++%')";
			else
				hql = "select sum(hire_num_trans) from jobinfo where  month_salary !='面议' and( job_position like '%C++%')and job_location like '"+position+"';";
			query = session.createSQLQuery(hql);
			Iterator<AnalysisResult> iterator = query.list().iterator();
			if(iterator.hasNext()){
				result = iterator.next();
			}	
			Integer totalNum = (Integer)result.getTotalNum();
			session.close();
			return totalNum;
		}
		
		//WinPhone工程师招聘数量
		public int getWinPhoneNum(int type){
			AnalysisResult result = null;
			session = HibernateSessionFactory.getSession();
			String position = null;
			String hql = null;
			
			if (type == 1)
				position = "北京";
			if (type == 2)
				position = "上海";
			if (type == 3)
				position = "广州";
			if (type == 4)
				position = "深圳";
			if (type == 5)
				position = "杭州";
			if (type == 0)
				 hql = "select sum(hire_num_trans) from jobinfo where month_salary !='面议' and( job_position like '%WinPhone%')";
			else
				hql = "select sum(hire_num_trans) from jobinfo where  month_salary !='面议' and( job_position like '%WinPhone%')and job_location like '"+position+"';";
			query = session.createSQLQuery(hql);
			Iterator<AnalysisResult> iterator = query.list().iterator();
			if(iterator.hasNext()){
				result = iterator.next();
			}	
			Integer totalNum = (Integer)result.getTotalNum();
			session.close();
			return totalNum;
		}
}
