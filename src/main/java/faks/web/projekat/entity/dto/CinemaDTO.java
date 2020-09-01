package faks.web.projekat.entity.dto;


public class CinemaDTO {
	
	private String name;
	private String address;
	private String phone_number;
	private String email;

	public CinemaDTO() {}

	public String getAddress() {
		return address;
	}
	
	public String getEmail() {
		return email;
	}
	
	public String getName() {
		return name;
	}
	
	public String getPhone_number() {
		return phone_number;
	}
	
	public void setAddress(String address) {
		this.address = address;
	}
	
	public void setEmail(String email) {
		this.email = email;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public void setPhone_number(String phone_number) {
		this.phone_number = phone_number;
	}
	
}
