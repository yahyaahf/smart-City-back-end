package ma.uiass.eia.persistency.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import ma.uiass.eia.persistency.entities.Element;
import ma.uiass.eia.persistency.entities.Ville;

public class ElementDaoImp implements IDAO<Element> {
	private EntityManager entityManager;

	public ElementDaoImp()  {
		 EntityManagerFactory factory= Persistence.createEntityManagerFactory("PU_SC");
		 
		 
		 entityManager = factory.createEntityManager();
	}
	@Override
	public void create(Element object) {
		// TODO Auto-generated method stub

	}

	@Override
	public void update(Element object, long id) {
		// TODO Auto-generated method stub

	}

	@Override
	public Element getById(long id) {
		
		return entityManager.find(Element.class, id);
	}

	@Override
	public void delete(Element object) {
		// TODO Auto-generated method stub

	}

	@Override
	public List<Element> getAll() {
		// TODO Auto-generated method stub
		return null;
	}

}
