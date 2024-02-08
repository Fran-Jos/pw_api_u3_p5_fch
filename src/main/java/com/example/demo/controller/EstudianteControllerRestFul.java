package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
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
	// http://localhost:8080/API/v1.0/Matricula/estudiantes/{id}
	@GetMapping(path = "/{id}", produces = "application/xml")
	public ResponseEntity<Estudiante> consultar(@PathVariable Integer id) {
		// 241: GRUPO satisfactorias.
		// 241: Recurso Estudiante encontrado satisfactoriamente
		Estudiante estu = this.estudianteService.buscar(id);
		// 200 ok
		// --------

		// 401 autenticación
		// Contrato de la API (documento pdf, Swagger.io)
		// nos permite docuemntar el contrato de una API.
		return ResponseEntity.status(241).body(estu);
		// return ResponseEntity.status(HttpStatus.OK).body(estu);
	}

	@GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<Estudiante>> buscartodos(
			@RequestParam(required = false, defaultValue = "M") String genero) {

		List<Estudiante> lista = this.estudianteService.seleccionartodos(genero);

		HttpHeaders cabeceras = new HttpHeaders();
		cabeceras.add("mensaje_242", "lista consultada de manera satisfactoria");

		return new ResponseEntity<>(lista, cabeceras, 242);
	}

	@PostMapping(consumes = MediaType.APPLICATION_XML_VALUE)
	public void guardar(@RequestBody Estudiante estudiante) {
		this.estudianteService.guardar(estudiante);
	}

	@PutMapping(path = "/{id}", consumes = MediaType.APPLICATION_JSON_VALUE)
	public void actualizar(@RequestBody Estudiante estudiante, @PathVariable Integer id) {
		estudiante.setId(id);
		this.estudianteService.actualizar(estudiante);
	}

	@PatchMapping(path = "/{id}", consumes = MediaType.APPLICATION_JSON_VALUE)
	public void actualizarParcial(@RequestBody Estudiante estudiante, @PathVariable Integer id) {
		this.estudianteService.actualizarParcial(estudiante.getApellido(), estudiante.getNombre(), estudiante.getId());
	}

	@DeleteMapping(path = "/{id}")
	public void borrar(@PathVariable Integer id) {
		this.estudianteService.eliminar(id);
	}

	// http://localhost:8080/API/v1.0/Matricula/estudiantes/buscartodos?genero=M
}
