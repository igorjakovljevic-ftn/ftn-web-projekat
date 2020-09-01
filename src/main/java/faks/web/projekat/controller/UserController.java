package faks.web.projekat.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

import faks.web.projekat.entity.Cinema;
import faks.web.projekat.entity.Movie;
import faks.web.projekat.entity.Room;
import faks.web.projekat.entity.User;
import faks.web.projekat.entity.dto.ManagerDTO;
import faks.web.projekat.entity.dto.ProjectionDTO;
import faks.web.projekat.entity.dto.RatingDTO;
import faks.web.projekat.entity.dto.ReservationDTO;
import faks.web.projekat.entity.dto.RoomDTO;
import faks.web.projekat.entity.dto.UserDTO;
import faks.web.projekat.service.impl.CinemaServiceImpl;
import faks.web.projekat.service.impl.MovieServiceImpl;
import faks.web.projekat.service.impl.ProjectionServiceImpl;
import faks.web.projekat.service.impl.RoomServiceImpl;
import faks.web.projekat.service.impl.UserServiceImpl;

@Controller
public class UserController {

	@Autowired
	private UserServiceImpl userService;	
	@Autowired
	private CinemaServiceImpl cinemaService;
	@Autowired
	private RoomServiceImpl roomService;
	@Autowired 
	private MovieServiceImpl movieService;
	@Autowired
	private ProjectionServiceImpl projectionService;
	
	
	@PostMapping("/register-user")
	public ResponseEntity<?> registerUser(@RequestBody User newUser) {
		User user;
		try {
			user = userService.save(newUser);
		} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.CONFLICT);
		}
		return new ResponseEntity<User>(user, HttpStatus.OK);
	}
	
	
	@GetMapping("/account/{id}/reservations")
	public String showReservations(@PathVariable(name = "id") Long id, Model model) {
		User user = this.userService.findOne(id);
		model.addAttribute("user", user);
		return "reservations.html";
	}
	
	@PostMapping("/login")
	public ResponseEntity<?> login(@RequestBody UserDTO usrDTO) {
		User user;
		try {
			user = this.userService.checkEmail(usrDTO);
		} catch (Exception e) {
			return new ResponseEntity<String>(e.getMessage(), HttpStatus.NOT_ACCEPTABLE);
		}
		if(user == null) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		if(!(this.userService.login(usrDTO, user))) {
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
		return new ResponseEntity<User>(user, HttpStatus.OK);
	}
	
	@GetMapping("/account/{id}")
	public String showAccount(@PathVariable(name = "id") Long id, Model model) {
		User user = this.userService.findOne(id);
		model.addAttribute("user", user);
		return "account.html";
	}
	
	@GetMapping("/account/{id}/watched_movies")
	public String showWatchedMovies(@PathVariable(name = "id") Long id, Model model) {
		User user = this.userService.findOne(id);
		model.addAttribute("user", user);
		return "watched_movies.html";
	}
	
	@PutMapping("/rate")
	public ResponseEntity<?> rateMovie(@RequestBody RatingDTO ratDTO){
		try{
			this.userService.RateIt(ratDTO.getRating(), ratDTO.getMovie_id(), ratDTO.getWatched_movie_id());
			return new ResponseEntity<>(HttpStatus.OK);
		}catch(Exception e) {
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
	}
	
	@DeleteMapping("/cancel_reservation")
	public ResponseEntity<?> cancelReservation(@RequestBody ReservationDTO resDTO){
		try {
			this.userService.cancelReservation(resDTO.getUser_id(), resDTO.getProjection_id());
			return new ResponseEntity<>(HttpStatus.OK);
		}catch(Exception e) {
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
	}
	
	@GetMapping("/register")
	public String registerInitialize(){
		return "register.html";
	}
	
	@GetMapping("/account/{id}/managers")
	public String showManagers(@PathVariable(name = "id") Long id, Model model) {
		List<User> managers = this.userService.getManagers();
		User user = this.userService.findOne(id);
		model.addAttribute("managers", managers);
		model.addAttribute("user",user);
		return "managers.html";
	}
	
	@GetMapping("/account/{id}/register_man")
	public String registerManager(@PathVariable(name = "id") Long id,Model model) {
		List<Cinema> cinemas = this.cinemaService.findAll();
		User user = this.userService.findOne(id);
		model.addAttribute("cinemas", cinemas);
		model.addAttribute("user",user);
		return "register_manager.html";
	}
	
	@DeleteMapping("/remove_manager/{id}")
	public ResponseEntity<?> removeManager(@PathVariable(name = "id") Long id) {	
		try{
			this.userService.deleteUser(id);
			return new ResponseEntity<>(HttpStatus.OK);
		}catch(Exception e) {
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
	}
	
	@PostMapping("/register-manager")
	public ResponseEntity<?> createManager(@RequestBody ManagerDTO manDTO) {
		try {
			this.userService.saveManager(manDTO);
		} catch (Exception e) {
			e.printStackTrace();
			return new ResponseEntity<>(HttpStatus.CONFLICT);
		}
		return new ResponseEntity<>(HttpStatus.OK);
	}
	
	@PostMapping("/reserve_ticket")
	public ResponseEntity<?> reserveTicket(@RequestBody ReservationDTO resDTO){
		boolean flag = false;
		try {
			flag = this.userService.addReservation(resDTO.getUser_id(), resDTO.getProjection_id());
			if(flag)
				return new ResponseEntity<>(HttpStatus.OK);
			else
				return new ResponseEntity<>(HttpStatus.CONFLICT);
		}catch(Exception e) {
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
	}
	
	@DeleteMapping("/delete_room/{cinema_id}/room/{room_id}")
	public ResponseEntity<?> deleteRoom(@PathVariable(name = "cinema_id") Long cinema_id, @PathVariable(name = "room_id") Long room_id) {	
		try{
			if(this.roomService.deleteById(cinema_id, room_id))
				return new ResponseEntity<>(HttpStatus.OK);
			else
				return new ResponseEntity<>(HttpStatus.CONFLICT);
		}catch(Exception e) {
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
	}
	
	@GetMapping("/account/{id}/cinema")
	public String manageCinemas(@PathVariable(name = "id") Long id, Model model) {
		User user = this.userService.findOne(id);
		Cinema cinema = user.getCinema();
		model.addAttribute("cinema", cinema);
		model.addAttribute("user",user);
		return "manager_cinemas.html";
	}
	
	
	@PostMapping("/add_room")
	public ResponseEntity<?> addRoom(@RequestBody RoomDTO roomDTO) {
		try {
			userService.addRoom(roomDTO);
			return new ResponseEntity<>(HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.CONFLICT);
		}
		
	}
	
	@GetMapping("/account/{id}/schedule")
	public String showSchedule(@PathVariable(name="id")Long id, Model model) {
		User user = this.userService.findOne(id);
		Cinema cinema = user.getCinema();
		List<Movie> movies = this.movieService.findAll();
		model.addAttribute("user", user);
		model.addAttribute("cinema", cinema);
		model.addAttribute("movies", movies);
		return "schedule.html";
	}
	
	@PutMapping("/edit_room")
	public ResponseEntity<?> editRoom(@RequestBody Room room){
		try{
			this.userService.editRoom(room);
			return new ResponseEntity<>(HttpStatus.OK);
		}catch(Exception e) {
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
	}
	
	@GetMapping("/account/{id}/cinema/room/{room_id}")
	public String editRoom(@PathVariable(name = "id") Long id,@PathVariable(name = "room_id") Long room_id,Model model) {
		Room room = this.roomService.findOne(room_id);
		model.addAttribute("room", room);
		return "auditorium.html";
	}
	
	
	@PostMapping("/add_projection")
	public ResponseEntity<?> addProjection(@RequestBody ProjectionDTO projDTO) {
		try {
			this.projectionService.addProjection(projDTO);
			return new ResponseEntity<>(HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.CONFLICT);
		}
		
	}
}