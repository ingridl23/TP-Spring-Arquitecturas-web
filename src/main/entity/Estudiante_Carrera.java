package main.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="estudiante_Carrera")
public class Estudiante_Carrera {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;
	@ManyToOne
	@JoinColumn(name="nroDocumento")
	private Estudiante estudiante;
	@ManyToOne
	@JoinColumn(name="idCarrera")
	private Carrera carrera;
	@Column(name="seGraduo")
	private boolean seGraduo;
	@Column(name="antiguedad")
	private Integer antiguedad;
	public Estudiante_Carrera(int id, Estudiante estudiante, Carrera carrera, boolean seGraduo, int antiguedad){
		super();
		this.id = id;
		this.estudiante = estudiante;
		this.carrera = carrera;
                this.antiguedad=antiguedad;
                this.seGraduo= seGraduo;
	}

    public Estudiante_Carrera() {
    }

   

	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Estudiante getEstudiante() {
		return estudiante;
	}
	public void setEstudiante(Estudiante estudiante) {
		this.estudiante = estudiante;
	}
	public Carrera getCarrera() {
		return carrera;
	}
	public void setCarrera(Carrera carrera) {
		this.carrera = carrera;
	}
	public boolean isSeGraduo() {
		return seGraduo;
	}
	public void setSeGraduo(boolean seGraduo) {
		this.seGraduo = seGraduo;
	}
	public Integer getAntiguedad() {
		return antiguedad;
	}
	public void setAntiguedad(Integer antiguedad) {
		this.antiguedad = antiguedad;
	}
	
	
	
}
