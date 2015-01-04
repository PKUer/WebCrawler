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

		 //����������Ƹ����
		 ArrayList<Integer> BJNumber=new ArrayList<Integer>();
		 RegionNumberData ps=new RegionNumberData();
		 BJNumber=ps.getRegionNumberData(1,1);
		 

		 //�Ϻ���������
		 ArrayList<Integer> SHNumber=new ArrayList<Integer>();
		 SHNumber=ps.getRegionNumberData(2,1);
		 
		 //���ݵ�������
		 ArrayList<Integer> GZNumber=new ArrayList<Integer>();
		 GZNumber=ps.getRegionNumberData(3,1);
		 
		 //���ڵ�������
		 ArrayList<Integer> SZNumber=new ArrayList<Integer>();
		 SZNumber=ps.getRegionNumberData(4,1);
		 
		 //���ݵ�������
		 ArrayList<Integer> HZNumber=new ArrayList<Integer>();
		 HZNumber=ps.getRegionNumberData(5,1);
		 
         dataList.add(new RegionNumber("����",BJNumber));
         dataList.add(new RegionNumber("�Ϻ�",SHNumber));
         dataList.add(new RegionNumber("����",GZNumber));
         dataList.add(new RegionNumber("����",SZNumber));
         dataList.add(new RegionNumber("����",HZNumber));
         
		 
		 
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
