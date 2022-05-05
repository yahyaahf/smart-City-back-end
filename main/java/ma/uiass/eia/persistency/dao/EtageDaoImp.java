package ma.uiass.eia.persistency.dao;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

import ma.uiass.eia.persistency.entities.Etage;
import ma.uiass.eia.persistency.entities.SmartBuilding;
import ma.uiass.eia.persistency.entities.Ville;


public class EtageDaoImp implements IDAO<Etage> {
	
	private EntityManager entityManager;

	public EtageDaoImp() {
		 EntityManagerFactory factory= Persistence.createEntityManagerFactory("PU_SC");
		 
		 
		 entityManager = factory.createEntityManager();
	}

	
	public void create(Etage object) {
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
	

	
	public void update(Etage object, long id) {
		EntityTransaction transaction= entityManager.getTransaction();
		try {
			transaction.begin();
			Etage etage =entityManager.find(Etage.class, id);
			if (etage!=null) {
				etage.setNumEtage(object.getNumEtage());
				etage.setSurface(object.getSurface());
				etage.setSmartBuilding(object.getSmartBuilding());
				entityManager.merge(etage);
				transaction.commit();
			}
		}
			catch(Exception e) {
				transaction.rollback();
				System.out.println(e.getMessage());
			}
		
	}

	
	public Etage getById(long id) {
		return entityManager.find(Etage.class, id);
	}

	
	public void delete(Etage object) {
		this.entityManager.remove(object);
		
	}

	public List<Etage> getAll() {
		Query query = entityManager.createQuery("select v from Etage v");
		
		return query.getResultList();
	}
	public List<Etage> getAllByBuilding(long idBuilding) {
		List<Etage> sb= new ArrayList<Etage>();
		SmartBuilding building=entityManager.find(SmartBuilding.class, idBuilding);
		Iterator<Etage> iterator=building.getEtages().iterator();
		
	while(iterator.hasNext()) {
		Etage elm =iterator.next();
		sb.add(elm);
		
	}
		
		return sb  ;
		
	}
}
