package com.services;

import java.util.List;

import com.model.entity.Estudiante;

public interface EstudianteSVC {
	
	public List<Estudiante> listadoEstudiantes(String palabraClave);
	
	public void guardar(Estudiante estudiante);
	
	public Estudiante encontrar(Estudiante estudiante);
	
	public void eliminar(Estudiante estudiante);

}
