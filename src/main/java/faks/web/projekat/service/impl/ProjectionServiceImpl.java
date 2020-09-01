package faks.web.projekat.service.impl;


import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import faks.web.projekat.entity.Cinema;
import faks.web.projekat.entity.Movie;
import faks.web.projekat.entity.Projection;
import faks.web.projekat.entity.Room;
import faks.web.projekat.entity.dto.ProjectionDTO;
import faks.web.projekat.repository.ProjectionRepo;
import faks.web.projekat.service.ProjectionService;

@Service
public class ProjectionServiceImpl implements ProjectionService{
	@Autowired
	private ProjectionRepo projectionRepository;
	
	@Autowired
	private CinemaServiceImpl cinemaService;
	
	@Autowired
	private MovieServiceImpl movieService;
	
	@Autowired
	private RoomServiceImpl roomService;
	
	public Projection findOne(Long id) {
		Projection projection = this.projectionRepository.findById(id).get();
		return projection;
	}
	
	public List<Projection> findByCinemaId(Long id)
	{
		return projectionRepository.findByCinemaId(id);
	}
	
	public List<Projection> findAll(){
		List<Projection> projections = this.projectionRepository.findAll();
		return projections;
	}
	public Projection save(Projection projection) {
		return this.projectionRepository.save(projection);
	}
	
	public void addProjection(ProjectionDTO projectionDTO) {
		Projection projection = new Projection();
		Cinema cinema = this.cinemaService.findOne(projectionDTO.getCinema_id());
		Movie movie = this.movieService.findOne(projectionDTO.getMovie_id());
		Room room = this.roomService.findOne(projectionDTO.getRoom_id());
		
		projection.setCinema(cinema);
		projection.setMovie(movie);
		projection.getRooms().add(room);
		projection.setDay(projectionDTO.getDay());
		projection.setPrice(projectionDTO.getPrice());
		projection.setTime(projectionDTO.getTime());
		projection.setUsers(null);
		
		cinema.getSchedule().add(projection);
		room.getProjections().add(projection);
		this.projectionRepository.save(projection);
		
	}
}
