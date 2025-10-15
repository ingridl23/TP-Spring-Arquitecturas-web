package estudianteService;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import repository.estudianteRepository;

@Service
public class estudianteService implements com.micro{
	@Autowired
	private EstudianteRepository estudianteRepository;

	public Estudiante crearEstudiante(Estudiante estudiante) {
		return estudianteRepository.guardar(estudiante);
	}

	public void eliminarEstudiante(int idEstudiante) {
		estudianteRepository.eliminar(idEstudiante);
	}
	
	public Estudiante obtenerEstudianteID(int idEstudiante) {
		return estudianteRepository.seleccionarPorId(idEstudiante);
	}
	
	public List<Estudiante> obtenerEstudiantes(){
		return estudianteRepository.seleccionarTodos();
	}

	public List<Estudiante> obtenerEstudiantesOrdenadosDESC(){
		return estudianteRepository.estudiantesOrdenadosDESC();
	}
	
	public Estudiante seleccionarPorLibreta(int idLibreta) {
		return estudianteRepository.seleccionarPorLibreta(idLibreta);
	}
	
	public List<Estudiante> estudiantesPorGenero(String genero) {
		return estudianteRepository.estudiantesPorGenero(genero);
	}

}
