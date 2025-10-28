package main.repository;

import main.entity.Carrera;
import main.dto.CarreraDTO;
import java.util.List;

public interface CarreraRepository extends BaseRepository<Carrera,Integer> {
List<Carrera> carrerasConEstudiantesOrdenadas();
}
