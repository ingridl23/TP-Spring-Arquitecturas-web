package main.repository;

import main.dto.Estudiante_CarreraDTO;
import main.entity.Estudiante_Carrera;

import java.util.List;

import main.entity.Estudiante;

public interface Estudiante_CarreraRepository extends BaseRepository<Estudiante_Carrera,Integer> {
	List<Estudiante> seleccionarEstudiantesPorCarreraCiudad(Integer idCarrera, String ciudad);
}
