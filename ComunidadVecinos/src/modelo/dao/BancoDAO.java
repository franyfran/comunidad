package modelo.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;

import modelo.bancario.Banco;



public class BancoDAO {
	
	EntityManager em; 
	EntityTransaction transaction; 
	
	public BancoDAO()	{
		em = ManejadorEntityManager.getInstancia().getEntityManager();
		transaction = em.getTransaction();
	}
	
	public void alta(Banco b) {
		transaction.begin();
        em.persist(b);		
        em.getTransaction().commit();
	}
	
	public void baja(Integer idCuentaBanco) {
		em.getTransaction().begin();
		Banco b = em.find(Banco.class, idCuentaBanco);
		em.remove(b);
		em.getTransaction().commit();
	}
	
	public void modificacion(Banco b) {
		em.getTransaction().begin();
		em.merge(b);
		em.getTransaction().commit();
	}
	
	public Banco consulta(Integer idCuentaBanco) {
		em.getTransaction().begin();		
		Banco b = em.find(Banco.class, idCuentaBanco);
		em.getTransaction().commit();
		return b;
	}
	
	@SuppressWarnings("unchecked")
	public List<Banco> consultaAll() {
		em.getTransaction().begin();
		Query query = em.createQuery("SELECT b FROM Banco b", Banco.class);	
		List<Banco> bancos = query.getResultList();
		em.getTransaction().commit();
	    return bancos;
	}
	

}
