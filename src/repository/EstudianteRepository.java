package repository;

import dto.EstudianteDTO;
import entity.Estudiante;
import java.util.List;

public interface EstudianteRepository extends BaseRepository<Estudiante,Integer> {
List<Estudiante> estudiantesOrdenadosDESC();
Estudiante seleccionarPorLibreta(Integer id);
List<Estudiante>estudiantesPorGenero(String genero);
			


}
