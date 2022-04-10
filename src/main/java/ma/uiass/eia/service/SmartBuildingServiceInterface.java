package ma.uiass.eia.service;

import java.util.List;

import ma.uiass.eia.persistency.entities.SmartBuilding;
import ma.uiass.eia.persistency.entities.Ville;


public interface SmartBuildingServiceInterface {
	
	List<SmartBuilding> getAllSmartBuildings(long idVille);

	SmartBuilding getSmartBuildingById(long numero);

	void createSmartBuilding(int nombreEtages, int surface, double longitude, double latitude,String adress,Ville ville);
	
	void deleteSmartBuilding (SmartBuilding object);
	
	void updateSmartBuilding (int nombreEtages, int surface, double longitude, double latitude,String adress,long id);

}
