package main.repository;

import java.util.List;

import org.springframework.stereotype.Repository;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.Query;
import jakarta.transaction.Transactional;
import main.dto.EstudianteDTO;
import main.entity.Estudiante;
import main.util.JpaUtil;
@Repository
@Transactional
public class EstudianteRepositoryImp implements EstudianteRepository {

	@PersistenceContext
    private EntityManager em;

@Override
public Estudiante seleccionarPorId(Integer id) {
     
        return em.find(Estudiante.class, id);
        
	}

        
        
	@Override
	public List<Estudiante> seleccionarTodos() {

            
           return em.createQuery("SELECT e FROM Estudiante e", Estudiante.class)
                 .getResultList();
                
	}

	

    @Override
    public Estudiante guardar(Estudiante entity) {
        if (entity.getNroDocumento() == 0 || !em.contains(entity)) {
            em.persist(entity);
        } else {
            em.merge(entity);
        }
        return entity;
    }
    @Override
    public void eliminar(Integer id) {
        Estudiante e = em.find(Estudiante.class, id);
        if (e != null) em.remove(e);
    }

    @Override
    public List<Estudiante> estudiantesOrdenadosDESC() {
     try{
          Query query = em .createQuery(

			            "SELECT e FROM Estudiante e " +
			            "ORDER BY e.apellido DESC",
			            Estudiante.class
			        );
		 return query.getResultList();
                 
     } catch(Exception e){

            throw e;
     }	
    }

    @Override
    public Estudiante seleccionarPorLibreta(Integer libreta) {
     try{
         Query query = em.createQuery(
		            "SELECT e FROM Estudiante e " +
		            "WHERE nroLibreta =: libreta",
		            Estudiante.class
		        ).setParameter("libreta", libreta);
	           return (Estudiante) query.getSingleResult();
     } catch(Exception e){
        
            throw e;
        }
    }
    
    

    @Override
    public List<Estudiante> estudiantesPorGenero(String genero) {

        try {
            Query query = em.createQuery(
		            "SELECT e FROM Estudiante e " +
		            "WHERE genero =: genero",
		            Estudiante.class
		        ).setParameter("genero", genero);
		       return query.getResultList();
        }catch(Exception e){

            throw e;
        }
        
    }

   

    

}
