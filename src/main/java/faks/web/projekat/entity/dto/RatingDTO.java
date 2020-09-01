package faks.web.projekat.entity.dto;

public class RatingDTO {
	
	private Long movie_id;
	private Long watched_movie_id;
	private Long rating;

	public RatingDTO(Long movie_id, Long watched_movie_id, Long rating) {
		super();
		this.movie_id = movie_id;
		this.watched_movie_id = watched_movie_id;
		this.rating = rating;
	}
	
	public RatingDTO() {
		
	}
	
	public Long getMovie_id() {
		return movie_id;
	}
	
	public Long getRating() {
		return rating;
	}
	
	public Long getWatched_movie_id() {
		return watched_movie_id;
	}
	
	public void setMovie_id(Long movie_id) {
		this.movie_id = movie_id;
	}
	
	public void setRating(Long rating) {
		this.rating = rating;
	}
	
	public void setWatched_movie_id(Long watched_movie_id) {
		this.watched_movie_id = watched_movie_id;
	}
}
