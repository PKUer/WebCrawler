package entity;

/***
 * �������
 * @author Zhang
 *
 */
public class AnalysisResult {
	private Integer analysisId; //id
	private Integer city;		//���У� 0:ȫ��   1������    2:�Ϻ�   3:����   4:����    5:����
	private double salary;		//ƽ������
	private String positionName;//��λ����
	private Integer peopleNum;	//��λ������������ 
	private Integer type;		//���ͣ� 0: ��λ-���ʷ�����״ͼ  1����λ-��Ƹ����������ͼ  2������-���� 3������-��Ƹ����
	
	private Integer totalNum;//����Ƹ����
	private Double aveSalary; //ƽ������
	
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
