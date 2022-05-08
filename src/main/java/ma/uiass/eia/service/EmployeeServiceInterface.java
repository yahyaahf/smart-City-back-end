package ma.uiass.eia.service;

import java.util.List;

import ma.uiass.eia.persistency.entities.ClientEntreprise;
import ma.uiass.eia.persistency.entities.Employee;
import ma.uiass.eia.persistency.entities.SmartBuilding;
import ma.uiass.eia.persistency.entities.Ville;


public interface EmployeeServiceInterface {
	public List<Employee> getAllEmployeesByEntreprise(long idEntreprise );
	
	void createEmployee(String nom, String prenom, String email, String sexe, String thelephone, String adress,ClientEntreprise entreprise);
	
	public Employee getEmployeeById(long id	);

}
