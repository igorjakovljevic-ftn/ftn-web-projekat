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
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
@SuppressWarnings("serial")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
@Entity
public class Room implements Serializable {
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
	
	@Column
	private Long capacity;
	
	@Column
	private String mark;
	
	@JsonIgnore
	@ManyToMany(cascade = CascadeType.ALL)
	@JoinTable(name = "ROOM_PROJECTION", joinColumns = @JoinColumn(name = "room_id", referencedColumnName = "id"), inverseJoinColumns = @JoinColumn(name = "projection_id", referencedColumnName = "id"))
	private Set<Projection> projections = new HashSet<>();
	
	@JsonIgnore
	@ManyToOne(fetch = FetchType.EAGER)
	private Cinema cinema;
	
	public Room(Long capacity, String mark, Set<Projection> projections, Cinema cinema) {
		this.capacity = capacity;
		this.mark = mark;
		this.projections = projections;
		this.cinema = cinema;
	}
	
	public Room() {}

	public Long getCapacity() {
		return capacity;
	}
	
	public Cinema getCinema() {
		return cinema;
	}
	
	public Long getId() {
		return id;
	}
	
	public String getMark() {
		return mark;
	}
	
	public Set<Projection> getProjections() {
		return projections;
	}
	
	public void setCapacity(Long capacity) {
		this.capacity = capacity;
	}
	
	public void setCinema(Cinema cinema) {
		this.cinema = cinema;
	}
	
	public void setId(Long id) {
		this.id = id;
	}
	
	public void setMark(String mark) {
		this.mark = mark;
	}
	
	public void setProjections(Set<Projection> projections) {
		this.projections = projections;
	}
	
}
