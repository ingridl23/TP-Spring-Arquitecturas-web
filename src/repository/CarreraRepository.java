package repository;

import entity.Carrera;

import java.util.List;

public interface CarreraRepository extends BaseRepository<Carrera,Integer> {
List<Carrera> carrerasConEstudiantesOrdenadas();
}
