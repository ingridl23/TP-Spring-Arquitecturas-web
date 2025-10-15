
package dto;


public class ReporteCarreraDTO {
    

    private String nombreCarrera;
    private int anio;
    private long inscriptos;
    private long egresados;

    public ReporteCarreraDTO(String nombreCarrera, int anio, long inscriptos, long egresados) {
        this.nombreCarrera = nombreCarrera;
        this.anio = anio;
        this.inscriptos = inscriptos;
        this.egresados = egresados;
    }

    public String getNombreCarrera() {
        return nombreCarrera;
    }

    public int getAnio() {
        return anio;
    }

    public long getInscriptos() {
        return inscriptos;
    }

    public long getEgresados() {
        return egresados;
    }

    @Override
    public String toString() {
        return String.format("Carrera: %-25s | Año: %d | Inscriptos: %d | Egresados: %d",
                nombreCarrera, anio, inscriptos, egresados);
    }
}
