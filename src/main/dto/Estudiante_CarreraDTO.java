package main.dto;

import main.entity.Carrera;
import main.entity.Estudiante;
import main.entity.Estudiante_Carrera;

public class Estudiante_CarreraDTO {

    private int id;
    private Estudiante estudiante;
    private Carrera carrera;
    private boolean seGraduo;
    private int antiguedad;

    public Estudiante_CarreraDTO(int id, Estudiante estudiante, Carrera carrera, boolean seGraduo, int antiguedad) {
        this.id = id;
        this.estudiante = estudiante;
        this.carrera = carrera;
        this.seGraduo = seGraduo;
        this.antiguedad = antiguedad;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
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

    public int getAntiguedad() {
        return antiguedad;
    }

    public void setAntiguedad(int antiguedad) {
        this.antiguedad = antiguedad;
    }

    public Estudiante_Carrera toEntity() {
    return new Estudiante_Carrera(
        this.getId(),
        this.getEstudiante(),
        this.getCarrera(),
        this.isSeGraduo(),
        this.getAntiguedad()
    );
}

    
    
    
}
