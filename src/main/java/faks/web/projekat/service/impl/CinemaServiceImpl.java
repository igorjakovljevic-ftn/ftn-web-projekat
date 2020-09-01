package faks.web.projekat.service.impl;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import faks.web.projekat.entity.Cinema;
import faks.web.projekat.entity.Projection;
import faks.web.projekat.entity.Room;
import faks.web.projekat.entity.User;
import faks.web.projekat.repository.CinemaRepo;
import faks.web.projekat.service.CinemaService;
@Transactional
@Service
public class CinemaServiceImpl implements CinemaService{

	@Autowired
	private CinemaRepo cinemaRepository;
	
	@Autowired
	private UserServiceImpl userService;
	

	public Cinema findOne(Long id) {
		Cinema cinema = this.cinemaRepository.findById(id).get();
		return cinema;
	}

	public List<Cinema> findAll() {
		List<Cinema> cinemas = this.cinemaRepository.findAll();
		return cinemas;
	}

	public Cinema save(Cinema cinema) {
		if (cinema.getName().trim().length() <= 3 || cinema.getAddress().trim().length() <= 3
				|| cinema.getEmail().trim().length() <= 3 || cinema.getPhone_number().trim().length() <= 3) {
			return null;
		}
		return this.cinemaRepository.save(cinema);
	}

	public void editCinema(Cinema cinema) {
		this.cinemaRepository.updateCinema(cinema.getId(),cinema.getName(),cinema.getAddress(),cinema.getPhone_number(),cinema.getEmail());
	}
	
	public boolean deleteById(Long id) {
		try {
			Cinema cinema = cinemaRepository.findById(id).get();
			List<User> users = this.userService.findAll();
			for(int i=0;i<users.size();i++) {
				for(Projection proj: users.get(i).getReserved_tickets()) {
					if(proj.getCinema().getId()==cinema.getId()) {
						users.get(i).getReserved_tickets().remove(proj);	
					}
				}
			}
			for(Room room : cinema.getRooms()){
				  	room.getProjections().clear();
			}
			cinema.getSchedule().clear();
			cinema.getRooms().clear();
			cinemaRepository.delete(cinema);
			return true;
		} catch (Exception e) {
			return false;
		}
	}
	
}
