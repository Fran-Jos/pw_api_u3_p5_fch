package com.example.demo.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.demo.modelo.Estudiante;
import com.example.demo.repository.IEstudianteRepository;
import com.example.demo.service.to.EstudianteTO;

@Service
public class EstudianteServiceImpl implements IEstudianteService {

	@Autowired
	private IEstudianteRepository estudianteRepository;

	@Override
	public void guardar(Estudiante estudiante) {
		// TODO Auto-generated method stub
		this.estudianteRepository.insertar(estudiante);
	}

	@Override
	public void actualizar(Estudiante estudiante) {
		// TODO Auto-generated method stub
		this.estudianteRepository.actualizar(estudiante);
	}

	@Override
	public void actualizarParcial(String apellido, String nombre, Integer id) {
		// TODO Auto-generated method stub
		this.estudianteRepository.actualizarParcial(apellido, nombre, id);
	}

	@Override
	public Estudiante buscar(Integer id) {
		// TODO Auto-generated method stub
		return this.estudianteRepository.seleccionar(id);
	}

	@Override
	public void eliminar(Integer id) {
		// TODO Auto-generated method stub
		this.estudianteRepository.eliminar(id);
	}

	@Override
	public List<Estudiante> seleccionartodos(String genero) {
		// TODO Auto-generated method stub

		return this.estudianteRepository.seleccionartodos(genero);
	}

	@Override
	public List<EstudianteTO> seleccionartodosTO() {
		// TODO Auto-generated method stub
		List<Estudiante> lista = this.estudianteRepository.seleccionartodos("M");
		List<EstudianteTO> listaFinal = new ArrayList<>();

		for (Estudiante estudiante : lista) {
			listaFinal.add(this.convertir(estudiante));
		}
		
		return listaFinal;

	}

	private EstudianteTO convertir(Estudiante estudiante) {

		EstudianteTO estudianteTO = new EstudianteTO();
		estudianteTO.setId(estudiante.getId());
		estudianteTO.setNombre(estudiante.getNombre());
		estudianteTO.setApellido(estudiante.getApellido());
		estudianteTO.setGenero(estudiante.getGenero());
		estudianteTO.setFechaNacimiento(estudiante.getFechaNacimiento());
		return estudianteTO;
	}


}
