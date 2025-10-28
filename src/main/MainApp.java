package main;
import main.dto.CarreraDTO;
import main.dto.EstudianteDTO;
import main.dto.Estudiante_CarreraDTO;
import main.entity.Carrera;
import main.entity.Estudiante;
import main.entity.Estudiante_Carrera;
import main.repository.CarreraRepositoryImp;
import main.repository.EstudianteRepositoryImp;
import main.repository.Estudiante_CarreraRepositoryImp;
import util.JpaUtil;

public class MainApp {

    public static void main(String[] args) {

        // 1️⃣ Inicializar la unidad de persistencia
        JpaUtil.init("MYSQL"); // o "Derby" según tu persistence.xml
        System.out.println("✅ Conexión inicializada correctamente.");

        try {

            // 2️⃣ Crear DTOs de ejemplo
            CarreraDTO carreraDTO = new CarreraDTO(1, "Tecnicatura en Desarrollo de Aplicaciones");
            EstudianteDTO estudianteDTO = new EstudianteDTO(12345, "Ingrid", "Ledesma", 20, "F", "Tres Arroyos", 1010);

            // 3️⃣ Convertir DTO → Entity
            Carrera carreraEntity = carreraDTO.toEntity();
            Estudiante estudianteEntity = estudianteDTO.toEntity();

            // 4️⃣ Guardar en la base de datos usando los Repository
            CarreraRepositoryImp carreraRepo = new CarreraRepositoryImp();
            EstudianteRepositoryImp estudianteRepo = new EstudianteRepositoryImp();

            

            carreraRepo.guardar(carreraEntity);
            estudianteRepo.guardar(estudianteEntity);

            System.out.println("✅ Carrera y Estudiante guardados correctamente.");

            // 5️⃣ Matricular al estudiante en una carrera (tabla intermedia)
            Estudiante_CarreraDTO ecDTO = new Estudiante_CarreraDTO(1, estudianteEntity, carreraEntity, false, 1);
            Estudiante_Carrera  esCarrEntity= ecDTO.toEntity();
            Estudiante_CarreraRepositoryImp ecRepo = new Estudiante_CarreraRepositoryImp();
            ecRepo.guardar(esCarrEntity);

            System.out.println("✅ Relación estudiante-carrera guardada correctamente.");

            // 6️⃣ Consultar y mostrar
            System.out.println("\n📚 Carreras cargadas:");
            for (Carrera c : carreraRepo.seleccionarTodos()) {
                System.out.println(" - " + c.getNombre());
            }

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            JpaUtil.close();
            System.out.println("\n🔒 Conexión cerrada.");
        }
    }
}
