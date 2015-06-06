package modelo.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;

import modelo.propietario.Cuota;

public class CuotaDAO {
	EntityManager em; 
	EntityTransaction transaction; 
	
	public CuotaDAO()	
	{
		em = ManejadorEntityManager.getInstancia().getEntityManager();
		transaction = em.getTransaction();
	}

	
	public void alta(Cuota cu) 
	{
		transaction.begin();
        em.persist(cu);		
        em.getTransaction().commit();
	}

	
	public void baja(Integer idCuota) 
	{
		em.getTransaction().begin();
		Cuota cu = em.find(Cuota.class, idCuota);
		em.remove(cu);
		em.getTransaction().commit();
	}

	
	public void modificacion(Cuota cu) 
	{
		em.getTransaction().begin();
		em.merge(cu);
		em.getTransaction().commit();
	}

	
	public Cuota consulta(Integer idCuota) 
	{
		em.getTransaction().begin();		
		Cuota cu = em.find(Cuota.class, idCuota);
		em.getTransaction().commit();
		return cu;
	}

	
	@SuppressWarnings("unchecked")
	public List<Cuota> consultaAll() 
	{
		em.getTransaction().begin();
		Query query = em.createQuery("SELECT cu FROM Cuota cu", Cuota.class);	
		List<Cuota> cuotas = query.getResultList();
		em.getTransaction().commit();
	    return cuotas;
	}


}
