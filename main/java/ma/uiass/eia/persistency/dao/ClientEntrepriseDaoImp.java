package ma.uiass.eia.persistency.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import ma.uiass.eia.persistency.entities.ClientEntreprise;

public class ClientEntrepriseDaoImp implements IDAO<ClientEntreprise> {
	private EntityManager entityManager;

     public ClientEntrepriseDaoImp() {
        EntityManagerFactory factory= Persistence.createEntityManagerFactory("PU_SC");
        this.entityManager = factory.createEntityManager();
    }
	@Override
	public void create(ClientEntreprise object) {
		

	}

	@Override
	public void update(ClientEntreprise object, long id) {
		// TODO Auto-generated method stub

	}

	@Override
	public ClientEntreprise getById(long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void delete(ClientEntreprise object) {
		// TODO Auto-generated method stub

	}

	@Override
	public List<ClientEntreprise> getAll() {
		// TODO Auto-generated method stub
		return null;
	}

}
