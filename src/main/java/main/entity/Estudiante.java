package main.entity;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Column;
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
	@JsonIgnore
	private List<Estudiante_Carrera> carrerasInscriptas = new ArrayList<>();
	
	public Estudiante(int nroDocumento, String nombre, String apellido, Integer edad, String genero, String ciudad, Integer nroLibreta) {
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
	public Integer getEdad() {
	    return edad;
	}
	public void setEdad(Integer edad) {
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
	public Integer getNroLibreta() {
		return nroLibreta;
	}
	public void setNroLibreta(Integer nroLibreta) {
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
