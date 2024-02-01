package com.example.demo.repository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.example.demo.modelo.Profesor;

import jakarta.persistence.EntityManager;
import jakarta.persistence.Query;
import jakarta.transaction.Transactional;

@Repository
@Transactional
public class ProfesorRepositoryImpl implements IProfesorRepository {

    @Autowired
    private EntityManager entityManager;

    @Override
    public void insertar(Profesor profesor) {
        // TODO Auto-generated method stub
        this.entityManager.persist(profesor);
    }

    @Override
    public Profesor seleccionar(Integer id) {
        // TODO Auto-generated method stub
   return this.entityManager.find(Profesor.class, id);
    }

    @Override
    public void actualizar(Profesor profesor) {
        // TODO Auto-generated method stub
        this.entityManager.merge(profesor);
    }

    @Override
    public void actualizarParcial(String nombre, String apellido, String materia, Integer id) {
        // TODO Auto-generated method stub
        Query query = this.entityManager
		.createQuery("UPDATE Profesor p SET p.nombre = :valor1, p.apellido = :valor2, p.materia = :valor3 WHERE p.id = :valor4");
		query.setParameter("valor1", apellido);
		query.setParameter("valor2", nombre);
		query.setParameter("valor3", materia);
		query.setParameter("valor4", id);
		query.executeUpdate();

    }

    @Override
    public List<Profesor> seleccionarTodos(String materia) {
        // TODO Auto-generated method stub
        Query query = this.entityManager.createQuery("SELECT p FROM Profesor p WHERE p.materia=:variable");
		query.setParameter("variable", materia);
		return query.getResultList();
    }

    @Override
    public void eliminar(Integer id) {
        // TODO Auto-generated method stub
       Profesor profesor = this.seleccionar(id);
       
        this.entityManager.remove(profesor);
    }



}
