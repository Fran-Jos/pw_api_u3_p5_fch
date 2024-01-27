package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.modelo.Estudiante;
import com.example.demo.service.IEstudianteService;

//Una API puede tener muchos servicios
//API: determinada por el proyecto Java
//Un servicio tiene muchas capacidades
//Con una clase controller se implementa un controlador rest en una API
//Servicio -> Controller: Clase controller

@RestController // Servicio
@RequestMapping(path = "/estudiantes")
public class EstudianteControllerRestFul {

	@Autowired
	private IEstudianteService estudianteService;

	// Métodos: Capacidades
	@GetMapping(path = "/buscar")
	public Estudiante buscar() {
		return this.estudianteService.buscar(1);
	}

	@PostMapping(path = "/guardar")
	public void guardar(@RequestBody Estudiante estudiante) {
		this.estudianteService.guardar(estudiante);
	}
}
