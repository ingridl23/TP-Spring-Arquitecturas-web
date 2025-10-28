package main.repository;

import main.dto.EstudianteDTO;
import main.entity.Estudiante;
import java.util.List;

public interface EstudianteRepository extends BaseRepository<Estudiante,Integer> {
List<Estudiante> estudiantesOrdenadosDESC();
Estudiante seleccionarPorLibreta(Integer id);
List<Estudiante>estudiantesPorGenero(String genero);
			


}
