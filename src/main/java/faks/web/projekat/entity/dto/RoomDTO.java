package faks.web.projekat.entity.dto;

public class RoomDTO {
	
	private Long cinema_id;
	private Long capacity;
	private String mark;
	
	public RoomDTO() {
		
	}

	public Long getCapacity() {
		return capacity;
	}
	
	public Long getCinema_id() {
		return cinema_id;
	}
	
	public String getMark() {
		return mark;
	}
	
	public void setCapacity(Long capacity) {
		this.capacity = capacity;
	}
	
	public void setCinema_id(Long cinema_id) {
		this.cinema_id = cinema_id;
	}
	
	public void setMark(String mark) {
		this.mark = mark;
	}
	
}
