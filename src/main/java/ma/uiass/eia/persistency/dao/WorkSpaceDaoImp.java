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
import ma.uiass.eia.persistency.entities.WorkSpace;

public class WorkSpaceDaoImp implements IDAO<WorkSpace> {
	private EntityManager entityManager;
	
	public WorkSpaceDaoImp() {
		 EntityManagerFactory factory= Persistence.createEntityManagerFactory("PU_SC");
		 
		 
		 entityManager = factory.createEntityManager();
	}
	
	@Override
	public void create(WorkSpace object) {
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
	public void update(WorkSpace object , long id ) {
		EntityTransaction transaction= entityManager.getTransaction();
		try {
			 transaction.begin();
		 entityManager.merge(object);
		}
		catch(Exception e) {
			transaction.rollback();
			System.out.println(e.getMessage());
		}
		
	}
	
	@Override
	public WorkSpace getById(long id) {
		return entityManager.find(WorkSpace.class, id);
	}
	

	
	@Override
	public void delete(WorkSpace object) {
		this.entityManager.remove(object);
		
	}

	@Override
	public List<WorkSpace> getAll() {
		Query query = entityManager.createQuery("select w from WorkSpace w");
		
		return query.getResultList();
	}
	
	public List<WorkSpace> getAllByEtage(long id) {
		List<WorkSpace> sb = new ArrayList<>();
		Etage etage=entityManager.find(Etage.class, id);
		System.out.println("****************************"+etage+"********************************");
		Iterator<WorkSpace> iterator=etage.getWorkSpaces().iterator();
		System.out.println(iterator);
	while(iterator.hasNext()) {
		WorkSpace elm =iterator.next();
		sb.add(elm);
		
	}
		
		return sb  ;
		
		
		
	}

	
	
	

}
