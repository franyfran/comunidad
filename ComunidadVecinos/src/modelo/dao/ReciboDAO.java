package modelo.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;

import modelo.contabilidad.Recibo;

public class ReciboDAO {

	EntityManager em; 
	EntityTransaction transaction; 
	
	public ReciboDAO()	
	{
		em = ManejadorEntityManager.getInstancia().getEntityManager();
		transaction = em.getTransaction();
	}

	
	public void alta(Recibo r) 
	{
		transaction.begin();
        em.persist(r);		
        em.getTransaction().commit();
	}

	
	public void baja(Integer idRecibo) 
	{
		em.getTransaction().begin();
		Recibo r = em.find(Recibo.class, idRecibo);
		em.remove(r);
		em.getTransaction().commit();
	}

	
	public void modificacion(Recibo r) 
	{
		em.getTransaction().begin();
		em.merge(r);
		em.getTransaction().commit();
	}

	
	public Recibo consulta(Integer idRecibo) 
	{
		em.getTransaction().begin();		
		Recibo r = em.find(Recibo.class, idRecibo);
		em.getTransaction().commit();
		return r;
	}

	
	@SuppressWarnings("unchecked")
	public List<Recibo> consultaAll() 
	{
		em.getTransaction().begin();
		Query query = em.createQuery("SELECT r FROM Recibo r", Recibo.class);	
		List<Recibo> recibos = query.getResultList();
		em.getTransaction().commit();
	    return recibos;
	}

}
