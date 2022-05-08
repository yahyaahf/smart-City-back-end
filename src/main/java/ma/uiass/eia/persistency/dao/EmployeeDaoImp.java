package ma.uiass.eia.persistency.dao;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import ma.uiass.eia.persistency.entities.ClientEntreprise;
import ma.uiass.eia.persistency.entities.Employee;
import ma.uiass.eia.persistency.entities.Ville;

public class EmployeeDaoImp implements IDAO<Employee> {
	private EntityManager entityManager;

	public EmployeeDaoImp() {
		 EntityManagerFactory factory= Persistence.createEntityManagerFactory("PU_SC");
		 
		 
		 entityManager = factory.createEntityManager();
	}
	@Override
	public void create(Employee object) {
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
	public void update(Employee object, long id) {
		// TODO Auto-generated method stub

	}

	@Override
	public Employee getById(long id) {
		
		return entityManager.find(Employee.class, id);
	}

	@Override
	public void delete(Employee object) {
		// TODO Auto-generated method stub

	}

	@Override
	public List<Employee> getAll() {
		// TODO Auto-generated method stub
		return null;
	}
	public List<Employee> getAllByEntreprise(long idEntreprise){

		List<Employee> employees = new ArrayList<>();
		ClientEntreprise entreprise=entityManager.find(ClientEntreprise.class, idEntreprise);
		
		Iterator<Employee> iterator=entreprise.getEmployees().iterator();
		
	while(iterator.hasNext()) {
		Employee elm =iterator.next();
		employees.add(elm);
		
	}
		
		return employees  ;
	}

}
