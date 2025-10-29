package main.repository;

import main.dto.CarreraDTO;
import main.entity.Carrera;

import java.util.List;

import org.springframework.stereotype.Repository;
@Repository
public interface CarreraRepository extends BaseRepository<Carrera,Integer> {
List<Carrera> carrerasConEstudiantesOrdenadas();
}
