package faks.web.projekat.service;

import java.util.List;

import faks.web.projekat.entity.Room;

public interface RoomService {
	public Room findOne(Long id);
	public List<Room> findAll();
	public Room save(Room room);
	public void editRoom(Room room);
	public boolean deleteById(Long cinema_id,Long room_id);
}
