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
@SuppressWarnings("serial")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
@Entity
public class Movie implements Serializable {
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
	
	@Column
	private String name;
	
	@Column
	private String description;
		
	@Column
	private String genre;
	
	@Column
	private Long duration;// u minutima
	
	@Column 
	private double rating;
	
	@JsonIgnore
	@OneToMany(mappedBy = "movie", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	private Set<Movie_rating> watched_movies = new HashSet<>();
	
	@OneToMany(mappedBy = "movie", fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	private Set<Projection> projections = new HashSet<>();
	
	public Movie(long id, String name, String description, String genre, long duration, double rating) {
		this.id = id;
		this.name = name;
		this.description = description;
		this.genre = genre;
		this.duration = duration;
		this.rating = rating;
	}
	
	public Movie() {
		rating=0;
	}
	
	public String getDescription() {
		return description;
	}
	
	public Long getDuration() {
		return duration;
	}
	
	public String getGenre() {
		return genre;
	}
	
	public Long getId() {
		return id;
	}
	
	public String getName() {
		return name;
	}
	
	public Set<Projection> getProjections() {
		return projections;
	}
	
	public double getRating() {
		return rating;
	}
	
	public Set<Movie_rating> getWatched_movies() {
		return watched_movies;
	}
	
	public void setDescription(String description) {
		this.description = description;
	}
	
	public void setDuration(Long duration) {
		this.duration = duration;
	}
	
	public void setGenre(String genre) {
		this.genre = genre;
	}
	
	public void setId(Long id) {
		this.id = id;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public void setProjections(Set<Projection> projections) {
		this.projections = projections;
	}
	
	public void setRating(double rating) {
		this.rating = rating;
	}
	
	public void setWatched_movies(Set<Movie_rating> watched_movies) {
		this.watched_movies = watched_movies;
	}
	
}
