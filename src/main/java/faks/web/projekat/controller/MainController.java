package faks.web.projekat.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller 
public class MainController {

	@GetMapping("/")
	public String initialize(){
		return "index.html";
	}
}
