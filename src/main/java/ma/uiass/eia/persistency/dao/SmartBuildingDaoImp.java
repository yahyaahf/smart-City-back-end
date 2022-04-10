package ma.uiass.eia.persistency.dao;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

import ma.uiass.eia.persistency.entities.SmartBuilding;
import ma.uiass.eia.persistency.entities.Ville;

public class SmartBuildingDaoImp implements IDAO<SmartBuilding> {
	private EntityManager entityManager;
	public SmartBuildingDaoImp() {
		 EntityManagerFactory factory= Persistence.createEntityManagerFactory("PU_SC");
		 
		 
		 entityManager = factory.createEntityManager();
	}

	
	
public void create(SmartBuilding object) {
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

public void update(SmartBuilding object,long id) {
	EntityTransaction transaction= entityManager.getTransaction();
	try {
		 transaction.begin();
		 SmartBuilding smartBuilding= entityManager.find(SmartBuilding.class, id);
		 if (smartBuilding !=null) {
			 smartBuilding.setLatitude(object.getLatitude());
			 smartBuilding.setLongitude(object.getLongitude());
			 smartBuilding.setNombreEtages(object.getNombreEtages());
			 smartBuilding.setSurface(object.getSurface());
			 smartBuilding.setAdress(object.getAdress());
			 entityManager.merge(smartBuilding);
			 transaction.commit();
		 }
		 
	}
	catch(Exception e) {
		transaction.rollback();
		System.out.println(e.getMessage());
	}
	
}

public SmartBuilding getById(long id) {
	
	return entityManager.find(SmartBuilding.class, id);
}

public void delete(SmartBuilding object) {
	EntityTransaction transaction= entityManager.getTransaction();
	try {
		 transaction.begin();
		 this.entityManager.remove(object);
		 transaction.commit();
		 }
	catch(Exception e) {
		transaction.rollback();
		System.out.println(e.getMessage());
	}
	
}

public List<SmartBuilding> getAll() {
Query query = entityManager.createQuery("select v from SmartBuilding v");
	
	return query.getResultList();
}

public List<SmartBuilding> getAllByVille(long idVille){
	List<SmartBuilding> sb = new ArrayList<>();
	Ville ville=entityManager.find(Ville.class, idVille);
	
	Iterator<SmartBuilding> iterator=ville.getBuildings().iterator();
	
while(iterator.hasNext()) {
	SmartBuilding elm =iterator.next();
	sb.add(elm);
	
}
	
	return sb  ;
}
	

}