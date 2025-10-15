package entity;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name ="carrera")
public class Carrera {
 @Id
@GeneratedValue(strategy = GenerationType.IDENTITY) // MySQL usa IDENTITY para autoincrement
@Column(name = "idCarrera")
private Integer idCarrera;


	@Column(name="nombre")
	private String nombre;
	
	@OneToMany(mappedBy="carrera")
	private List<Estudiante_Carrera> estudiantesInscriptos;

	public Carrera(String nombre, List<Estudiante_Carrera> estudiantesInscriptos) {
		super();
		
		this.nombre = nombre;
		this.estudiantesInscriptos = estudiantesInscriptos;
	}

    public Carrera() {
    }

    public Integer getIdCarrera() {
        return idCarrera;
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
