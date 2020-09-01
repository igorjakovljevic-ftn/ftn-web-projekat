package faks.web.projekat.entity.dto;

import java.sql.Date;


public class ProjectionDTO {

	private Date day;
	private String time;
	private Long price;
	private Long movie_id;
	private Long room_id;
	private Long cinema_id;
	
	public ProjectionDTO() {}
	
	public Long getCinema_id() {
		return cinema_id;
	}
	
	public Date getDay() {
		return day;
	}
	
	public Long getMovie_id() {
		return movie_id;
	}
	
	public Long getPrice() {
		return price;
	}
	
	public Long getRoom_id() {
		return room_id;
	}
	
	public String getTime() {
		return time;
	}
	
	public void setCinema_id(Long cinema_id) {
		this.cinema_id = cinema_id;
	}
	
	public void setDay(Date day) {
		this.day = day;
	}
	
	public void setMovie_id(Long movie_id) {
		this.movie_id = movie_id;
	}
	
	public void setPrice(Long price) {
		this.price = price;
	}
	
	public void setRoom_id(Long room_id) {
		this.room_id = room_id;
	}
	
	public void setTime(String time) {
		this.time = time;
	}
}
