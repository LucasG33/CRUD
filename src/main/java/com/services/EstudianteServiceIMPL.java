package com.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.dao.EstudianteDAO;
import com.model.entity.Estudiante;

@Service
public class EstudianteServiceIMPL implements EstudianteSVC{
	
	@Autowired
	private EstudianteDAO estudianteDao;

	@Override
	@Transactional(readOnly=true)
	public List<Estudiante> listadoEstudiantes(String palabraClave) {
		if(palabraClave != null) {
			return estudianteDao.findAll(palabraClave);
		}
	return (List<Estudiante>) estudianteDao.findAll();	
	}

	@Override
	@Transactional
	public void guardar(Estudiante estudiante) {
		estudianteDao.save(estudiante);
		
	}

	@Override
	@Transactional
	public Estudiante encontrar(Estudiante estudiante) {
		return estudianteDao.findById(estudiante.getIdEstudiante()).orElse(null);
	}

	@Override
	@Transactional
	public void eliminar(Estudiante estudiante) {
		estudianteDao.delete(estudiante);
		
	}

}
