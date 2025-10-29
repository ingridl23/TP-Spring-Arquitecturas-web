package main.repository;

import java.util.List;

import org.springframework.stereotype.Repository;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.Query;
import jakarta.transaction.Transactional;
import main.dto.ReporteCarreraDTO;
import main.entity.Estudiante;
import main.entity.Estudiante_Carrera;
import main.util.JpaUtil;

@Repository
@Transactional
public class Estudiante_CarreraRepositoryImp implements Estudiante_CarreraRepository {

    @PersistenceContext
    private EntityManager em;

    public Estudiante_CarreraRepositoryImp() {

        this.em = JpaUtil.getEntityManager(); // inicialización

    }

    @Override
    public Estudiante_Carrera seleccionarPorId(Integer id) {
        try {

            return em.find(Estudiante_Carrera.class, id);

        } catch (Exception e) {

            throw e;

        }
    }

    @Override
    public List<Estudiante_Carrera> seleccionarTodos() {
        try {

            Query query = em.createQuery(

                    "SELECT ec FROM Estudiante_Carrera ec", Estudiante_Carrera.class);
            return query.getResultList();
        } catch (Exception e) {

            throw e;
        }

    }

    @Override
    public List<Estudiante> seleccionarEstudiantesPorCarreraCiudad(Integer idCarrera, String ciudad) {

        try {

            Query query = em.createQuery(
                    "SELECT e FROM Estudiante_Carrera ec " +
                            "JOIN ec.estudiante e " +
                            "WHERE ec.carrera.idCarrera = :idCarrera AND e.ciudad = :ciudad",
                    Estudiante.class)
                    .setParameter("idCarrera", idCarrera)
                    .setParameter("ciudad", ciudad);
            return query.getResultList();

        } catch (Exception e) {

            throw e;
        }
    }

    @Override
    public Estudiante_Carrera guardar(Estudiante_Carrera entity) {
        if (entity.getId() == null || !em.contains(entity)) {
            em.persist(entity);
        } else {
            em.merge(entity);
        }
        return entity;
    }

    @Override
    public void eliminar(Integer id) {
        try {
            em.getTransaction().begin();
            Estudiante_Carrera e = em.find(Estudiante_Carrera.class, id);
            if (e != null)
                em.remove(e);
            em.getTransaction().commit();
        } catch (Exception e) {
            em.getTransaction().rollback();
            throw e;
        }
    }

    @Override
    public List<ReporteCarreraDTO> generarReporteCarreras() {
        try {
            Query query = em.createQuery(

                    "SELECT new dto.ReporteCarreraDTO(" +
                            "c.nombre, " +
                            "ec.anioInscripcion, " +
                            "COUNT(ec.estudiante.id), " +
                            "SUM(CASE WHEN ec.anioEgreso IS NOT NULL THEN 1 ELSE 0 END)) " +
                            "FROM Estudiante_Carrera ec " +
                            "JOIN ec.carrera c " +
                            "GROUP BY c.nombre, ec.anioInscripcion " +
                            "ORDER BY c.nombre ASC, ec.anioInscripcion ASC",
                    ReporteCarreraDTO.class);

            return query.getResultList();
        } catch (Exception e) {
            throw e;
        }
    }

}
