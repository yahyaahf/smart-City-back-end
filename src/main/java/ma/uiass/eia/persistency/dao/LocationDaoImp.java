package ma.uiass.eia.persistency.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

import ma.uiass.eia.persistency.entities.Location;
import ma.uiass.eia.persistency.entities.WorkSpace;

public class LocationDaoImp implements IDAO<Location> {
private EntityManager entityManager;
	
	 public LocationDaoImp() {
		 
		 EntityManagerFactory factory= Persistence.createEntityManagerFactory("PU_SC");
		 
		 
		 entityManager = factory.createEntityManager();
	}
	@Override
	public void create(Location object) {
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

	@Override
	public void update(Location object, long id) {
		

	}

	@Override
	public Location getById(long id) {
		
		return  entityManager.find(Location.class, id);
	}

	@Override
	public void delete(Location object) {
		this.entityManager.remove(object);

	}

	@Override
	public List<Location> getAll() {
Query query = entityManager.createQuery("select l from Location l");
	List<Location > locations=	query.getResultList();
	
		return locations;
	}

}
