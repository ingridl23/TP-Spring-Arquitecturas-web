package main.dto;

import main.entity.Carrera;
import main.entity.Estudiante_Carrera;
import java.util.List;
import main.entity.Carrera;
import main.entity.Estudiante_Carrera;

public class CarreraDTO {
private int idCarrera;
private String nombre;
private List<Estudiante_Carrera> estudiantesInscriptos;
    public CarreraDTO(int idCarrera, String nombre) {
        this.idCarrera = idCarrera;
        this.nombre = nombre;
        
    }

    public int getIdCarrera() {
        return idCarrera;
    }

    public void setIdCarrera(int idCarrera) {
        this.idCarrera = idCarrera;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public List<Estudiante_Carrera> getEstudiantesInscriptos() {
        return estudiantesInscriptos;
    }

    public void setEstudiantesInscriptos(List<Estudiante_Carrera> estudiantesInscriptos) {
        this.estudiantesInscriptos = estudiantesInscriptos;
    }


   public void matricularEstudiante(Estudiante_Carrera inscripto) {
		estudiantesInscriptos.add(inscripto);
	} 
    
    public Carrera toEntity() {
    return new Carrera(
        this.getIdCarrera(),
        this.getNombre(),
        this.getEstudiantesInscriptos()
    );
                
}

}
