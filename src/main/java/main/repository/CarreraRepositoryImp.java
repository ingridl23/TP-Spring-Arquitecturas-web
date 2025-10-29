package main.repository;

import java.util.List;

import org.springframework.stereotype.Repository;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Query;
import jakarta.transaction.Transactional;
import main.entity.Carrera;
import main.util.JpaUtil;

@Repository
@Transactional
public class CarreraRepositoryImp implements CarreraRepository {
    
       private EntityManager em;
   
     
     public CarreraRepositoryImp() {
    
          this.em = JpaUtil.getEntityManager(); // inicialización
    }
    

        
	@Override
	public Carrera seleccionarPorId(Integer id) {
            
           
        return em.find(Carrera.class, id);
	}

	@Override
	public List<Carrera> seleccionarTodos() {   
           return em.createQuery("SELECT c FROM Carrera c", Carrera.class)
                 .getResultList();

	}

	@Override
	public Carrera guardar(Carrera carrera) {
            
            //bloque para saber si necesita insertar o modificar una ya existente
     try {
            em.getTransaction().begin();
            if (!em.contains(carrera)) {
                em.persist(carrera);
                
          
            } else {
                em.merge(carrera);
            
            }
            em.getTransaction().commit();
            //si sale por cualquiera de los dos caminos igual retorna 
            return carrera;
        } catch (Exception e) {
            em.getTransaction().rollback();
            throw e;
        }
		
	}

        
        
        
	@Override           //TENER EN CUENTA EL TIPO DE ATRIBUTO QUE SE CONFIGURO EN LA ENTIDAD (INT-INTEGER O LONG)
	public void eliminar(Integer id) {
		  try {
            em.getTransaction().begin();
            Carrera c = em.find(Carrera.class, id);
            if (c != null) em.remove(c);
            em.getTransaction().commit();
        } catch (Exception e) {
            em.getTransaction().rollback();
            throw e;
        }
	}

    @Override
    public List<Carrera> carrerasConEstudiantesOrdenadas() {
        
        try{
        	Query query = em.createQuery(
        		    "SELECT c FROM Carrera c " + 
        		    "JOIN c.estudiantesInscriptos ec " +
        		    "GROUP BY c " + 
        		    "ORDER BY COUNT(ec) DESC",
        		    Carrera.class
        		);
        return query.getResultList();

        
    }catch(Exception e) {

            throw e;
    
}

    }	

}
