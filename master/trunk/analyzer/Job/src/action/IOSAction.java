package action;
import com.opensymphony.xwork2.ActionSupport;

import dao.*;
import entity.*;
@SuppressWarnings("serial")
public class IOSAction extends ActionSupport{
	
	private AnalysisResult result;
	
	public AnalysisResult getResult() {
		return result;
	}
	public void setResult(AnalysisResult result) {
		this.result = result;
	}

	public String execute(){
		NumDao jobDao = new NumDao();
		//IOS工程师：全国
		int iosQG = jobDao.getIOSNum(0);
		//IOS工程师：北京
		int iosBJ = jobDao.getIOSNum(1);
		//IOS工程师：上海
		int iosSH = jobDao.getIOSNum(2);
		//IOS工程师：广州
		int iosGZ = jobDao.getIOSNum(3);
		//IOS工程师：深圳
		int iosSZ = jobDao.getIOSNum(4);
		//IOS工程师：杭州
		int iosHZ = jobDao.getIOSNum(5);
		
		SalaryDao salaryDao = new SalaryDao();
		int salaryQG = salaryDao.getIOSSalary(0);
		int salaryBJ = salaryDao.getIOSSalary(1);
		int salarySH = salaryDao.getIOSSalary(2);
		int salaryGZ = salaryDao.getIOSSalary(3);
		int salarySZ = salaryDao.getIOSSalary(4);
		int salaryHZ = salaryDao.getIOSSalary(5);
		
		salaryDao.addResult(0, iosQG, "ios工程师", salaryQG/iosQG, 0);
		salaryDao.addResult(1, iosBJ, "ios工程师", salaryBJ/iosBJ, 1);
		salaryDao.addResult(2, iosSH, "ios工程师", salarySH/iosSH, 1);
		salaryDao.addResult(3, iosGZ, "ios工程师", salaryGZ/iosGZ, 1);
		salaryDao.addResult(4, iosSZ, "ios工程师", salarySZ/iosSZ, 1);
		salaryDao.addResult(5, iosHZ, "ios工程师", salaryHZ/iosHZ, 1);
		return SUCCESS;
	}
}
