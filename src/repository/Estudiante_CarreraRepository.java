package repository;

import entity.Estudiante_Carrera;

import java.util.List;
import dto.ReporteCarreraDTO;

import entity.Estudiante;

public interface Estudiante_CarreraRepository extends BaseRepository<Estudiante_Carrera,Integer> {
	List<Estudiante> seleccionarEstudiantesPorCarreraCiudad(Integer idCarrera, String ciudad);
                List<ReporteCarreraDTO> generarReporteCarreras();     

}
