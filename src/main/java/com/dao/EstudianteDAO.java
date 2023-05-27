package com.dao;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.model.entity.*;

public interface EstudianteDAO extends CrudRepository<Estudiante, Long> {

	@Query("SELECT e FROM Estudiante e WHERE e.nombre LIKE %?1%" + " OR e.apellido LIKE %?1%" + " OR e.email LIKE %?1%" + " OR e.facultad LIKE %?1%")
	   public List<Estudiante> findAll(String palabraClave);
}
