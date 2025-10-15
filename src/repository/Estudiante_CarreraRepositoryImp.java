package repository;

import dto.Estudiante_CarreraDTO;
import java.util.List;

import entity.Estudiante;
import entity.Estudiante_Carrera;
import javax.persistence.EntityManager;
import javax.persistence.Query;
import dto.ReporteCarreraDTO;
import util.JpaUtil;

public class Estudiante_CarreraRepositoryImp implements Estudiante_CarreraRepository {
    
     private EntityManager em;
	
	public Estudiante_CarreraRepositoryImp() {
        
          this.em = JpaUtil.getEntityManager(); // inicialización
        
        }
	
	
        
        
        
	@Override
	public Estudiante_Carrera seleccionarPorId(Integer id) {
	 try{
           
             
        return em.find(Estudiante_Carrera.class, id);
        
        }catch(Exception e){
            
            throw e;
            
}
	}

	@Override
	public List<Estudiante_Carrera> seleccionarTodos() {
        try{
            
           Query query = em.createQuery(
                   
                   "SELECT ec FROM Estudiante_Carrera ec", Estudiante_Carrera.class);
                return query.getResultList();
        }catch(Exception e){
          
            throw e;
       }
                
	}


	

	@Override
	public List<Estudiante> seleccionarEstudiantesPorCarreraCiudad(Integer idCarrera, String ciudad) {
		 
            try{
                     
                     
             Query query = em.createQuery(
		            "SELECT e FROM Estudiante_Carrera ec " +
		            "JOIN ec.estudiante e " +
		            "WHERE ec.carrera.idCarrera = :idCarrera AND e.ciudad = :ciudad",
		            Estudiante.class
		        )
		        .setParameter("idCarrera", idCarrera)
		        .setParameter("ciudad", ciudad);
		       return query.getResultList();
                     
                     
                 }catch(Exception e){

            throw e;
                 }
        }
@Override
public Estudiante_Carrera guardar(Estudiante_Carrera entity) {
    try {
        em.getTransaction().begin();

        if (entity.getId() == null) {
            em.persist(entity);        // si no tiene ID, inserta
        } else {
            entity = em.merge(entity); // si ya existe, actualiza
        }

        em.getTransaction().commit();
        return entity;                // siempre retorna la entidad

    } catch (Exception e) {
        em.getTransaction().rollback();
        throw e;
    }
}


    @Override
    public void eliminar(Integer id) {
              try {
            em.getTransaction().begin();
            Estudiante_Carrera e = em.find(Estudiante_Carrera.class, id);
            if (e != null) em.remove(e);
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
            ReporteCarreraDTO.class
        );

        return query.getResultList();
    } catch (Exception e) {
        throw e;
    }
    
    }
}
