package com.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.model.entity.Estudiante;
import com.services.EstudianteSVC;

@Controller
public class Controlador {

	@Autowired
	private EstudianteSVC estudianteSvc;
	
	@GetMapping("/")
	public String inicio(Model model, @Param("palabraClave") String palabraClave) {
		var estudiantes = estudianteSvc.listadoEstudiantes(palabraClave);
		model.addAttribute("estudiantes", estudiantes);
		model.addAttribute("palabraClave", palabraClave);
		return "index";
	}
	
	@GetMapping("/agregar")
	public String agregar(Estudiante estudiante) {
		return "addmod";
    }
	
	@PostMapping("/guardar")
    public String guardar(@Validated Estudiante estudiante, Errors errores) {
    	if(errores.hasErrors()) {
    		return "addmod";
        }
    estudianteSvc.guardar(estudiante);
    return "redirect:/";
    }
	
	@GetMapping("/editar/{idEstudiante}")
	public String editar(Estudiante estudiante, Model model) {
		estudiante = estudianteSvc.encontrar(estudiante);
		model.addAttribute("estudiante", estudiante);
		return "addmod";
	}
	
	@GetMapping("/eliminar/{idEstudiante}")
	public String eliminar(Estudiante estudiante) {
		estudianteSvc.eliminar(estudiante);
		return "redirect:/";
	}
	
	
}
