package  main.controller;


import java.util.List;

import main.entity.Carrera;


public class CarreraResponse {
	private List<Carrera> carreras;
	
	
	public CarreraResponse(List<Carrera> carreras) {
		this.carreras = carreras;
	}
	public List<Carrera> getCarreras() {
		return carreras;
	}
	public void setCarrerass(List<Carrera> carreras) {
		this.carreras = carreras;
	}
}
