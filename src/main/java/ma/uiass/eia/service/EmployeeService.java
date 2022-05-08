package ma.uiass.eia.service;

import java.util.List;

import ma.uiass.eia.persistency.dao.EmployeeDaoImp;
import ma.uiass.eia.persistency.entities.ClientEntreprise;
import ma.uiass.eia.persistency.entities.Employee;

public class EmployeeService implements EmployeeServiceInterface {
	EmployeeDaoImp employeeDao;
	public EmployeeService() {
		this.employeeDao=new EmployeeDaoImp();
	}
	@Override
	public List<Employee> getAllEmployeesByEntreprise(long idEntreprise) {
		
		return this.employeeDao.getAllByEntreprise(idEntreprise);
	}

	@Override
	public void createEmployee(String nom, String prenom, String email, String sexe, String thelephone, String adress,
			ClientEntreprise entreprise) {
		this.employeeDao.create(new Employee(nom, prenom, email, sexe, thelephone, adress, entreprise));

	}
	@Override
	public Employee getEmployeeById(long id) {
		return this.employeeDao.getById(id);
	}

}
