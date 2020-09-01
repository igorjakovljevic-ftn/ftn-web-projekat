package faks.web.projekat.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import faks.web.projekat.entity.Cinema;
import faks.web.projekat.entity.Room;
import faks.web.projekat.repository.RoomRepo;
import faks.web.projekat.service.RoomService;

@Service
public class RoomServiceImpl implements RoomService{

	@Autowired
	private RoomRepo roomRepository;
	 
	@Autowired
	private CinemaServiceImpl cinemaService;
	
	public boolean deleteById(Long cinema_id,Long room_id) {
		try {
			Cinema cinema = this.cinemaService.findOne(cinema_id);
			Room room = this.roomRepository.findById(room_id).get();
			
			cinema.getRooms().remove(room);
			room.getProjections().clear();
			
			this.roomRepository.deleteById(room_id);
			return true;
		}catch(Exception e) {
			return false;
		}
	}
	
	public Room findOne(Long id){
		Room room = this.roomRepository.findById(id).get();
		return room;
	}
	
	public List<Room> findAll(){
		List<Room> rooms = this.roomRepository.findAll();
		return rooms;
	}
	
	public Room save(Room room) {
		return this.roomRepository.save(room);
	}
	
	public void editRoom(Room room) {
		this.roomRepository.updateRoom(room.getId(),room.getCapacity(),room.getMark());
	}
}
