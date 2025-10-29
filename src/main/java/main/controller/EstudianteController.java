package main.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import main.dto.EstudianteResponse;
import main.entity.Estudiante;
import main.service.EstudianteService;

import org.springframework.web.bind.annotation.RequestBody;

@RestController
@RequestMapping("/estudiantes")
public class EstudianteController {

	@Autowired
	private EstudianteService  estudianteService;
	
	 @PostMapping
	    public ResponseEntity<Estudiante> crear(@RequestBody Estudiante estudiante) {
	        Estudiante guardado = estudianteService.guardar(estudiante);
	        return ResponseEntity.status(201).body(guardado);
	    }
	
	@DeleteMapping("/{id}")
	public void eliminar(@PathVariable("id") int idEstudiante) {
		estudianteService.eliminar(idEstudiante);
	}
	
	 @GetMapping("/{id}")
	    public ResponseEntity<Estudiante> obtenerPorId(@PathVariable("id") int id) {
	        Estudiante estudiante = estudianteService.seleccionarPorId(id);
	        return ResponseEntity.ok(estudiante);
	    }
	
	 @GetMapping
	 public EstudianteResponse obtenerTodos() {
		    return estudianteService.seleccionarTodos();
		}
	
	 @GetMapping("/ordenados")
	    public ResponseEntity<EstudianteResponse> obtenerOrdenadosDesc() {
	        return ResponseEntity.ok(estudianteService.estudiantesOrdenadosDESC());
	    }
	
	  @GetMapping("/libreta/{idLibreta}")
	    public ResponseEntity<Estudiante> seleccionarPorLibreta(@PathVariable("idLibreta") int idLibreta) {
	        Estudiante estudiante = estudianteService.seleccionarPorLibreta(idLibreta);
	        return ResponseEntity.ok(estudiante);
	    }
	  @GetMapping("/genero/{genero}")
	    public ResponseEntity<EstudianteResponse> estudiantesPorGenero(@PathVariable String genero) {
	        return ResponseEntity.ok(estudianteService.estudiantesPorGenero(genero));
	    }
}
