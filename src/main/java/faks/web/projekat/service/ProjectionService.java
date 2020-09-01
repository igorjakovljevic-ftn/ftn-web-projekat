package faks.web.projekat.service;

import java.util.List;

import faks.web.projekat.entity.Projection;
import faks.web.projekat.entity.dto.ProjectionDTO;

public interface ProjectionService {
	public Projection findOne(Long id);
	public List<Projection> findAll();
	public Projection save(Projection projection);
	public List<Projection> findByCinemaId(Long id);
	public void addProjection(ProjectionDTO projectionDTO);
}
