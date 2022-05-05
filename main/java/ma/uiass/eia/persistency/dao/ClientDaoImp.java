package ma.uiass.eia.persistency.dao;

import ma.uiass.eia.persistency.entities.Client;
import ma.uiass.eia.persistency.entities.ClientEntreprise;
import ma.uiass.eia.persistency.entities.ClientIndividu;
import ma.uiass.eia.persistency.entities.WorkSpace;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

import java.lang.reflect.Field;
import java.util.Iterator;
import java.util.List;

public class ClientDaoImp implements IDAO<Client>{
    private EntityManager entityManager;

    public ClientDaoImp(){
        EntityManagerFactory factory= Persistence.createEntityManagerFactory("PU_SC");
        this.entityManager = factory.createEntityManager();
    }
    @Override
    public void create(Client object) {
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
        System.out.println(object);

    }

    @Override
    public void update(Client object, long id) {
    	EntityTransaction transaction= entityManager.getTransaction();
		try {
			 transaction.begin();
			 Client client = entityManager.find(Client.class, id);
			 if(client!=null) {
				client.setAdress(object.getAdress());
				client.setEmail(object.getEmail());
				client.setLocations(object.getLocations());
				client.setTelephone(object.getTelephone());
				entityManager.merge(client);
				transaction.commit();
				 
			 }
			 
		}
		catch(Exception e) {
			transaction.rollback();
			System.out.println(e.getMessage());
		}

    }

    @Override
    public Client getById(long id) {
        return entityManager.find(Client.class, id);
    }

    @Override
    public void delete(Client object) {
    	
    	this.entityManager.remove(object);

    }

    @Override
    public List<Client> getAll() {
    	Query query = entityManager.createQuery("select w from  Client w");
		List<Client> list =		query.getResultList() ;
		
		return  list;
    }
    
    public List<ClientEntreprise> getClientEntreprise(){
    	Query query = entityManager.createQuery("select w from  ClientEntreprise w");
    	List<ClientEntreprise> list=query.getResultList();
    	
    	return list;
    }
    public List<ClientIndividu> getClientIndividus(){
    	Query query = entityManager.createQuery("select w from  ClientIndividu w");
    	List<ClientIndividu> list=query.getResultList();
    	
    	return list;
    }
    
    public ClientEntreprise getClientEntrepriseById(long id) {
        return entityManager.find(ClientEntreprise.class, id);
    }
   
    
    
    
    
    
    
}
