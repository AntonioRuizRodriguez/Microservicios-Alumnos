package com.microservicios.app.alumnos.controllers;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.microservicios.app.alumnos.entity.Alumnos;
import com.microservicios.app.alumnos.services.AlumnoService;

@RestController
public class AlumnosControllers {
	
	@Autowired AlumnoService service;
	
	@GetMapping
	public ResponseEntity<?> listar(){
		return ResponseEntity.ok().body(service.findAll());
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<?> verDetalle(@PathVariable Long id){
		
		ResponseEntity<?> response;  
		Optional<Alumnos> alumno=service.findById(id);
		
		if(alumno.isEmpty()) {
			response=ResponseEntity.notFound().build();
		}else {
			response=ResponseEntity.ok(alumno.get());
		}
		
		return response;
	}
	
	@PostMapping
	public ResponseEntity<?> crear(@RequestBody Alumnos alumno){
		Alumnos alumnoDb=service.save(alumno);
		return ResponseEntity.status(HttpStatus.CREATED).body(alumnoDb);
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<?> editar(@RequestBody Alumnos alumno, @PathVariable Long id){
		
		ResponseEntity<?> response;  
		
		Optional<Alumnos> a=service.findById(id);
		
		
		if(a.isEmpty()) {
			response=ResponseEntity.notFound().build();
		}else {
			
			Alumnos alumnoDb=a.get();
			alumnoDb.setNombre(alumno.getNombre());
			alumnoDb.setApellido(alumno.getApellido());
			alumnoDb.setEmail(alumno.getEmail());
			
			response=ResponseEntity.status(HttpStatus.CREATED).body(service.save(alumnoDb));
		}
		
		return response;
		
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<?> eliminar(@PathVariable Long id){
		service.deleteById(id);
		return ResponseEntity.noContent().build();
	}

}


















