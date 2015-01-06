package entity;

/***
 * 分析结果
 * @author Zhang
 *
 */
public class AnalysisResult {
	private Integer analysisId; //id
	private Integer city;		//城市， 0:全国   1：北京    2:上海   3:广州   4:深圳    5:杭州
	private double salary;		//平均工资
	private String positionName;//岗位名称
	private Integer peopleNum;	//岗位总人数！！！ 
	private Integer type;		//类型， 0: 岗位-工资分析柱状图  1：岗位-招聘人数分析饼图  2：地区-工资 3：地区-招聘人数
	
	private Integer totalNum;//总招聘人数
	private Double aveSalary; //平均工资
	
	public Integer getTotalNum() {
		return totalNum;
	}
	public void setTotalNum(Integer totalNum) {
		this.totalNum = totalNum;
	}
	public Double getAveSalary() {
		return aveSalary;
	}
	public void setAveSalary(Double aveSalary) {
		this.aveSalary = aveSalary;
	}
	//---------------------
	public Integer getAnalysisId() {
		return analysisId;
	}
	public void setAnalysisId(Integer analysisId) {
		this.analysisId = analysisId;
	}
	public Integer getCity() {
		return city;
	}
	public void setCity(Integer city) {
		this.city = city;
	}
	public double getSalary() {
		return salary;
	}
	public void setSalary(double salary) {
		this.salary = salary;
	}
	public String getPositionName() {
		return positionName;
	}
	public void setPositionName(String positionName) {
		this.positionName = positionName;
	}
	public Integer getPeopleNum() {
		return peopleNum;
	}
	public void setPeopleNum(Integer peopleNum) {
		this.peopleNum = peopleNum;
	}
	public Integer getType() {
		return type;
	}
	public void setType(Integer type) {
		this.type = type;
	}
}
