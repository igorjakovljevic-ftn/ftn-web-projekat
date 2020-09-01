package faks.web.projekat.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
@SuppressWarnings("serial")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
@Entity
public class Movie_rating implements Serializable {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@JsonIgnore
	@ManyToOne
	private User user;
	
	@ManyToOne
	private Movie movie;
	
	@Column
	private long rating;
	
	public Movie_rating(Long id, User user, Movie movie, long rating) {
		this.id = id;
		this.user = user;
		this.movie = movie;
		this.rating = rating;
	}
	
	public Movie_rating()
	{}

	public Long getId() {
		return id;
	}
	
	public Movie getMovie() {
		return movie;
	}
	
	public long getRating() {
		return rating;
	}
	
	public User getUser() {
		return user;
	}
	
	public void setId(Long id) {
		this.id = id;
	}
	
	public void setMovie(Movie movie) {
		this.movie = movie;
	}
	
	public void setRating(long rating) {
		this.rating = rating;
	}
	
	public void setUser(User user) {
		this.user = user;
	}
	
}
