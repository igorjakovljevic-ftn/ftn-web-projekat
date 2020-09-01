package faks.web.projekat.repository;


import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import faks.web.projekat.entity.Projection;
@Repository
public interface ProjectionRepo extends JpaRepository<Projection,Long> {
	List<Projection> findByCinemaId(Long id);
	
}
