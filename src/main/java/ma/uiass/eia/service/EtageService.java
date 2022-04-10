package ma.uiass.eia.service;

import java.util.List;

import ma.uiass.eia.persistency.dao.EtageDaoImp;
import ma.uiass.eia.persistency.entities.Etage;
import ma.uiass.eia.persistency.entities.SmartBuilding;

import ma.uiass.eia.persistency.entities.WorkSpace;

public class EtageService implements EtageServiceInterface {
	
	private EtageDaoImp etageDao;
	
	public  EtageService() {
		etageDao=new EtageDaoImp();
		}

	@Override
	public List<Etage> getAllEtages() {
		
		return this.etageDao.getAll();
	}

	@Override
	public Etage getEtageById(long numero) {
		
		return this.etageDao.getById(numero);
	}

	

	@Override
	public void deleteEtage(Etage object) {
		this.etageDao.delete(object);

	}

	/*
	 * @Override public void createEtage(long numEtage, double surface,SmartBuilding
	 * building) { this.etageDao.create(new Etage(numEtage, surface, building));
	 * 
	 * }
	 */
	public void createEtage(int numEtage, double surface,SmartBuilding building) {
		Etage etage = new Etage(numEtage, surface, building);
		
		this.etageDao.create(etage);
		
	}

	@Override
	public void updateEtage(int numEtage, double surface,long id) {
		this.etageDao.update(new Etage(numEtage, surface), id);
		
	}

	@Override
	public List<Etage> getAllEtagesByBuilding(long id) {
		
		return this.etageDao.getAllByBuilding(id);
	}

}
