package faks.web.projekat.service;

import java.util.List;

import faks.web.projekat.entity.Movie_rating;

public interface Movie_ratingService {
	public Movie_rating findOne(Long id);
	public List<Movie_rating> findAll();
	public Movie_rating save(Movie_rating movie_rating);
	public List<Movie_rating> getRatedMovies(Long id);
	public void setRating(Long id,long rating);
	public double calculateRating(Long id);
}
