package ma.uiass.eia.service;

import java.util.List;

import ma.uiass.eia.persistency.dao.VilleDaoImp;
import ma.uiass.eia.persistency.entities.Ville;

public class VilleService implements VilleServiceInterface {
	
	private VilleDaoImp villeDao;
	public VilleService() {
	villeDao=new VilleDaoImp();
	}

	@Override
	public List<Ville> getAllVilles() {
	return this.villeDao.getAll();


	}

	@Override
	public Ville getVilleById(long numero) {
	
	return this.villeDao.getById(numero);
	}

	@Override
	public void createVille(String intitule, double latitude, double longitude) {
		this.villeDao.create(new Ville(intitule, latitude, longitude));
	

	}

	@Override
	public void updateVille(String nom,double latitude,double longitude,long id) {
		this.villeDao.update(new Ville(nom, latitude, longitude), id );
		
	}

	@Override
	public void deleteVille(Ville object) {
		this.villeDao.delete(object);
		
	}


}
