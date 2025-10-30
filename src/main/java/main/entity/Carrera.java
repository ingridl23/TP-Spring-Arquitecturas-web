package main.entity;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name ="carrera")
public class Carrera {
	@Id
	@Column(name="idCarrera")
	private int idCarrera;
	@Column(name="nombre")
	private String nombre;
	
	@OneToMany(mappedBy="carrera")
	@JsonIgnore
	private List<Estudiante_Carrera> estudiantesInscriptos;

	public Carrera(int idCarrera, String nombre, List<Estudiante_Carrera> estudiantesInscriptos) {
		super();
		this.idCarrera = idCarrera;
		this.nombre = nombre;
		this.estudiantesInscriptos = estudiantesInscriptos;
	}

    public Carrera() {
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
	public void matricularEstudiante(Estudiante_Carrera inscripto) {
		estudiantesInscriptos.add(inscripto);
	}

	public void setEstudiantesInscriptos(List<Estudiante_Carrera> estudiantesInscriptos) {
		this.estudiantesInscriptos = estudiantesInscriptos;
	}
}
