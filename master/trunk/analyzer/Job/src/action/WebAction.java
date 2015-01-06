package action;
import com.opensymphony.xwork2.ActionSupport;

import dao.*;
import entity.*;
@SuppressWarnings("serial")
public class WebAction extends ActionSupport{
	
	private AnalysisResult result;
	
	public AnalysisResult getResult() {
		return result;
	}
	public void setResult(AnalysisResult result) {
		this.result = result;
	}

	public String execute(){
		NumDao jobDao = new NumDao();
		//web工程师：全国
		int webQG = jobDao.getWebNum(0);
		//web工程师：北京
		int webBJ = jobDao.getWebNum(1);
		//web工程师：上海
		int webSH = jobDao.getWebNum(2);
		//web工程师：广州
		int webGZ = jobDao.getWebNum(3);
		//web工程师：深圳
		int webSZ = jobDao.getWebNum(4);
		//web工程师：杭州
		int webHZ = jobDao.getWebNum(5);
		
		//月薪
		SalaryDao salaryDao = new SalaryDao();
		int salaryQG = salaryDao.getCppSalary(0);
		int salaryBJ = salaryDao.getCppSalary(1);
		int salarySH = salaryDao.getCppSalary(2);
		int salaryGZ = salaryDao.getCppSalary(3);
		int salarySZ = salaryDao.getCppSalary(4);
		int salaryHZ = salaryDao.getCppSalary(5);
		
		//插入结果
		salaryDao.addResult(0, webQG, "web工程师", salaryQG/webQG, 0);
		salaryDao.addResult(1, webBJ, "web工程师", salaryBJ/webBJ, 1);
		salaryDao.addResult(2, webSH, "web工程师", salarySH/webSH, 1);
		salaryDao.addResult(3, webGZ, "web工程师", salaryGZ/webGZ, 1);
		salaryDao.addResult(4, webSZ, "web工程师", salarySZ/webSZ, 1);
		salaryDao.addResult(5, webHZ, "web工程师", salaryHZ/webHZ, 1);
		return SUCCESS;
	}
}
