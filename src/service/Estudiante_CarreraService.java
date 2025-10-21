package service;

import java.util.LinkedList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import dto.Estudiante_CarreraResponse;
import entity.Estudiante;
import entity.Estudiante_Carrera;
import jakarta.transaction.Transactional;
import repository.Estudiante_CarreraRepository;
import dto.EstudianteResponse;

@Service
public class Estudiante_CarreraService {
@Autowired
	private Estudiante_CarreraRepository estudianteCarreraRepository;
	@Transactional
	public Estudiante_Carrera guardar(Estudiante_Carrera nuevo) {
		return estudianteCarreraRepository.guardar(nuevo);
	}
	public void eliminar(int id) {
		estudianteCarreraRepository.eliminar(id);
	}
	public Estudiante_Carrera seleccionarPorId(int id) {
		return estudianteCarreraRepository.seleccionarPorId(id);
	}
	
	//chequear
	public Estudiante_CarreraResponse obtenerTodos() {
	        List<Estudiante_Carrera> estudiantescarrera = estudianteCarreraRepository.seleccionarTodos();
	        if (estudiantescarrera.isEmpty()) {
	            return new Estudiante_CarreraResponse(new LinkedList<Estudiante_Carrera>());
	        }
	        return new Estudiante_CarreraResponse(estudiantescarrera);
	
	   
	}
	
	public EstudianteResponse obtenerEstudiantesPorCarreraYCiudad(Integer idCarrera, String ciudad){ 
        List<Estudiante> estudiantes = estudianteCarreraRepository
            .seleccionarEstudiantesPorCarreraCiudad(idCarrera, ciudad); 

        if (estudiantes.isEmpty()) { 
            return new EstudianteResponse(new LinkedList<>()); 
        }

        return new EstudianteResponse(estudiantes);  
    }
	
	//TODO HACERLO, MERGE DE INGRID PARA TENER ACCESO A SU CARRERARESPONSE
	public CarreraResponse generarReporteCarreras() {
		List<>
	}

}
