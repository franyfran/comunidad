package modelo.dao;

import javax.persistence.EntityManager;
import javax.persistence.Persistence;

public class ManejadorEntityManager {
	private static ManejadorEntityManager instancia;

	private EntityManager entityManager;
	
	private ManejadorEntityManager() {
		entityManager = Persistence.createEntityManagerFactory("COMUNIDADES").createEntityManager();
	}

	private synchronized static void createInstance() {
		if (instancia == null) {
			instancia = new ManejadorEntityManager();
		}
	}
	
	public static ManejadorEntityManager getInstancia(){
		createInstance();	
		return instancia;
	}

	public EntityManager getEntityManager() {
		return entityManager;
	}
}
