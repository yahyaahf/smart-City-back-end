package ma.uiass.eia.service;

import java.util.List;

import ma.uiass.eia.persistency.entities.Client;
import ma.uiass.eia.persistency.entities.ClientEntreprise;
import ma.uiass.eia.persistency.entities.ClientIndividu;




public interface ClientServiceInterface {
	
	List<ClientEntreprise> getAllClientsEntreprise();
	
	List<ClientIndividu> getAllClientsIndividu();

	Client getClientById(long numero);

	void createClient(String email, String telephone, String adress, String formeJuridique, String patente,String nom,
			String prenom,String sexe,String type);

	void updateClient(String email, String telephone, String adress, String formeJuridique, String patente,String nom, String prenom,String sexe,String type,long id);

	void deleteClient(Client object);

}

