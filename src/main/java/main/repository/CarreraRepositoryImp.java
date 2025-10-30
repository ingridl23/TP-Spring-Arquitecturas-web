package main.repository;

import java.util.List;

import org.springframework.stereotype.Repository;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.Query;
import jakarta.transaction.Transactional;
import main.entity.Carrera;
import main.entity.Estudiante;
import main.util.JpaUtil;

@Repository
@Transactional
public class CarreraRepositoryImp implements CarreraRepository {
	@PersistenceContext
    private EntityManager em;

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
	public Carrera guardar(Carrera entity) {
        if (!em.contains(entity)) {
            em.persist(entity);
        } else {
            em.merge(entity);
        }
        return entity;
 
	}

        
        
        
	@Override           //TENER EN CUENTA EL TIPO DE ATRIBUTO QUE SE CONFIGURO EN LA ENTIDAD (INT-INTEGER O LONG)
	public void eliminar(Integer id) {
		Carrera e = em.find(Carrera.class, id);
        if (e != null) em.remove(e);
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
