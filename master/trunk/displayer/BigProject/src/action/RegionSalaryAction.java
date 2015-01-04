package action;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionSupport;

import dao.PositionSalaryData;
import dao.RegionSalaryData;
import entity.HighCharts;
import entity.RegionSalary;



public class RegionSalaryAction extends ActionSupport {
	List<RegionSalary> dataList=new ArrayList<RegionSalary>();
	public RegionSalaryAction() {
		// TODO Auto-generated constructor stub
	}
	
	 public String execute() throws Exception {
		 
		 //New一个张龙云计算的类的实例变量,运行main方法
		 //
		 //北京地区工资
		 ArrayList<Double> BJsalary=new ArrayList<Double>();
		 RegionSalaryData ps=new RegionSalaryData();
		 BJsalary=ps.getRegionSalaryData(1,1);
		 

		 //上海地区工资
		 ArrayList<Double> SHsalary=new ArrayList<Double>();
		 SHsalary=ps.getRegionSalaryData(2,1);
		 
		 //广州地区工资
		 ArrayList<Double> GZsalary=new ArrayList<Double>();
		 GZsalary=ps.getRegionSalaryData(3,1);
		 
		 //深圳地区工资
		 ArrayList<Double> SZsalary=new ArrayList<Double>();
		 SZsalary=ps.getRegionSalaryData(4,1);
		 
		 //杭州地区工资
		 ArrayList<Double> HZsalary=new ArrayList<Double>();
		 HZsalary=ps.getRegionSalaryData(5,1);
		 
         dataList.add(new RegionSalary("北京",BJsalary));
         dataList.add(new RegionSalary("上海",SHsalary));
         dataList.add(new RegionSalary("广州",GZsalary));
         dataList.add(new RegionSalary("深圳",SZsalary));
         dataList.add(new RegionSalary("杭州",HZsalary));
         
		 
		 
		 HttpServletRequest request = ServletActionContext.getRequest();
         request.setAttribute("dataList", dataList);
     
         return SUCCESS;
  
      }

	public List<RegionSalary> getDataList() {
		return dataList;
	}

	public void setDataList(List<RegionSalary> dataList) {
		this.dataList = dataList;
	}
}
