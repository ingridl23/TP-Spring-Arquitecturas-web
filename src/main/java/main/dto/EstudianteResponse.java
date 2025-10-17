package main.java.main.dto;

import java.util.List;

import main.entity.Estudiante;

public class EstudianteResponse {

	private List<Estudiante> estudiantes;
	
	
	public EstudianteResponse(List<Estudiante> estudiantes) {
		this.estudiantes = estudiantes;
	}
	public List<Estudiante> getEstudiante() {
		return estudiantes;
	}
	public void setEstudiante(List<Estudiante> estudiantes) {
		this.estudiantes = estudiantes;
	}
}
