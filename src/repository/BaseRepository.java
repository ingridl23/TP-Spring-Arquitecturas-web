package repository;

import java.util.List;

public interface BaseRepository<T,ID> {
T seleccionarPorId(ID id);
List<T> seleccionarTodos();
T guardar(T entity);
void eliminar(ID id);

}
