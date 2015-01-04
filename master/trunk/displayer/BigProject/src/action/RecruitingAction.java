package action;

import java.util.ArrayList;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import net.sf.json.JSONSerializer;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionSupport;

import dao.RecruitingData;
import entity.HighCharts;

public class RecruitingAction extends ActionSupport {

	List<HighCharts> dataList=new ArrayList<HighCharts>();
		public RecruitingAction() {
			// TODO Auto-generated constructor stub
		}
		
		 public String execute() throws Exception {
			 
			 //Newһ�������Ƽ�������ʵ������,����main����
			 //
			 RecruitingData ps=new RecruitingData();
			 dataList= ps.getRecruitingData(0, 0);
			 
			 HttpServletRequest request = ServletActionContext.getRequest();
	         request.setAttribute("dataList", dataList);
	      
	         return SUCCESS;
	      
	      }
		 
		public List<HighCharts> getDataList() {
			return dataList;
		}

		public void setDataList(List<HighCharts> dataList) {
			this.dataList = dataList;
		}
          
}
