package ma.uiass.eia.service;

import java.util.ArrayList;
import java.util.List;

import ma.uiass.eia.persistency.dao.SmartBuildingDaoImp;
import ma.uiass.eia.persistency.dao.VilleDaoImp;
import ma.uiass.eia.persistency.entities.SmartBuilding;
import ma.uiass.eia.persistency.entities.Ville;


public class SmartBuildingService implements SmartBuildingServiceInterface {
	
	private SmartBuildingDaoImp smartBuildingDao;
	
	public SmartBuildingService() {
		// TODO Auto-generated constructor stub
		smartBuildingDao=new SmartBuildingDaoImp();
		
	}

	public List<SmartBuilding> getAllSmartBuildings(){
		return this.smartBuildingDao.getAll();
	}
	

	@Override
	public SmartBuilding getSmartBuildingById(long numero) {
		
		return this.smartBuildingDao.getById(numero);
	}

	@Override
	public void createSmartBuilding(int nombreEtages, int surface, double longitude, double latitude,String adress,Ville ville) {
		this.smartBuildingDao.create(new SmartBuilding(nombreEtages, adress,surface, longitude, latitude,ville));
		
	}

	@Override
	public void deleteSmartBuilding(SmartBuilding object) {
		this.smartBuildingDao.delete(object);
		
	}

	@Override
	public void updateSmartBuilding(int nombreEtages, int surface, double longitude, double latitude,String adress,long id) {
		this.smartBuildingDao.update(new SmartBuilding(nombreEtages, surface, longitude, latitude,adress),id);
		
	}

	@Override
	public List<SmartBuilding> getAllSmartBuildings(long idVille) {
		
		return this.smartBuildingDao.getAllByVille(idVille);
	}

}


 