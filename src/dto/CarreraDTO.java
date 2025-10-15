package dto;

import entity.Carrera;
import entity.Estudiante_Carrera;
import java.util.List;
import entity.Carrera;
import entity.Estudiante_Carrera;

public class CarreraDTO {

private String nombre;
private List<Estudiante_Carrera> estudiantesInscriptos;
    public CarreraDTO( String nombre) {
 
        this.nombre = nombre;
        
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
   
        this.getNombre(),
        this.getEstudiantesInscriptos()
    );
                
}

}
