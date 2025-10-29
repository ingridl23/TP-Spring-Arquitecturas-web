package main.repository;

import main.dto.Estudiante_CarreraDTO;
import main.entity.Estudiante;
import main.entity.Estudiante_Carrera;

import java.util.List;

import org.springframework.stereotype.Repository;
@Repository
public interface Estudiante_CarreraRepository extends BaseRepository<Estudiante_Carrera,Integer> {
	List<Estudiante> seleccionarEstudiantesPorCarreraCiudad(Integer idCarrera, String ciudad);
}
