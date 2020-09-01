package faks.web.projekat.service;

import java.util.List;

import faks.web.projekat.entity.Movie;
import faks.web.projekat.entity.dto.MoviesDTO;

public interface MovieService {
	public Movie findOne(Long id);
	public List<Movie> findAll();
	public Movie save(Movie movie);
	public MoviesDTO getData();
	public void setRating(Long id,double rating);
}
