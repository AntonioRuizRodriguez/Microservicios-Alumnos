package com.microservicios.app.alumnos.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.microservicios.app.alumnos.entity.Alumnos;
import com.microservicios.app.alumnos.models.repository.AlumnosRepository;

@Service
public class AlumnosServiceImpl implements AlumnoService {
	
	@Autowired
	AlumnosRepository repository;
	

	@Override
	@Transactional(readOnly = true)
	public Iterable<Alumnos> findAll() {
		 
		repository.findAll();
		return null;
	}

	@Override
	@Transactional(readOnly = true)
	public Optional<Alumnos> findById(Long id) {
		 
		repository.findById(id);
		return null;
	}

	@Override
	@Transactional
	public Alumnos save(Alumnos alumno) {
		 
		repository.save(alumno);
		return null;
	}

	@Override
	@Transactional
	public void deleteById(Long id) {
		 
		repository.deleteById(id);
	}

}
