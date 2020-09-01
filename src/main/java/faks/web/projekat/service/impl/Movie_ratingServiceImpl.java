package faks.web.projekat.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import faks.web.projekat.entity.Movie_rating;
import faks.web.projekat.repository.Movie_ratingRepo;
import faks.web.projekat.service.Movie_ratingService;

@Service
public class Movie_ratingServiceImpl implements Movie_ratingService{

	@Autowired
	private Movie_ratingRepo movie_ratingRepository;
	
	public double calculateRating(Long id) {
		List<Movie_rating> rated = this.movie_ratingRepository.findByMovieId(id);
		double avg = 0;
		int count = 0;
		for(int i = 0; i < rated.size(); i++) {
			if(rated.get(i).getRating()==0) {
				continue;
			}
			else {
				avg += rated.get(i).getRating();
				count++;
			}
		}
		avg /= count;
		return avg;
	}
	
	public Movie_rating findOne(Long id) {
		Movie_rating movie_rating = this.movie_ratingRepository.findById(id).get();
		return movie_rating;
	}
	
	public List<Movie_rating> findAll(){
		List<Movie_rating> movie_ratings=this.movie_ratingRepository.findAll();
		return movie_ratings;
	}
	
	public Movie_rating save(Movie_rating movie_rating) {
		return this.movie_ratingRepository.save(movie_rating);
	}
	
	public List<Movie_rating> getRatedMovies(Long id){
		return this.movie_ratingRepository.findByMovieId(id);
	}
	
	public void setRating(Long id,long rating) {
		this.movie_ratingRepository.setRating(id, rating);
	}
	
}
