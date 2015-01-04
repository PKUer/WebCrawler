package entity;

import java.util.ArrayList;
import java.util.List;

public class RegionSalary {
	
  List<Double> money=new ArrayList<Double>();
  public String city;

  
  public RegionSalary(String city,ArrayList<Double> money){
	  this.city=city;
	  this.money=money;
  }

public List<Double> getMoney() {
	return money;
}

public void setMoney(List<Double> money) {
	this.money = money;
}

public String getCity() {
	return city;
}

public void setCity(String city) {
	this.city = city;
}




}
