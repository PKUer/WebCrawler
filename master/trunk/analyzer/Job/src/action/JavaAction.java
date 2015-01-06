package action;
import com.opensymphony.xwork2.ActionSupport;
/*
*	针对Java招聘的分析
*/
import dao.*;
import entity.*;
@SuppressWarnings("serial")
public class JavaAction extends ActionSupport{
	
	private AnalysisResult result;
	
	public AnalysisResult getResult() {
		return result;
	}
	public void setResult(AnalysisResult result) {
		this.result = result;
	}

	public String execute(){
		NumDao jobDao = new NumDao();
		//java工程师：全国
		int javaQG = jobDao.getJavaNum(0);
		//java工程师：北京
		int javaBJ = jobDao.getJavaNum(1);
		//java工程师：上海
		int javaSH = jobDao.getJavaNum(2);
		//java工程师：广州
		int javaGZ = jobDao.getJavaNum(3);
		//java工程师：深圳
		int javaSZ = jobDao.getJavaNum(4);
		//java工程师：杭州
		int javaHZ = jobDao.getJavaNum(5);
		
		SalaryDao salaryDao = new SalaryDao();
		int salaryQG = salaryDao.getIOSSalary(0);
		int salaryBJ = salaryDao.getIOSSalary(1);
		int salarySH = salaryDao.getIOSSalary(2);
		int salaryGZ = salaryDao.getIOSSalary(3);
		int salarySZ = salaryDao.getIOSSalary(4);
		int salaryHZ = salaryDao.getIOSSalary(5);
		
		salaryDao.addResult(0, javaQG, "Java工程师", salaryQG/javaQG, 0);
		salaryDao.addResult(1, javaBJ, "Java工程师", salaryBJ/javaBJ, 1);
		salaryDao.addResult(2, javaSH, "Java工程师", salarySH/javaSH, 1);
		salaryDao.addResult(3, javaGZ, "Java工程师", salaryGZ/javaGZ, 1);
		salaryDao.addResult(4, javaSZ, "Java工程师", salarySZ/javaSZ, 1);
		salaryDao.addResult(5, javaHZ, "Java工程师", salaryHZ/javaHZ, 1);
		return SUCCESS;
	}
}
