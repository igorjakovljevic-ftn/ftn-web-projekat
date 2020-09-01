package faks.web.projekat.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import faks.web.projekat.entity.Movie_rating;
@Repository
public interface Movie_ratingRepo extends JpaRepository<Movie_rating,Long>{
	List<Movie_rating> findByMovieId(Long id);
	@Modifying
	@Query("update Movie_rating set rating = :rating WHERE id = :Id")
    void setRating(@Param("Id") Long id, @Param("rating") long rating);
}
