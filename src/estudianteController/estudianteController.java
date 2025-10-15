package estudianteController;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import estudianteService.estudianteService;

@RestController
@RequestMapping("/estudiantes")
public class estudianteController {

	@Autowired
	private EstudianteService  estudianteService;
	
	@PostMapping
	public Estudiante crearEstudiante(@RequestBody Estudiante estudiante) {
		return estudianteService.guardar(estudiante);
	}
	
	@DeleteMapping("/{id}")
	public void eliminarEstudiante(@PathVariable int idEstudiante) {
		estudianteService.eliminar(idEstudiante);
	}
	
	@GetMapping("/{id}")
	public Estudiante obtenerEstudianteID(@PathVariable int idEstudiante) {
		return estudianteService.seleccionarPorId(idEstudiante);
	}
	
	@GetMapping()
	public ResponseEntity<Object> obtenerEstudiantes(){
		Estudiante est = new Estudiante(estudianteService.seleccionarTodos());
		return ResponseEntity.ok(est);
	}

	
	@GetMapping("/ordenados")
	public List<Estudiante> obtenerEstudiantesOrdenadosDESC(){
		return estudianteService.estudiantesOrdenadosDESC();
	}
	
	@GetMapping("/{idLibreta}")
	public Estudiante seleccionarPorLibreta(@PathVariable int idLibreta) {
		return estudianteService.seleccionarPorLibreta(idLibreta);
	}
	
	@GetMapping("/{genero}")
	public List<Estudiante> estudiantesPorGenero(@PathVariable String genero) {
		return estudianteService.estudiantesPorGenero(genero);
	}
}
