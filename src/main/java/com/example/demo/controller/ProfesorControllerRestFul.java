package com.example.demo.controller;

import java.util.List;

import javax.print.attribute.standard.Media;


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

import com.example.demo.modelo.Profesor;
import com.example.demo.service.IProfesorService;

@RestController // servicio
@RequestMapping(path = "/profesores")
public class ProfesorControllerRestFul {
    
    @Autowired
    private IProfesorService iProfesorService;

    @GetMapping(path = "/{id}", produces = "application/xml")
    public Profesor colsultar(@PathVariable Integer id) {
        return this.iProfesorService.buscar(id);
    }

    @DeleteMapping(path = "/{id}")
    public void eliminar(@PathVariable Integer id) {
        this.iProfesorService.eliminar(id);
    }

    @PutMapping(path = "/{id}", consumes = MediaType.APPLICATION_JSON_VALUE)
    public void actualizar(@RequestBody Profesor profesor, @PathVariable Integer id){
        profesor.setId(id);
        this.iProfesorService.actualizar(profesor);
    }

    @PatchMapping(path = "/{id}", consumes = MediaType.APPLICATION_JSON_VALUE)
    public void actualizarParcial(@RequestBody Profesor profesor, @PathVariable Integer id  ){
        this.iProfesorService.actualizarParcial(profesor.getApellido(), profesor.getNombre(), profesor.getMateria(), profesor.getId());
    }

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public  ResponseEntity< List<Profesor>> buscarTodos(@RequestParam(required = false , defaultValue = "mate") String materia){
        List<Profesor> lista = this.iProfesorService.seleccionartodos(materia);
        HttpHeaders headers = new HttpHeaders();
        headers.add("mensaje_243", "Lista de profesores satisfactoria");
        return ResponseEntity.status(243).headers(headers).body(lista);
    }

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    public void guardar(@RequestBody Profesor profesor){
        this.iProfesorService.guardar(profesor);
    }

}
