package faks.web.projekat.entity.dto;

import java.util.List;

import faks.web.projekat.entity.Movie;

public class MoviesDTO {
	
	private List<Movie> movies;
	private List<String> genres;
	
	public MoviesDTO(List<Movie> movies, List<String> genres) {
		super();
		this.movies = movies;
		this.genres = genres;
	}
	
	public MoviesDTO(){}
	
	public List<String> getGenres() {
		return genres;
	}
	
	public List<Movie> getMovies() {
		return movies;
	}
	
	public void setGenres(List<String> genres) {
		this.genres = genres;
	}
	
	public void setMovies(List<Movie> movies) {
		this.movies = movies;
	}

}
