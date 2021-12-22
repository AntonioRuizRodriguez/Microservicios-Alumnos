package com.microservicios.app.alumnos.services;

import java.util.Optional;

import com.microservicios.app.alumnos.entity.Alumnos;

public interface AlumnoService {
	
	public Iterable<Alumnos> findAll();
	
	public Optional<Alumnos> findById(Long id);
	
	public Alumnos save(Alumnos alumno);
	
	public void deleteById(Long id);
}
