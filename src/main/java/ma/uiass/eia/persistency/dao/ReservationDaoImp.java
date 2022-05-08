package ma.uiass.eia.persistency.dao;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

import ma.uiass.eia.persistency.entities.Reservation;
import ma.uiass.eia.persistency.entities.SmartBuilding;
import ma.uiass.eia.persistency.entities.Ville;
import ma.uiass.eia.persistency.entities.WorkSpace;

public class ReservationDaoImp implements IDAO<Reservation> {
	private EntityManager entityManager;
	public ReservationDaoImp() {
		 EntityManagerFactory factory= Persistence.createEntityManagerFactory("PU_SC");
		 
		 
		 entityManager = factory.createEntityManager();
	}

	@Override
	public void create(Reservation object) {
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
	public void update(Reservation object, long id) {
		// TODO Auto-generated method stub

	}

	@Override
	public Reservation getById(long id) {
		// TODO Auto-generated method stub
		return entityManager.find(Reservation.class, id);
	}

	@Override
	public void delete(Reservation object) {
		// TODO Auto-generated method stub

	}

	@Override
	public List<Reservation> getAll() {
		Query query = entityManager.createQuery("select v from Reservation v");
		
		return query.getResultList();
	}
	

}
