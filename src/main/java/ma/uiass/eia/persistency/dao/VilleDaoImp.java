package ma.uiass.eia.persistency.dao;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;


import ma.uiass.eia.persistency.entities.Ville;

public class VilleDaoImp implements IDAO<Ville> {
	private EntityManager entityManager;

	public VilleDaoImp() {
		 EntityManagerFactory factory= Persistence.createEntityManagerFactory("PU_SC");
		 
		 
		 entityManager = factory.createEntityManager();
	}

public void create(Ville object)  {

	EntityTransaction transaction= entityManager.getTransaction();
	try {
		 transaction.begin();
		this.entityManager.persist(object); 
		 transaction.commit();
	}
	catch(Exception e) {
		transaction.rollback();
		System.out.println(e.getMessage());
	}
	
}

public void update(Ville object,long id) {
	EntityTransaction transaction= entityManager.getTransaction();
	try {
		 transaction.begin();
		 Ville ville=entityManager.find(Ville.class, id);
		 if (ville !=null) {
		 
		 ville.setLatitude(object.getLatitude());
		 ville.setLongitude(object.getLongitude());
		 ville.setNom(object.getNom());
		 entityManager.merge(ville);
		 transaction.commit();
		 }
	}
	catch(Exception e) {
		transaction.rollback();
		System.out.println(e.getMessage());
	}
}

public Ville getById(long numero) {
	
	return entityManager.find(Ville.class, numero);
}

public void delete(Ville object) {
	
	this.entityManager.remove(object);
	
}

public List<Ville> getAll() {
	
	Query query = entityManager.createQuery("select v from Ville v");
	
	return query.getResultList();
}

}


