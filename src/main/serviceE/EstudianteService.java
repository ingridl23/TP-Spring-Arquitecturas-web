package main.java.main.service;
import java.util.LinkedList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import jakarta.transaction.Transactional;
import main.dto.EstudianteResponse;
import main.entity.Estudiante;
import main.repository.EstudianteRepository; 
@Service
public class EstudianteService {
	@Autowired
	private EstudianteRepository estudianteRepository;
	@Transactional
	public Estudiante guardar(Estudiante estudiante) {
		  return estudianteRepository.guardar(estudiante);
		  
	}
	
	public void eliminar(int idEstudiante) {
		estudianteRepository.eliminar(idEstudiante);
	}
	
	public Estudiante seleccionarPorId(int idEstudiante) {
		return estudianteRepository.seleccionarPorId(idEstudiante);
	}
	
	public EstudianteResponse seleccionarTodos(){
		 List<Estudiante> lista = estudianteRepository.seleccionarTodos();
		 System.out.println("Estudiantes encontrados: " + lista.size());
		    if (lista.isEmpty()) {
		        return new EstudianteResponse(new LinkedList<>());
		    }
		    return new EstudianteResponse(lista);	}

	public EstudianteResponse estudiantesOrdenadosDESC(){
		return new EstudianteResponse(estudianteRepository.estudiantesOrdenadosDESC());
	}
	
	public Estudiante seleccionarPorLibreta(int idLibreta) {
		return estudianteRepository.seleccionarPorLibreta(idLibreta);
	}
	
	public EstudianteResponse estudiantesPorGenero(String genero) {
		return new EstudianteResponse(estudianteRepository.estudiantesPorGenero(genero));
	}

}
