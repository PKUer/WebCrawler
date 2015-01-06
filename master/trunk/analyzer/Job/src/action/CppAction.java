package action;
import com.opensymphony.xwork2.ActionSupport;
/*
*	针对C++招聘的分析
*/
import dao.*;
import entity.*;
@SuppressWarnings("serial")
public class CppAction extends ActionSupport{
	
	private AnalysisResult result;
	
	public AnalysisResult getResult() {
		return result;
	}
	public void setResult(AnalysisResult result) {
		this.result = result;
	}

	public String execute(){
		NumDao jobDao = new NumDao();
		//C++工程师：全国
		int cppQG = jobDao.getCppNum(0);
		//C++工程师：北京
		int cppBJ = jobDao.getCppNum(1);
		//C++工程师：上海
		int cppSH = jobDao.getCppNum(2);
		//C++工程师：广州
		int cppGZ = jobDao.getCppNum(3);
		//C++工程师：深圳
		int cppSZ = jobDao.getCppNum(4);
		//C++工程师：杭州
		int cppHZ = jobDao.getCppNum(5);
		
		SalaryDao salaryDao = new SalaryDao();
		int salaryQG = salaryDao.getCppSalary(0);
		int salaryBJ = salaryDao.getCppSalary(1);
		int salarySH = salaryDao.getCppSalary(2);
		int salaryGZ = salaryDao.getCppSalary(3);
		int salarySZ = salaryDao.getCppSalary(4);
		int salaryHZ = salaryDao.getCppSalary(5);
		
		salaryDao.addResult(0, cppQG, "C++工程师", salaryQG/cppQG, 0);
		salaryDao.addResult(1, cppBJ, "C++工程师", salaryBJ/cppBJ, 1);
		salaryDao.addResult(2, cppSH, "C++工程师", salarySH/cppSH, 1);
		salaryDao.addResult(3, cppGZ, "C++工程师", salaryGZ/cppGZ, 1);
		salaryDao.addResult(4, cppSZ, "C++工程师", salarySZ/cppSZ, 1);
		salaryDao.addResult(5, cppHZ, "C++工程师", salaryHZ/cppHZ, 1);
		return SUCCESS;
	}
}
