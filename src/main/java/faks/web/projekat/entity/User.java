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
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@SuppressWarnings("serial")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
@Entity
public class User implements Serializable{
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
	
	@Column(nullable = false, unique = true)
	private String username;
	
	@Column(nullable  =  false)
	private String password;
	
	@Column(nullable = false)
	private String name;
	
	@Column(nullable = false)
	private String lastname;
	
	@Column
	private String phone_number;
	
	@Column(nullable = false,unique = true)
	private String email;
	
	@Column
	private Date date;
	
	@Column(nullable = false)
	private Roles role;
	
	@Column
	private boolean activity;
	
	@OneToMany(mappedBy = "user", fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	Set<Movie_rating> watched_movies = new HashSet<>();
	
	@ManyToMany(cascade = CascadeType.ALL)
	@JoinTable(name = "RESERVATIONS", joinColumns = @JoinColumn(name = "user_id", referencedColumnName = "id"), inverseJoinColumns = @JoinColumn(name = "projection_id", referencedColumnName = "id"))
	Set<Projection> reserved_tickets = new HashSet<>();
	
	@ManyToOne(fetch = FetchType.EAGER)
	private Cinema cinema;
	
	public User(String username, String password, String name, String lastname, String phone_number, String email, Date date, Roles role, boolean activity, Cinema cinema,Set<Movie_rating> watched_movies, Set<Projection> reserved_tickets) {
		this.username = username;
		this.password = password;
		this.name = name;
		this.lastname = lastname;
		this.phone_number = phone_number;
		this.email = email;
		this.date = date;
		this.role = role;
		this.activity = activity;
		this.cinema = cinema;
		this.watched_movies = watched_movies;
		this.reserved_tickets = reserved_tickets;
	}
	
	public User()
	{}
	
	public Cinema getCinema() {
		return cinema;
	}
	
	public Date getDate() {
		return date;
	}
	
	public String getEmail() {
		return email;
	}
	
	public Long getId() {
		return id;
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
	
	public Set<Projection> getReserved_tickets() {
		return reserved_tickets;
	}
	
	public Roles getRole() {
		return role;
	}
	
	
	public String getUsername() {
		return username;
	}
	
	public Set<Movie_rating> getWatched_movies() {
		return watched_movies;
	}
	
	public void setActivity(boolean activity) {
		this.activity = activity;
	}
	
	public void setCinema(Cinema cinema) {
		this.cinema = cinema;
	}
	
	public void setDate(Date date) {
		this.date = date;
	}
	
	public void setEmail(String email) {
		this.email = email;
	}
	
	public void setId(Long id) {
		this.id = id;
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
	
	public void setReserved_tickets(Set<Projection> reserved_tickets) {
		this.reserved_tickets = reserved_tickets;
	}
	
	public void setRole(Roles role) {
		this.role = role;
	}
	
	public void setUsername(String username) {
		this.username = username;
	}
	
	public void setWatched_movies(Set<Movie_rating> watched_movies) {
		this.watched_movies = watched_movies;
	}

}
