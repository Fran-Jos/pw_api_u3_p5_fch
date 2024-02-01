package com.example.demo.repository;

import java.util.List;

import com.example.demo.modelo.Profesor;

public interface IProfesorRepository {
    
// crud

public void insertar(Profesor profesor);

public Profesor seleccionar(Integer id);

public void actualizar(Profesor profesor);

public void actualizarParcial(String nombre , String apellido, String materia , Integer id );

public List<Profesor> seleccionarTodos(String materia);

public void eliminar(Integer id);


}
