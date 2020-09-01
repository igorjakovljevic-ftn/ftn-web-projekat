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
import faks.web.projekat.entity.dto.CinemaDTO;
import faks.web.projekat.service.impl.CinemaServiceImpl;

@Controller
public class CinemaController {
	
	@Autowired
	private CinemaServiceImpl cinemaService;
	
	
	@PostMapping("/add-cinema")
	public ResponseEntity<?> addCinema(@RequestBody CinemaDTO cinDTO){
		Cinema cinema = cinemaService.save(Cinema.getCinemaByDTO(cinDTO));
		if (cinema == null)
			return new ResponseEntity<>(HttpStatus.CONFLICT);
		return new ResponseEntity<Cinema>(cinema, HttpStatus.OK);
	}
	
	@PutMapping("/edit_cinema")
	public ResponseEntity<?> editCinema(@RequestBody Cinema cinema){
		try{
			this.cinemaService.editCinema(cinema);
			return new ResponseEntity<>(HttpStatus.OK);
		}catch(Exception e) {
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
	}
	
	@GetMapping("/cinemas")
	public String findCinemas(Model model) {
		List<Cinema> cinemas = this.cinemaService.findAll();
		model.addAttribute("cinemas", cinemas);
		return "cinemas.html";
	}
	
	@DeleteMapping("/cinemas/{id}")
	public ResponseEntity<?> deleteCinema(@PathVariable(name="id") Long id){
		if(cinemaService.deleteById(id))
			return new ResponseEntity<>(HttpStatus.OK);
		else
			return new ResponseEntity<>(HttpStatus.CONFLICT);
	}
	
	
	@GetMapping("/cinema/{id}")
	public String oneCinema(@PathVariable(name="id") Long id,Model model) {
		Cinema cinema = this.cinemaService.findOne(id);
		model.addAttribute("cinema", cinema);
		return "cinema.html";
	}
	

}
