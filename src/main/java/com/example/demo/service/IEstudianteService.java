package com.example.demo.service;

import java.util.List;

import com.example.demo.modelo.Estudiante;
import com.example.demo.service.to.EstudianteTO;

public interface IEstudianteService {
	// CRUD
	// Create, Read, Uopdate, Delete
	public void guardar(Estudiante estudiante);

	public void actualizar(Estudiante estudiante);

	public void actualizarParcial(String apellido, String nombre, Integer id);

	public Estudiante buscar(Integer id);

	public void eliminar(Integer id);

	public List<EstudianteTO> seleccionartodosTO();


	public List<Estudiante> seleccionartodos(String genero);
}
