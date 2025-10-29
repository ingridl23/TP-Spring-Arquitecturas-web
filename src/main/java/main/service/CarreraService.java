package main.service;
import org.springframework.web.server.ResponseStatusException;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import main.dto.CarreraResponse;
import main.entity.Carrera;
import main.repository.CarreraRepository;

import java.util.List;

@Service
public class CarreraService {


    @Autowired
    private CarreraRepository carreraRepository;

    // -------------------------------------------------------------------------
    //  Obtener todas las carreras
    // -------------------------------------------------------------------------
    public CarreraResponse obtenerTodas() {
        try {
            List<Carrera> carreras = carreraRepository.seleccionarTodos();

            if (carreras == null || carreras.isEmpty()) {
                throw new RuntimeException("No hay carreras registradas.");
            }
            return new CarreraResponse(carreras);

        } catch (Exception e) {
        	  throw new RuntimeException("Error al obtener carreras: " + e.getMessage());
        }
    }

    // -------------------------------------------------------------------------
    //  Obtener carreras con estudiantes ordenadas
    // -------------------------------------------------------------------------
    public CarreraResponse obtenerCarrerasConEstudiantesOrdenadas() {
        try {
            List<Carrera> carreras = carreraRepository.carrerasConEstudiantesOrdenadas();

            if (carreras == null || carreras.isEmpty()) {
            	 throw new RuntimeException("No hay carreras ordenadas con estudiantes.");
            }

            return new CarreraResponse(carreras);

        } catch (Exception e) {
        	  throw new RuntimeException("Error al obtener carreras ordenadas: " + e.getMessage());
        }
    }

    // -------------------------------------------------------------------------
    // 3️⃣ Buscar carrera por ID
    // -------------------------------------------------------------------------
    public Carrera buscarPorId(Integer idCarrera) {
        try {
            Carrera carrera = carreraRepository.seleccionarPorId(idCarrera);

            if (carrera == null) {
            	 throw new RuntimeException("No hay carrera registrada con el id .");
            }

            return carrera;

        } catch (Exception e) {
        	  throw new RuntimeException("Error al obtener la  carrera: " + e.getMessage());
        }
    }

    // -------------------------------------------------------------------------
    //  Guardar nueva carrera
    // -------------------------------------------------------------------------
    public Carrera guardar(Carrera carrera) {
        try {
            if (carrera.getNombre() == null || carrera.getNombre().trim().isEmpty()) {
            	throw new RuntimeException("El nombre d ela carrera no puede estar vacio .");
            }

            return carreraRepository.guardar(carrera);

        } catch (Exception e) {
        	 throw new RuntimeException("Error al guardar la  carrera: " + e.getMessage());
        }
    }

   

    // -------------------------------------------------------------------------
    //  Eliminar carrera por ID
    // -------------------------------------------------------------------------
    public boolean eliminar(Integer idCarrera) {
        try {
            Carrera existente = carreraRepository.seleccionarPorId(idCarrera);

            if (existente == null) {
            	throw new RuntimeException("La carrera seleccionada no esta disponible para eliminar .");
            }

            carreraRepository.eliminar(idCarrera);
            return true;

        } catch (Exception e) {
        	 throw new RuntimeException("Error al eliminar la  carrera: " + e.getMessage());
        }
    }
}
