package faks.web.projekat.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import faks.web.projekat.entity.Movie;
import faks.web.projekat.entity.dto.MoviesDTO;
import faks.web.projekat.service.impl.MovieServiceImpl;

@Controller
public class MovieController {
	@Autowired
	private MovieServiceImpl movieService;
	
	@GetMapping("/movies")
	public String movies(Model model) {
		MoviesDTO movDTO = this.movieService.getData();
		model.addAttribute("moviesDTO", movDTO);
		return "movies.html";
	}
	
	@GetMapping("/movie/{id}")
	public String getMovie(@PathVariable(name = "id") Long id,Model model){
		Movie movie=this.movieService.findOne(id);
		model.addAttribute("movie", movie);
		return "movie.html";
	}
}
