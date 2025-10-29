package main.service;

import java.util.LinkedList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import jakarta.transaction.Transactional;
import main.dto.EstudianteResponse;
import main.dto.Estudiante_CarreraResponse;
import main.dto.ReporteCarreraDTO;
import main.entity.Estudiante;
import main.entity.Estudiante_Carrera;
import main.repository.Estudiante_CarreraRepository;

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

	// chequear
	public Estudiante_CarreraResponse obtenerTodos() {
		List<Estudiante_Carrera> estudiantescarrera = estudianteCarreraRepository.seleccionarTodos();
		if (estudiantescarrera.isEmpty()) {
			return new Estudiante_CarreraResponse(new LinkedList<Estudiante_Carrera>());
		}
		return new Estudiante_CarreraResponse(estudiantescarrera);

	}

	public EstudianteResponse obtenerEstudiantesPorCarreraYCiudad(Integer idCarrera, String ciudad) {
		List<Estudiante> estudiantes = estudianteCarreraRepository
				.seleccionarEstudiantesPorCarreraCiudad(idCarrera, ciudad);

		if (estudiantes.isEmpty()) {
			return new EstudianteResponse(new LinkedList<>());
		}

		return new EstudianteResponse(estudiantes);
	}

	public List<ReporteCarreraDTO> obtenerReporteCarreras() {
		return estudianteCarreraRepository.generarReporteCarreras();
	}

}
