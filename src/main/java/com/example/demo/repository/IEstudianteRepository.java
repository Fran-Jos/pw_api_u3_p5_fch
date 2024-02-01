package com.example.demo.repository;

import java.util.List;

import com.example.demo.modelo.Estudiante;

public interface IEstudianteRepository {

	// CRUD
	// Create, Read, Uopdate, Delete
	public void insertar(Estudiante estudiante);

	public void actualizar(Estudiante estudiante);

	public void actualizarParcial(String apellido, String nombre, Integer id);

	public Estudiante seleccionar(Integer id);

	public List<Estudiante> seleccionartodos(String genero);

	public void eliminar(Integer id);
}

