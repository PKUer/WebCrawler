package action;
import com.opensymphony.xwork2.ActionSupport;

import dao.*;
import entity.*;
@SuppressWarnings("serial")
public class WinPhoneAction extends ActionSupport{
	
	private AnalysisResult result;
	
	public AnalysisResult getResult() {
		return result;
	}
	public void setResult(AnalysisResult result) {
		this.result = result;
	}

	public String execute(){
		NumDao jobDao = new NumDao();
		//WinPhone工程师：全国
		int wpQG = jobDao.getWinPhoneNum(0);
		//WinPhone工程师：北京
		int wpBJ = jobDao.getWinPhoneNum(1);
		//WinPhone工程师：上海
		int wpSH = jobDao.getWinPhoneNum(2);
		//WinPhone工程师：广州
		int wpGZ = jobDao.getWinPhoneNum(3);
		//WinPhone工程师：深圳
		int wpSZ = jobDao.getWinPhoneNum(4);
		//WinPhone工程师：杭州
		int wpHZ = jobDao.getWinPhoneNum(5);
		
		SalaryDao salaryDao = new SalaryDao();
		int salaryQG = salaryDao.getWinPhoneSalary(0);
		int salaryBJ = salaryDao.getWinPhoneSalary(1);
		int salarySH = salaryDao.getWinPhoneSalary(2);
		int salaryGZ = salaryDao.getWinPhoneSalary(3);
		int salarySZ = salaryDao.getWinPhoneSalary(4);
		int salaryHZ = salaryDao.getWinPhoneSalary(5);
		
		salaryDao.addResult(0, wpQG, "WinPhone工程师", salaryQG/wpQG, 0);
		salaryDao.addResult(1, wpBJ, "WinPhone工程师", salaryBJ/wpBJ, 1);
		salaryDao.addResult(2, wpSH, "WinPhone工程师", salarySH/wpSH, 1);
		salaryDao.addResult(3, wpGZ, "WinPhone工程师", salaryGZ/wpGZ, 1);
		salaryDao.addResult(4, wpSZ, "WinPhone工程师", salarySZ/wpSZ, 1);
		salaryDao.addResult(5, wpHZ, "WinPhone工程师", salaryHZ/wpHZ, 1);
		return SUCCESS;
	}
}
