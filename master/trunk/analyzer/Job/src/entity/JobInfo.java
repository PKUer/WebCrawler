package entity;

/**
 * 招聘岗位详细信息
 * @author Zhang
 *
 */
public class JobInfo {
	
	private Integer job_id;	//编号
	private String average_salary;//月薪
	private String job_location;//工作地点
	private Integer hire_num_trans;//招聘人数
	private String job_position; //岗位名称
	
	private Integer totalNum;		//总招聘人数
	private Double averageSalary;   //平均工资
	
	public Integer getJob_id() {
		return job_id;
	}
	public void setJob_id(Integer job_id) {
		this.job_id = job_id;
	}
	public String getAverage_salary() {
		return average_salary;
	}
	public void setAverage_salary(String average_salary) {
		this.average_salary = average_salary;
	}
	public String getJob_location() {
		return job_location;
	}
	public void setJob_location(String job_location) {
		this.job_location = job_location;
	}
	public Integer getHire_num_trans() {
		return hire_num_trans;
	}
	public void setHire_num_trans(Integer hire_num_trans) {
		this.hire_num_trans = hire_num_trans;
	}
	public String getJob_position() {
		return job_position;
	}
	public void setJob_position(String job_position) {
		this.job_position = job_position;
	}
	
	
	public Integer getTotalNum() {
		return totalNum;
	}
	public void setTotalNum(Integer totalNum) {
		this.totalNum = totalNum;
	}
	public Double getAverageSalary() {
		return averageSalary;
	}
	public void setAverageSalary(Double averageSalary) {
		this.averageSalary = averageSalary;
	}
	
	
	
}
