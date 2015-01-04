package entity;

import java.util.ArrayList;
import java.util.List;

public class RegionNumber {
	
	List<Integer> peopleNumber=new ArrayList<Integer>();
	  public String city;

	  
	  public RegionNumber(String city,ArrayList<Integer> peopleNumber){
		  this.city=city;
		  this.peopleNumber=peopleNumber;
	  }


	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}


	public List<Integer> getPeopleNumber() {
		return peopleNumber;
	}


	public void setPeopleNumber(List<Integer> peopleNumber) {
		this.peopleNumber = peopleNumber;
	}
	
	


}
