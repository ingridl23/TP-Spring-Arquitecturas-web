package main;

import java.util.Arrays;
import java.util.List;

import dto.CarreraDTO;
import dto.EstudianteDTO;
import dto.Estudiante_CarreraDTO;
import dto.ReporteCarreraDTO;
import entity.Carrera;
import entity.Estudiante;
import entity.Estudiante_Carrera;
import repository.CarreraRepositoryImp;
import repository.EstudianteRepositoryImp;
import repository.Estudiante_CarreraRepositoryImp;
import util.JpaUtil;

public class MainApp {

    public static void main(String[] args) {

        // 1️⃣ Inicializar la unidad de persistencia
        JpaUtil.init("MYSQL");
        System.out.println("✅ Conexión inicializada correctamente.");

        try {
            CarreraRepositoryImp carreraRepo = new CarreraRepositoryImp();
            EstudianteRepositoryImp estudianteRepo = new EstudianteRepositoryImp();
            Estudiante_CarreraRepositoryImp ecRepo = new Estudiante_CarreraRepositoryImp();

            // 2️⃣ Crear carreras
            CarreraDTO c1 = new CarreraDTO("Tecnicatura en Desarrollo de Aplicaciones");
            CarreraDTO c2 = new CarreraDTO("Tecnicatura en Redes Eléctricas");

            Carrera carrera1 = carreraRepo.guardar(c1.toEntity());
            Carrera carrera2 = carreraRepo.guardar(c2.toEntity());

            // 3️⃣ Crear lista de estudiantes variados
            List<EstudianteDTO> estudiantesDTO = Arrays.asList(
                    new EstudianteDTO(1001, "María", "Gonzales", 20, "F", "Tres Arroyos", 2001),
                    new EstudianteDTO(1002, "Pablo", "Torres", 25, "M", "Tandil", 2002),
                    new EstudianteDTO(1003, "Lucía", "Pérez", 22, "F", "Bahía Blanca", 2003),
                    new EstudianteDTO(1004, "Juan", "López", 27, "M", "Tres Arroyos", 2004),
                    new EstudianteDTO(1005, "Carla", "Ramírez", 19, "F", "Necochea", 2005),
                    new EstudianteDTO(1006, "Santiago", "Fernández", 30, "M", "Tandil", 2006)
            );

            // 4️⃣ Guardar estudiantes
            for (EstudianteDTO dto : estudiantesDTO) {
                estudianteRepo.guardar(dto.toEntity());
            }

            System.out.println("✅ Carreras y estudiantes guardados correctamente.");

            // 5️⃣ Relacionar estudiantes con carreras
            // (3 en la primera carrera, 3 en la segunda)
          int anioActual = java.time.Year.now().getValue();

for (int i = 0; i < estudiantesDTO.size(); i++) {
    Estudiante estudiante = estudianteRepo.seleccionarPorId(estudiantesDTO.get(i).getNroDocumento());
    Carrera carrera = (i < 3) ? carrera1 : carrera2;

    Estudiante_Carrera ec = new Estudiante_Carrera();
    ec.setEstudiante(estudiante);
    ec.setCarrera(carrera);
    ec.setSeGraduo(false);
    ec.setAntiguedad((int) (Math.random() * 5 + 1));
    ec.setAnioInscripcion(anioActual - (int) (Math.random() * 5)); // años variados

    ecRepo.guardar(ec);
}

            System.out.println("✅ Relaciones estudiante-carrera creadas.");

            // 6️⃣ Generar reporte de carreras
            List<ReporteCarreraDTO> reporte = ecRepo.generarReporteCarreras();
            System.out.println("\n📊 === REPORTE DE CARRERAS ===");
            if (reporte.isEmpty()) {
                System.out.println("⚠️ No hay datos para mostrar en el reporte.");
            } else {
                for (ReporteCarreraDTO r : reporte) {
                    System.out.println(r);
                }
            }

        } catch (Exception e) {
            System.out.println("\n❌ Error durante la ejecución:");
            e.printStackTrace();
        } finally {
            JpaUtil.close();
            System.out.println("\n🔒 Conexión cerrada.");
        }
    }
}
