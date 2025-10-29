package main.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.ErrorResponseException;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import main.dto.CarreraResponse;
import main.entity.Carrera;
import main.repository.CarreraRepository;
import main.service.CarreraService;

@RestController
@RequestMapping("/carrera")


//acomode
public class CarreraController {

	   private final CarreraService carreraService;

	    @Autowired
	    public CarreraController(CarreraService carreraService) {
	        this.carreraService = carreraService;
	    }

	
	    @Value("${variable_env:valor_por_defecto}")
	private String variable_env;
	
	
	@GetMapping("/variable_env")
	public String obtener_variable_env() {
		
		return variable_env;
	}
	
	

	    // -------------------------------------------------------------------------
	    // 1. Obtener todas las carreras
	    // -------------------------------------------------------------------------
	    @GetMapping
	    public ResponseEntity<?> seleccionarTodos() {
	        try {
	            CarreraResponse respuesta = carreraService.obtenerTodas();
	            return ResponseEntity.ok(respuesta);
	        } catch (Exception e) {
	        	  return ResponseEntity
	        		        .status(HttpStatus.BAD_REQUEST)
	        		        .body("Error: " + e.getMessage());
	        }
	    }

	    // -------------------------------------------------------------------------
	    // 2. Obtener carreras con estudiantes ordenadas
	    // -------------------------------------------------------------------------
	    @GetMapping("/ordenadas")
	    public ResponseEntity<?> carrerasYEstudiantesInOrder() {
	        try {
	            CarreraResponse respuesta = carreraService.obtenerCarrerasConEstudiantesOrdenadas();
	            return ResponseEntity.ok(respuesta);
	        } catch (Exception e) {
	        	  return ResponseEntity
	        		        .status(HttpStatus.BAD_REQUEST)
	        		        .body("Error: " + e.getMessage());
	        }
	    }
	

	
	 @GetMapping("/{id}")
	    public ResponseEntity<?> buscarCarreraPorID(@PathVariable Integer id) {
	        try {
	            Carrera carrera = carreraService.buscarPorId(id);

	            if (carrera == null) {
	                return ResponseEntity.status(HttpStatus.NOT_FOUND)
	                        .body("No se encontró la carrera con ID: " + id);
	            }

	            return ResponseEntity.ok(carrera);
	        } catch (Exception e) {
	            return ResponseEntity.status(HttpStatus.BAD_REQUEST)
	                    .body("Error al buscar la carrera: " + e.getMessage());
	        }
	    }
	 
	 
	 @PostMapping
	    public ResponseEntity<?> guardarCarrera(@RequestBody Carrera carrera) {
	        try {
	            Carrera nueva = carreraService.guardar(carrera);
	            return ResponseEntity.status(HttpStatus.CREATED).body(nueva);
	        } catch (Exception e) {
	            return ResponseEntity.status(HttpStatus.BAD_REQUEST)
	                    .body("Error al guardar la carrera: " + e.getMessage());
	        }
	    }
	
	
	 @DeleteMapping("/{id}")
	    public ResponseEntity<?> eliminarCarrera(@PathVariable Integer id) {
	        try {
	            boolean eliminada = carreraService.eliminar(id);

	            if (!eliminada) {
	                return ResponseEntity.status(HttpStatus.NOT_FOUND)
	                        .body("No se encontró la carrera con ID: " + id);
	            }

	            return ResponseEntity.ok("Carrera eliminada correctamente.");
	        } catch (Exception e) {
	            return ResponseEntity.status(HttpStatus.BAD_REQUEST)
	                    .body("Error al eliminar la carrera: " + e.getMessage());
	        }
	    }
	
	
}
