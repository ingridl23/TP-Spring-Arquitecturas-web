package main.repository;

import main.dto.Estudiante_CarreraDTO;
import java.util.List;

import main.entity.Estudiante;
import main.entity.Estudiante_Carrera;
import javax.persistence.EntityManager;
import javax.persistence.Query;
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
            
}finally {
            em.close();
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
       }finally {
            em.close();
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
                 }finally{
                     em.close();
                 }
	}

    @Override
    public Estudiante_Carrera guardar(Estudiante_Carrera entity) {
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
            Estudiante_Carrera e = em.find(Estudiante_Carrera.class, id);
            if (e != null) em.remove(e);
            em.getTransaction().commit();
        } catch (Exception e) {
            em.getTransaction().rollback();
            throw e;
        }finally {
            em.close();
        }
    }

}
