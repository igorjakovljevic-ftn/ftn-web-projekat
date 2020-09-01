package faks.web.projekat.entity;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import faks.web.projekat.entity.dto.CinemaDTO;


@SuppressWarnings("serial")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
@Entity
public class Cinema implements Serializable {
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
	
	@Column
	private String name;
	
	@Column
	private String address;
	
	@Column
	private String phone_number;
	
	@Column
	private String email;
	
	@JsonIgnore
	@OneToMany(mappedBy="cinema", fetch = FetchType.EAGER)
	private Set<User> managers = new HashSet<>();
	
	@OneToMany(mappedBy="cinema", fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	private Set<Room> rooms = new HashSet<>();
	
	@OneToMany(mappedBy = "cinema", fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	private Set<Projection> schedule = new HashSet<>();
	
	public Cinema(long id, String name, String address, String phone_number, String email, Set<User> managers, Set<Room> rooms, Set<Projection> schedule) {
		this.id = id;
		this.name = name;
		this.address = address;
		this.phone_number = phone_number;
		this.email = email;
		this.managers = managers;
		this.rooms = rooms;
		this.schedule = schedule;
	}
	
	public static Cinema getCinemaByDTO(CinemaDTO cinemaDTO) {
		Cinema cinema=new Cinema();
		cinema.setAddress(cinemaDTO.getAddress());
		cinema.setEmail(cinemaDTO.getEmail());
		cinema.setName(cinemaDTO.getName());
		cinema.setPhone_number(cinemaDTO.getPhone_number());
		return cinema;
	}
	
	public Cinema() {
		
	}
	
	public String getAddress() {
		return address;
	}
	
	public String getEmail() {
		return email;
	}
	
	public Long getId() {
		return id;
	}
	
	public Set<User> getManagers() {
		return managers;
	}
	
	public String getName() {
		return name;
	}
	
	public String getPhone_number() {
		return phone_number;
	}
	
	public Set<Room> getRooms() {
		return rooms;
	}
	
	public Set<Projection> getSchedule() {
		return schedule;
	}
	
	public void setAddress(String address) {
		this.address = address;
	}
	
	public void setEmail(String email) {
		this.email = email;
	}
	
	public void setId(Long id) {
		this.id = id;
	}
	
	public void setManagers(Set<User> managers) {
		this.managers = managers;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public void setPhone_number(String phone_number) {
		this.phone_number = phone_number;
	}
	
	public void setRooms(Set<Room> rooms) {
		this.rooms = rooms;
	}
	
	public void setSchedule(Set<Projection> schedule) {
		this.schedule = schedule;
	}
	
}
