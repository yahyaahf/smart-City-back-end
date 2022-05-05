package ma.uiass.eia.service;

import java.util.ArrayList;
import java.util.List;

import ma.uiass.eia.persistency.dao.ClientDaoImp;
import ma.uiass.eia.persistency.entities.Client;
import ma.uiass.eia.persistency.entities.ClientEntreprise;
import ma.uiass.eia.persistency.entities.ClientIndividu;


public class ClientService implements ClientServiceInterface {
	private ClientDaoImp clientDao;
	
	public ClientService() {
		this.clientDao= new  ClientDaoImp();
	}
	
	


	@Override
	public Client getClientById(long numero) {
		
		return this.clientDao.getById(numero);
	}

	@Override
	public void createClient(String email, String telephone, String adress, String formeJuridique, String patente,
			String nom, String prenom, String sexe,String type) {
		
		if(type.equalsIgnoreCase("CE")) {
			ClientEntreprise ce=new ClientEntreprise(email, telephone, adress, formeJuridique, patente);
			
			this.clientDao.create(ce);
		}
		else if (type.equalsIgnoreCase("CI")){
			
			ClientIndividu ci=new ClientIndividu(email, telephone, adress, nom, prenom, sexe);
			
			this.clientDao.create(ci);
			
		}
		
		

	}

	@Override
	public void updateClient(String email, String telephone, String adress, String formeJuridique, String patente,
			String nom, String prenom, String sexe,String type, long id) {
		
		
		if(type.equals("CE")) this.clientDao.update(new ClientEntreprise(email, telephone, adress, formeJuridique, patente), id);
		else this.clientDao.update(new ClientIndividu(email, telephone, adress, nom, prenom, sexe),id);

	}

	@Override
	public void deleteClient(Client object) {
		this.clientDao.delete(object);

	}




	@Override
	public List<ClientEntreprise> getAllClientsEntreprise() {
		List<ClientEntreprise> list=this.clientDao.getClientEntreprise();
		/*List<Object> l= new ArrayList<>();
		for (Object elm : list) {
			System.out.println(elm);
			if (elm instanceof ClientEntreprise) l.add((ClientEntreprise)elm);
		}
		
		*/
		return list;
	}




	@Override
	public List<ClientIndividu> getAllClientsIndividu() {
		List<ClientIndividu> list=this.clientDao.getClientIndividus();
		/*List<Object> l= new ArrayList<>();
		for (Object elm : list) {
			System.out.println(elm);
			if (elm instanceof ClientIndividu)l.add((ClientIndividu)elm);
		}
		*/
		
		return list;
	}
	
	public ClientEntreprise getClientEntrepriseById(long id) {
		return this.clientDao.getClientEntrepriseById(id);
		
	}

}
