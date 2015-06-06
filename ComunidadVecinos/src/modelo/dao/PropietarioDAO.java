package modelo.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;

import modelo.propietario.Propietario;

public class PropietarioDAO {
	
	EntityManager em; 
	EntityTransaction transaction; 
	
	public PropietarioDAO()	
	{
		em = ManejadorEntityManager.getInstancia().getEntityManager();
		transaction = em.getTransaction();
	}

	
	public void alta(Propietario p) 
	{
		transaction.begin();
        em.persist(p);		
        em.getTransaction().commit();
	}

	
	public void baja(Integer idPropietario) 
	{
		em.getTransaction().begin();
		Propietario p = em.find(Propietario.class, idPropietario);
		em.remove(p);
		em.getTransaction().commit();
	}

	
	public void modificacion(Propietario p) 
	{
		em.getTransaction().begin();
		em.merge(p);
		em.getTransaction().commit();
	}

	
	public Propietario consulta(Integer idPropietario) 
	{
		em.getTransaction().begin();		
		Propietario p = em.find(Propietario.class, idPropietario);
		em.getTransaction().commit();
		return p;
	}

	
	@SuppressWarnings("unchecked")
	public List<Propietario> consultaAll() 
	{
		em.getTransaction().begin();
		Query query = em.createQuery("SELECT p FROM Propietario p", Propietario.class);	
		List<Propietario> propietarios = query.getResultList();
		em.getTransaction().commit();
	    return propietarios;
	}


}
