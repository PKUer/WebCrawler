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

import entity.HighCharts;
import dao.PositionSalaryData;

public class PositionSalaryAction extends ActionSupport {

	List<HighCharts> dataList=new ArrayList<HighCharts>();
	
		public PositionSalaryAction() {
			// TODO Auto-generated constructor stub
		}
		
		 public String execute() throws Exception {
			 
			 //New一个张龙云计算的类的实例变量,运行main方法
			 //
			 PositionSalaryData ps=new PositionSalaryData();
			 dataList= ps.getPosSalary(0,0);
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
