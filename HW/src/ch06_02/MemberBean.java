package ch06_02; 

import java.io.Serializable;

public class MemberBean implements Serializable {
	private static final long serialVersionUID = 1L;
	private int memberId;   			
	private String area;   			
	private String country;       			
	private String name;    			
	private String address;     			
	private String tel;  

	
	public MemberBean() {
	} 
	
	public MemberBean(int memberId, String area, String country, String name,String address
			, String tel) {
		super();
		this.memberId = memberId;
		this.area = area;
		this.country = country;
		this.name = name;
		this.address = address;
		this.tel = tel;
	}

	
	public String toString() {
		return "["+memberId+","+area+","+country+","+address+","+tel+"]";
	}	

	public int getMemberId() {
		return memberId;
	}

	public void setMemberId(int memberId) {
		this.memberId = memberId;
	}

	public String getArea() {
		return area;
	}

	public void setArea(String area) {
		this.area = area;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public void setTel(String tel) {
		this.tel = tel;
	}
	
	public String getTel() {
		return tel;
	}
}