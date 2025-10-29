package main.repository;

import java.util.List;

import org.springframework.stereotype.Repository;

import jakarta.persistence.EntityManager;
import jakarta.persistence.Query;
import jakarta.transaction.Transactional;
import main.dto.EstudianteDTO;
import main.entity.Estudiante;
import main.util.JpaUtil;
@Repository
@Transactional
public class EstudianteRepositoryImp implements EstudianteRepository {
    
  private EntityManager em;

    public EstudianteRepositoryImp() {
      this.em = JpaUtil.getEntityManager(); // inicialización
    }
  
  
  
@Override
public Estudiante seleccionarPorId(Integer id) {
		      
    try{
           
        return em.find(Estudiante.class, id);
        }finally {
            em.close();
        }
	}

        
        
	@Override
	public List<Estudiante> seleccionarTodos() {
	
        try{
            
            
           return em.createQuery("SELECT e FROM Estudiante e", Estudiante.class)
                 .getResultList();
        }finally {
            em.close();
        }
                
	}

	

    @Override
    public Estudiante guardar(Estudiante entity) {
     //bloque para saber si necesita insertar o modificar una ya existente
     try {
            em.getTransaction().begin();
            if (!em.contains(entity)) {
                em.persist(entity);
                
          
            } else {
                em.merge(entity);
            
            }
            em.getTransaction().commit();
            //si sale por cualquiera de los dos caminos igual retorna 
               return entity;
        } catch (Exception e) {
            em.getTransaction().rollback();
            throw e;
        }finally{
          em.close();
      }
    }

    @Override
    public void eliminar(Integer id) {
       try {
            em.getTransaction().begin();
            Estudiante e = em.find(Estudiante.class, id);
            if (e != null) em.remove(e);
            em.getTransaction().commit();
        } catch (Exception e) {
            em.getTransaction().rollback();
            throw e;
        }finally {
            em.close();
        }	
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
        }finally {
            em.close();
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
        }finally {
            em.close();
        }
    }
    
    

    @Override
    public List<Estudiante> estudiantesPorGenero(String genero) {

        try {
            Query query = em.createQuery(
		            "SELECT e FROM Estudiante e " +
		            "WHERE genero =: gene",
		            Estudiante.class
		        ).setParameter("genero", genero);
		       return query.getResultList();
        }catch(Exception e){

            throw e;
        }finally {
            em.close();
        }
        
    }

   

    

}
