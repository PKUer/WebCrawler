package action;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionSupport;



import dao.RegionNumberData;
import entity.RegionNumber;


public class RegionNumberAction extends ActionSupport {
	
	List<RegionNumber> dataList=new ArrayList<RegionNumber>();
	public RegionNumberAction() {
		// TODO Auto-generated constructor stub
	}
	
	 public String execute() throws Exception {

		 //北京地区招聘人数
		 ArrayList<Integer> BJNumber=new ArrayList<Integer>();
		 RegionNumberData ps=new RegionNumberData();
		 BJNumber=ps.getRegionNumberData(1,1);
		 

		 //上海地区工资
		 ArrayList<Integer> SHNumber=new ArrayList<Integer>();
		 SHNumber=ps.getRegionNumberData(2,1);
		 
		 //广州地区工资
		 ArrayList<Integer> GZNumber=new ArrayList<Integer>();
		 GZNumber=ps.getRegionNumberData(3,1);
		 
		 //深圳地区工资
		 ArrayList<Integer> SZNumber=new ArrayList<Integer>();
		 SZNumber=ps.getRegionNumberData(4,1);
		 
		 //杭州地区工资
		 ArrayList<Integer> HZNumber=new ArrayList<Integer>();
		 HZNumber=ps.getRegionNumberData(5,1);
		 
         dataList.add(new RegionNumber("北京",BJNumber));
         dataList.add(new RegionNumber("上海",SHNumber));
         dataList.add(new RegionNumber("广州",GZNumber));
         dataList.add(new RegionNumber("深圳",SZNumber));
         dataList.add(new RegionNumber("杭州",HZNumber));
         
		 
		 
		 HttpServletRequest request = ServletActionContext.getRequest();
         request.setAttribute("dataList", dataList);
     
         return SUCCESS;
  
      }

	public List<RegionNumber> getDataList() {
		return dataList;
	}

	public void setDataList(List<RegionNumber> dataList) {
		this.dataList = dataList;
	}

}
