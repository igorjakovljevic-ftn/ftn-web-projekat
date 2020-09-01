package faks.web.projekat.service;

import java.util.List;

import faks.web.projekat.entity.Cinema;

public interface CinemaService {
	public Cinema findOne(Long id);
	public List<Cinema> findAll();
	public Cinema save(Cinema cinema);
	public boolean deleteById(Long id);
	public void editCinema(Cinema cinema);
}
