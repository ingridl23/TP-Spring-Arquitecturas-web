package main.dto;

import main.entity.Estudiante;

public class EstudianteDTO {

    
    private int nroDocumento;
    private String nombre;
    private String apellido;
    private int edad;
    private String genero;
    private String ciudad;
    private int nroLibreta;

    public EstudianteDTO(int nroDocumento, String nombre, String apellido, int edad, String genero, String ciudad, int nroLibreta) {
        this.nroDocumento = nroDocumento;
        this.nombre = nombre;
        this.apellido = apellido;
        this.edad = edad;
        this.genero = genero;
        this.ciudad = ciudad;
        this.nroLibreta = nroLibreta;
    }

    public int getNroDocumento() {
        return nroDocumento;
    }

    public void setNroDocumento(int nroDocumento) {
        this.nroDocumento = nroDocumento;
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
    
    
    public Estudiante toEntity() {
    return new Estudiante(
        this.getNroDocumento(),
        this.getNombre(),
        this.getApellido(),
        this.getEdad(),
        this.getGenero(),
        this.getCiudad(),
        this.getNroLibreta()
    );
}

    
}
