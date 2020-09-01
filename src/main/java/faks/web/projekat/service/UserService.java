package faks.web.projekat.service;

import java.util.List;

import faks.web.projekat.entity.Room;
import faks.web.projekat.entity.User;
import faks.web.projekat.entity.dto.ManagerDTO;
import faks.web.projekat.entity.dto.RoomDTO;
import faks.web.projekat.entity.dto.UserDTO;

public interface UserService {
	public User findOne(Long id);
	public List<User> findAll();
	public User save(User user);
	public boolean login(UserDTO userDTO, User user);
	public User checkEmail(UserDTO userDTO);
	public void RateIt(Long rating, Long movie_id, Long movie_rating_id);
	public void cancelReservation(Long user_id, Long projection_id);
	public List<User> getManagers();
	public void deleteUser(Long id);
	public void saveManager(ManagerDTO managerDTO);
	public boolean addReservation(Long user_id, Long projection_id);
	public void addRoom(RoomDTO roomDTO);
	public void editRoom(Room room);
}
