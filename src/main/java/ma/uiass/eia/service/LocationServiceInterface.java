package ma.uiass.eia.service;

import java.time.LocalDate;
import java.util.List;

import ma.uiass.eia.persistency.entities.Client;
import ma.uiass.eia.persistency.entities.Element;
import ma.uiass.eia.persistency.entities.Location;
import ma.uiass.eia.persistency.entities.WorkSpace;


public interface LocationServiceInterface {
	
	List<Location> getAllLocations();

	Location getLocationeById(long numero);

	void createLocation(String dateCreation, String dateDebut, String dateFin, Client client,
			Element element);

	void updateLocation(String dateCreation, String dateDebut, String dateFin, Client client,
			Element element,long id);

	void deleteLocation(Location object);

	void createLocationAile(String dateCreation, String dateDebut, String dateFin, Client client,
						String workSpaces);

}


