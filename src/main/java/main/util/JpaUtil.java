package main.util;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class JpaUtil {

    private static EntityManagerFactory emf;

    // Inicializa la unidad de persistencia elegida
    public static void init(String unidadPersistencia) {
        if (emf == null) {
            emf = Persistence.createEntityManagerFactory(unidadPersistencia);
        }
    }

    // Devuelve un EntityManager nuevo
    public static EntityManager getEntityManager() {
        if (emf == null) {
            // Por defecto, si no se inicializó
            init("MYSQL");
        }
        return emf.createEntityManager();
    }

    // Cierra la conexión general
    public static void close() {
        if (emf != null && emf.isOpen()) {
            emf.close();
        }
    }
}
