package com.microservicios.app.alumnos.models.repository;

import org.springframework.data.repository.CrudRepository;

import com.microservicios.app.alumnos.entity.Alumnos;

public interface AlumnosRepository extends CrudRepository<Alumnos, Long> {

}
