package faks.web.projekat.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import faks.web.projekat.entity.Movie;
@Repository
public interface MovieRepo extends JpaRepository<Movie,Long>{
	@Modifying
	@Query("update Movie set rating = :rating WHERE id = :movieId")
    void setRating(@Param("movieId") Long id, @Param("rating") double rating);
}
