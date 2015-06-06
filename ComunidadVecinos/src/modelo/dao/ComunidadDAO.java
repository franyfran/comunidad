package modelo.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;

import modelo.comunidad.Comunidad;

public class ComunidadDAO {

	EntityManager em; 
	EntityTransaction transaction; 
	
	public ComunidadDAO()	
	{
		em = ManejadorEntityManager.getInstancia().getEntityManager();
		transaction = em.getTransaction();
	}

	
	public void alta(Comunidad c) 
	{
		transaction.begin();
        em.persist(c);		
        em.getTransaction().commit();
	}

	
	public void baja(Integer idComunidad) 
	{
		em.getTransaction().begin();
		Comunidad c = em.find(Comunidad.class, idComunidad);
		em.remove(c);
		em.getTransaction().commit();
	}

	
	public void modificacion(Comunidad c) 
	{
		em.getTransaction().begin();
		em.merge(c);
		em.getTransaction().commit();
	}

	
	public Comunidad consulta(Integer idComunidad) 
	{
		em.getTransaction().begin();		
		Comunidad c = em.find(Comunidad.class, idComunidad);
		em.getTransaction().commit();
		return c;
	}

	
	@SuppressWarnings("unchecked")
	public List<Comunidad> consultaAll() 
	{
		em.getTransaction().begin();
		Query query = em.createQuery("SELECT c FROM Comunidad c", Comunidad.class);	
		List<Comunidad> comunidades = query.getResultList();
		em.getTransaction().commit();
	    return comunidades;
	}
}
