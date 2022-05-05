package ma.uiass.eia.service;

import java.util.List;

import ma.uiass.eia.persistency.entities.Etage;
import ma.uiass.eia.persistency.entities.SmartBuilding;
import ma.uiass.eia.persistency.entities.Ville;
import ma.uiass.eia.persistency.entities.WorkSpace;

public interface EtageServiceInterface {
	List<Etage> getAllEtagesByBuilding(long id);
	
	List<Etage> getAllEtages();

	Etage getEtageById(long numero);

	void createEtage(int numEtage, double surface, SmartBuilding building);

	void updateEtage(int numEtage, double surface,long id);

	void deleteEtage(Etage object);


	

}
