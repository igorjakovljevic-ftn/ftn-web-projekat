package faks.web.projekat.entity;

import java.io.Serializable;
import java.sql.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
@SuppressWarnings("serial")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
@Entity
public class Projection implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column
	private Date day;
	
	@Column
	private String time;
	
	@Column
	private Long price;
	
	@JsonIgnore
	@ManyToOne(fetch = FetchType.EAGER)
	private Movie movie;
	
	@ManyToMany(mappedBy = "projections", cascade = CascadeType.ALL)
	private Set<Room> rooms = new HashSet<>();
	
	@JsonIgnore
	@ManyToOne(fetch = FetchType.EAGER)
	private Cinema cinema;
	
	@JsonIgnore
	@ManyToMany(mappedBy = "reserved_tickets")
	private Set<User> users = new HashSet<>();
	
	public Projection(Long id, Date day,String time, Long price, Movie movie, Set<Room> rooms, Cinema cinema, Set<User> users) {
		this.id = id;
		this.day = day;
		this.price = price;
		this.movie = movie;
		this.time=time;
		this.rooms = rooms;
		this.cinema = cinema;
		this.users = users;
	}
	
	public Projection() {}

	public Cinema getCinema() {
		return cinema;
	}
	
	public Date getDay() {
		return day;
	}
	
	public Long getId() {
		return id;
	}
	
	public Movie getMovie() {
		return movie;
	}
	
	public Long getPrice() {
		return price;
	}
	
	public Set<Room> getRooms() {
		return rooms;
	}
	
	public String getTime() {
		return time;
	}
	
	public Set<User> getUsers() {
		return users;
	}
	
	public void setCinema(Cinema cinema) {
		this.cinema = cinema;
	}
	
	public void setDay(Date day) {
		this.day = day;
	}
	
	public void setId(Long id) {
		this.id = id;
	}
	
	public void setMovie(Movie movie) {
		this.movie = movie;
	}
	
	public void setPrice(Long price) {
		this.price = price;
	}
	
	public void setRooms(Set<Room> rooms) {
		this.rooms = rooms;
	}
	
	public void setTime(String time) {
		this.time = time;
	}
	
	public void setUsers(Set<User> users) {
		this.users = users;
	}
	
	
}