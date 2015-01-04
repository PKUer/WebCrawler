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
		 
		 //Newһ�������Ƽ�������ʵ������,����main����
		 //
		 //������������
		 ArrayList<Double> BJsalary=new ArrayList<Double>();
		 RegionSalaryData ps=new RegionSalaryData();
		 BJsalary=ps.getRegionSalaryData(1,1);
		 

		 //�Ϻ���������
		 ArrayList<Double> SHsalary=new ArrayList<Double>();
		 SHsalary=ps.getRegionSalaryData(2,1);
		 
		 //���ݵ�������
		 ArrayList<Double> GZsalary=new ArrayList<Double>();
		 GZsalary=ps.getRegionSalaryData(3,1);
		 
		 //���ڵ�������
		 ArrayList<Double> SZsalary=new ArrayList<Double>();
		 SZsalary=ps.getRegionSalaryData(4,1);
		 
		 //���ݵ�������
		 ArrayList<Double> HZsalary=new ArrayList<Double>();
		 HZsalary=ps.getRegionSalaryData(5,1);
		 
         dataList.add(new RegionSalary("����",BJsalary));
         dataList.add(new RegionSalary("�Ϻ�",SHsalary));
         dataList.add(new RegionSalary("����",GZsalary));
         dataList.add(new RegionSalary("����",SZsalary));
         dataList.add(new RegionSalary("����",HZsalary));
         
		 
		 
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
