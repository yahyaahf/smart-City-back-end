package ma.uiass.eia.service;

import java.time.LocalDate;
import java.util.List;

import ma.uiass.eia.persistency.dao.LocationDaoImp;
import ma.uiass.eia.persistency.entities.Client;
import ma.uiass.eia.persistency.entities.Location;
import ma.uiass.eia.persistency.entities.WorkSpace;

public class LocationService implements LocationServiceInterface {
	private LocationDaoImp locationDao;
	
	public LocationService() {
		this.locationDao = new LocationDaoImp();
	}
	@Override
	public List<Location> getAllLocations() {
		
		return this.locationDao.getAll();
	}

	@Override
	public Location getLocationeById(long numero) {
		
		return this.locationDao.getById(numero);
	}

	@Override
	public void createLocation(LocalDate dateCreation, LocalDate dateDebut, LocalDate dateFin, Client client,
			WorkSpace workSpace) {
		this.locationDao.create(new Location(dateCreation, dateDebut, dateFin, client, workSpace));

	}

	@Override
	public void updateLocation(LocalDate dateCreation, LocalDate dateDebut, LocalDate dateFin, Client client,
			WorkSpace workSpace, long id) {
		this.locationDao.update(new Location(dateCreation, dateDebut, dateFin, client, workSpace),id);

	}

	@Override
	public void deleteLocation(Location object) {
		this.locationDao.delete(object);

	}

}
