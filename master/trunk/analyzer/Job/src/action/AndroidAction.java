package action;
import com.opensymphony.xwork2.ActionSupport;

import dao.*;
import entity.*;
@SuppressWarnings("serial")
public class AndroidAction extends ActionSupport{
	
	private AnalysisResult result;
	
	public AnalysisResult getResult() {
		return result;
	}
	public void setResult(AnalysisResult result) {
		this.result = result;
	}

	public String execute(){
		NumDao jobDao = new NumDao();
		//Android工程师：全国
		int androidQG = jobDao.getAndroidNum(0);
		//Android工程师：北京
		int androidBJ = jobDao.getAndroidNum(1);
		//Android工程师：上海
		int androidSH = jobDao.getAndroidNum(2);
		//Android工程师：广州
		int androidGZ = jobDao.getAndroidNum(3);
		//Android工程师：深圳
		int androidSZ = jobDao.getAndroidNum(4);
		//Android工程师：杭州
		int androidHZ = jobDao.getAndroidNum(5);
		
		SalaryDao salaryDao = new SalaryDao();
		int salaryQG = salaryDao.getAndroidSalary(0);
		int salaryBJ = salaryDao.getAndroidSalary(1);
		int salarySH = salaryDao.getAndroidSalary(2);
		int salaryGZ = salaryDao.getAndroidSalary(3);
		int salarySZ = salaryDao.getAndroidSalary(4);
		int salaryHZ = salaryDao.getAndroidSalary(5);
		
		salaryDao.addResult(0, androidQG, "Android工程师", salaryQG/androidQG, 0);
		salaryDao.addResult(1, androidBJ, "Android工程师", salaryBJ/androidBJ, 1);
		salaryDao.addResult(2, androidSH, "Android工程师", salarySH/androidSH, 1);
		salaryDao.addResult(3, androidGZ, "Android工程师", salaryGZ/androidGZ, 1);
		salaryDao.addResult(4, androidSZ, "Android工程师", salarySZ/androidSZ, 1);
		salaryDao.addResult(5, androidHZ, "Android工程师", salaryHZ/androidHZ, 1);
		return SUCCESS;
	}
}
