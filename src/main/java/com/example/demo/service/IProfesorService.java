package com.example.demo.service;

import java.util.List;

import com.example.demo.modelo.Profesor;


public interface IProfesorService {
    
    	public void guardar(Profesor profesor);

	public void actualizar(Profesor profesor );

	public void actualizarParcial(String apellido, String nombre,String materia, Integer id);

	public Profesor buscar(Integer id);

	public void eliminar(Integer id);

	public List<Profesor> seleccionartodos(String materia);

}
