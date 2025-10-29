package main.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import main.dto.EstudianteResponse;
import main.dto.Estudiante_CarreraResponse;
import main.entity.Estudiante_Carrera;
import main.service.Estudiante_CarreraService;

@RestController
@RequestMapping("/estudiante_carrera")
public class Estudiante_CarreraController {
	@Autowired
	private Estudiante_CarreraService estudiantecarreraService;
	
	@GetMapping
	public Estudiante_CarreraResponse obtenerTodos() {
		return estudiantecarreraService.obtenerTodos();
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Estudiante_Carrera> obtenerPorId(@PathVariable("id") int id) {
		Estudiante_Carrera seleccionado = estudiantecarreraService.seleccionarPorId(id);
		return ResponseEntity.ok(seleccionado);
	}
	
	//TODO Ver como pasar los id y el string de manera mas linda
	// TODO HACER MERGE CON LO DE JUAN PARA TENER EL ESTUDIANTERESPONSE
	@GetMapping("/filtrar")
    public EstudianteResponse obtenerEstudiantesPorCarreraYCiudad(
            @RequestParam Integer idCarrera,
            @RequestParam String ciudad) {

        return estudiantecarreraService.obtenerEstudiantesPorCarreraYCiudad(idCarrera, ciudad);
    }
	

	@PostMapping
	public ResponseEntity<Estudiante_Carrera> crear(@RequestBody Estudiante_Carrera estudiantecarrera) {
		    Estudiante_Carrera guardado = estudiantecarreraService.guardar(estudiantecarrera);
		    return ResponseEntity.status(201).body(guardado);
	}
	
	@DeleteMapping("/{id}")
	public void eliminar(@PathVariable("id") int id) {
		estudiantecarreraService.eliminar(id);
	}
	
}
