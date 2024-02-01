package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.modelo.Profesor;
import com.example.demo.repository.IProfesorRepository;

@Service
public class ProfesorServiceImpl implements IProfesorService {

    @Autowired
    private IProfesorRepository iProfesorRepository;

    @Override
    public void guardar(Profesor profesor) {
        // TODO Auto-generated method stub
        this.iProfesorRepository.insertar(profesor);
    }

    @Override
    public void actualizar(Profesor profesor) {
        // TODO Auto-generated method stub
        this.iProfesorRepository.actualizar(profesor);
    }

    @Override
    public void actualizarParcial(String apellido, String nombre, String materia, Integer id) {
        // TODO Auto-generated method stub
        this.iProfesorRepository.actualizarParcial(apellido, nombre, materia, id);
    }

    @Override
    public Profesor buscar(Integer id) {
        // TODO Auto-generated method stub
        return this.iProfesorRepository.seleccionar(id);
    }

    @Override
    public void eliminar(Integer id) {
        // TODO Auto-generated method stub
        this.iProfesorRepository.eliminar(id);
    }

    @Override
    public List<Profesor> seleccionartodos(String materia) {
        // TODO Auto-generated method stub
       return this.iProfesorRepository.seleccionarTodos(materia);
    }

}
