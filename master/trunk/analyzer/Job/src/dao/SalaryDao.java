package dao;

import java.util.Iterator;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import config.*;     //  HibernateSessionFactory.java
import entity.*;

public class SalaryDao {
		private Session session;
		private Query query;
		private Transaction transaction;
		public SalaryDao(){
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
		
		//Web工程师招聘平均月薪
		public int getWebSalary(int type){
			int totalSalary = 0;
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
				 hql = "select sum(hire_num_trans * average_salary) from jobinfo where month_salary !='面议' and ( job_position like '%web%' and job_position like '%网站%' and job_position like '%PHP%' )";
			else
				hql = "select sum(hire_num_trans * average_salary) from jobinfo where month_salary !='面议' and ( job_position like '%web%' and job_position like '%网站%' and job_position like '%PHP%' )and job_location like '"+position+"';";
			query = session.createSQLQuery(hql);
			Iterator<AnalysisResult> iterator = query.list().iterator();
			if(iterator.hasNext()){
				result = iterator.next();
			}	
			totalSalary = (Integer)result.getTotalNum();
			session.close();
			return totalSalary;
		}	
		
		//Java工程师招聘平均月薪
		public int getJavaSalary(int type){
			int totalSalary = 0;
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
				 hql = "select sum(hire_num_trans * average_salary) from jobinfo where month_salary !='面议' and ( job_position like '%java%' )";
			else
				hql = "select sum(hire_num_trans * average_salary) from jobinfo where month_salary !='面议' and ( job_position like '%java%' )and job_location like '"+position+"';";
			query = session.createSQLQuery(hql);
			Iterator<AnalysisResult> iterator = query.list().iterator();
			if(iterator.hasNext()){
				result = iterator.next();
			}	
			totalSalary = (Integer)result.getTotalNum();
			session.close();
			return totalSalary;
		}	
		
		//C++工程师招聘平均月薪
		public int getCppSalary(int type){
			int totalSalary = 0;
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
				 hql = "select sum(hire_num_trans * average_salary) from jobinfo where month_salary !='面议' and ( job_position like '%C++%' )";
			else
				hql = "select sum(hire_num_trans * average_salary) from jobinfo where month_salary !='面议' and( job_position like '%C++%' )and job_location like '"+position+"';";
			query = session.createSQLQuery(hql);
			Iterator<AnalysisResult> iterator = query.list().iterator();
			if(iterator.hasNext()){
				result = iterator.next();
			}	
			totalSalary = (Integer)result.getTotalNum();
			session.close();
			return totalSalary;
		}	
		
		//Android工程师招聘平均月薪
		public int getAndroidSalary(int type){
			int totalSalary = 0;
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
				 hql = "select sum(hire_num_trans * average_salary) from jobinfo where month_salary !='面议' and ( job_position like '%Android%' and job_position like '%安卓%' )";
			else
				hql = "select sum(hire_num_trans * average_salary) from jobinfo where  month_salary !='面议' and( job_position like '%Android%' and job_position like '%安卓%')and job_location like '"+position+"';";
			query = session.createSQLQuery(hql);
			Iterator<AnalysisResult> iterator = query.list().iterator();
			if(iterator.hasNext()){
				result = iterator.next();
			}	
			totalSalary = (Integer)result.getTotalNum();
			session.close();
			return totalSalary;
		}		
						
		//IOS工程师招聘平均月薪
		public int getIOSSalary(int type){
			int totalSalary = 0;
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
				 hql = "select sum(hire_num_trans * average_salary) from jobinfo where month_salary !='面议' and ( job_position like '%ios%' )";
			else
				hql = "select sum(hire_num_trans * average_salary) from jobinfo where  month_salary !='面议' and( job_position like '%ios%')and job_location like '"+position+"';";
			query = session.createSQLQuery(hql);
			Iterator<AnalysisResult> iterator = query.list().iterator();
			if(iterator.hasNext()){
				result = iterator.next();
			}	
			totalSalary = (Integer)result.getTotalNum();
			session.close();
			return totalSalary;
		}		
		
		//WinPhone工程师招聘平均月薪
		public int getWinPhoneSalary(int type){
			int totalSalary = 0;
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
				 hql = "select sum(hire_num_trans * average_salary) from jobinfo where month_salary !='面议' and ( job_position like '%WinPhone%' )";
			else
				hql = "select sum(hire_num_trans * average_salary) from jobinfo where  month_salary !='面议' and( job_position like '%WinPhone%')and job_location like '"+position+"';";
			query = session.createSQLQuery(hql);
			Iterator<AnalysisResult> iterator = query.list().iterator();
			if(iterator.hasNext()){
				result = iterator.next();
			}	
			totalSalary = (Integer)result.getTotalNum();
			session.close();
			return totalSalary;
		}
}
