package dto;

import java.util.List;

import entity.Estudiante_Carrera;

public class Estudiante_CarreraResponse {
	private List<Estudiante_Carrera> estudiantescarrera;
	public Estudiante_CarreraResponse(List<Estudiante_Carrera> estudiantesc) {
		this.estudiantescarrera = estudiantesc;
	}
	public List<Estudiante_Carrera> getEstudiantesCarrera() {
		return estudiantescarrera;
	}
	public void setEstudianteCarrera(List<Estudiante_Carrera> estudiantesc) {
		this.estudiantescarrera = estudiantesc;
	}
}
