package modelo.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;

import modelo.propietario.Finca;

public class FincaDAO {
	
	EntityManager em; 
	EntityTransaction transaction; 
	
	public FincaDAO()	
	{
		em = ManejadorEntityManager.getInstancia().getEntityManager();
		transaction = em.getTransaction();
	}

	
	public void alta(Finca f) 
	{
		transaction.begin();
        em.persist(f);		
        em.getTransaction().commit();
	}

	
	public void baja(Integer idFinca) 
	{
		em.getTransaction().begin();
		Finca f = em.find(Finca.class, idFinca);
		em.remove(f);
		em.getTransaction().commit();
	}

	
	public void modificacion(Finca f) 
	{
		em.getTransaction().begin();
		em.merge(f);
		em.getTransaction().commit();
	}

	
	public Finca consulta(Integer idFinca) 
	{
		em.getTransaction().begin();		
		Finca f = em.find(Finca.class, idFinca);
		em.getTransaction().commit();
		return f;
	}

	
	@SuppressWarnings("unchecked")
	public List<Finca> consultaAll() 
	{
		em.getTransaction().begin();
		Query query = em.createQuery("SELECT f FROM Finca f", Finca.class);	
		List<Finca> fincas = query.getResultList();
		em.getTransaction().commit();
	    return fincas;
	}


}
