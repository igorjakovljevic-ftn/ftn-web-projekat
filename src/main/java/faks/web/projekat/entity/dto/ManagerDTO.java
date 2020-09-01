package faks.web.projekat.entity.dto;

import java.sql.Date;

import faks.web.projekat.entity.Roles;

public class ManagerDTO {
	private Long cinema_id;
	private String name;
	private String lastname;
	private String email;
	private String password;
	private String username;
	private String phone_number;
	private Date date;
	private Roles role;
	private boolean activity;
	
	public ManagerDTO() {}
	
	public Long getCinema_id() {
		return cinema_id;
	}
	
	public Date getDate() {
		return date;
	}
	
	public String getEmail() {
		return email;
	}
	
	public String getLastname() {
		return lastname;
	}
	
	public String getName() {
		return name;
	}
	
	public String getPassword() {
		return password;
	}
	
	public String getPhone_number() {
		return phone_number;
	}
	
	public Roles getRole() {
		return role;
	}
	
	public String getUsername() {
		return username;
	}
	
	public void setActivity(boolean activity) {
		this.activity = activity;
	}
	
	public void setCinema_id(Long cinema_id) {
		this.cinema_id = cinema_id;
	}
	
	public void setDate(Date date) {
		this.date = date;
	}
	
	public void setEmail(String email) {
		this.email = email;
	}
	
	public void setLastname(String lastname) {
		this.lastname = lastname;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public void setPassword(String password) {
		this.password = password;
	}
	
	public void setPhone_number(String phone_number) {
		this.phone_number = phone_number;
	}
	
	public void setRole(Roles role) {
		this.role = role;
	}
	
	public void setUsername(String username) {
		this.username = username;
	}
	
	public boolean isActivity() {
		return activity;
	}
	
}
