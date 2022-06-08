package ma.uiass.eia.service;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import ma.uiass.eia.persistency.dao.LocationDaoImp;
import ma.uiass.eia.persistency.entities.*;

public class LocationService implements LocationServiceInterface {
	private LocationDaoImp locationDao;
	private WorkSpaceService serviceW ;
	private ElementService serviceEle;
	
	public LocationService() {
		this.locationDao = new LocationDaoImp();
		this.serviceW=new WorkSpaceService();
		this.serviceEle=new ElementService();
	}
	@Override
	public List<Location> getAllLocations() {
		List<Location> locations=this.locationDao.getAll();
		
		return locations;
	}

	@Override
	public Location getLocationeById(long numero) {
		
		return this.locationDao.getById(numero);
	}

	@Override
	public void createLocation(String dateCreation, String dateDebut, String dateFin, Client client,
			Element element) {
		Location location =new Location(dateCreation, dateDebut, dateFin, client, element);
		//location.setMontant(location.calculerMontant());
		this.locationDao.create(location);


	}

	@Override
	public void updateLocation(String dateCreation, String dateDebut, String dateFin, Client client,
			Element element, long id) {
		this.locationDao.update(new Location(dateCreation, dateDebut, dateFin, client, element),id);

	}

	@Override
	public void deleteLocation(Location object) {
		this.locationDao.delete(object);

	}

	@Override
	public void createLocationAile(String dateCreation, String dateDebut, String dateFin, Client client, String workSpaces) {
		List<String> myList = new ArrayList<String>(Arrays.asList(workSpaces.split(",")));
		List<WorkSpace> ws=new ArrayList<>();
		for (String elm : myList){
			int id=Integer.parseInt(elm);
			ws.add(this.serviceW.getWorkSpaceById(id));
		}
		AileEtage element = new AileEtage(ws);
		this.serviceEle.creatElement(element);
		this.locationDao.create(new Location(dateCreation,dateDebut,dateFin,client,element));
	}

}
