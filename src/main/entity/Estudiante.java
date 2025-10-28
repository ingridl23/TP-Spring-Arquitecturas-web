package main.entity;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import java.util.LinkedList;
import java.util.List;
import javax.persistence.Column;

@Entity
@Table(name="estudiante")
public class Estudiante {
	@Id
	@Column(name="nroDocumento")
	private Integer nroDocumento;
	@Column(name="nombre")
	private String nombre;
	@Column(name="apellido")
	private String apellido;
	@Column(name="edad")
	private Integer edad;
	@Column(name="genero")
	private String genero;
	@Column(name="ciudad")
	private String ciudad;
	@Column(name="nroLibreta")
	private Integer nroLibreta;
	@OneToMany(mappedBy="estudiante")
	private List<Estudiante_Carrera> carrerasInscriptas;
	
	public Estudiante(int nroDocumento, String nombre, String apellido, int edad, String genero, String ciudad, int nroLibreta) {
		super();
		this.nroDocumento = nroDocumento;
		this.nombre = nombre;
		this.apellido = apellido;
		this.edad = edad;
		this.genero = genero;
		this.ciudad = ciudad;
		this.nroLibreta = nroLibreta;
	}
        
 
        
        

    public Estudiante() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getApellido() {
		return apellido;
	}
	public void setApellido(String apellido) {
		this.apellido = apellido;
	}
	public int getEdad() {
		return edad;
	}
	public void setEdad(int edad) {
		this.edad = edad;
	}
	public String getGenero() {
		return genero;
	}
	public void setGenero(String genero) {
		this.genero = genero;
	}
	public String getCiudad() {
		return ciudad;
	}
	public void setCiudad(String ciudad) {
		this.ciudad = ciudad;
	}
	public int getNroLibreta() {
		return nroLibreta;
	}
	public void setNroLibreta(int nroLibreta) {
		this.nroLibreta = nroLibreta;
	}
	public List<Estudiante_Carrera> getCarrerasInscriptas() {
		return new LinkedList<>(carrerasInscriptas);
	}
	public void setCarrerasInscriptas(List<Estudiante_Carrera> carrerasInscriptas) {
		this.carrerasInscriptas = carrerasInscriptas;
	}
	public int getNroDocumento() {
		return nroDocumento;
	}
}
