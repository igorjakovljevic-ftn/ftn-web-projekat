package faks.web.projekat.entity.dto;

public class UserDTO {
	
	private String email;
	private String password;
	
	public UserDTO() {}

	public String getEmail() {
		return email;
	}
	
	public String getPassword() {
		return password;
	}
	
	public void setEmail(String email) {
		this.email = email;
	}
	
	public void setPassword(String password) {
		this.password = password;
	}

}
