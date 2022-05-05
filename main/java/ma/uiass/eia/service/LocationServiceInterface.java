package ma.uiass.eia.service;

import java.time.LocalDate;
import java.util.List;

import ma.uiass.eia.persistency.entities.Client;

import ma.uiass.eia.persistency.entities.Location;
import ma.uiass.eia.persistency.entities.WorkSpace;


public interface LocationServiceInterface {
	
	List<Location> getAllLocations();

	Location getLocationeById(long numero);

	void createLocation(LocalDate dateCreation, LocalDate dateDebut, LocalDate dateFin, Client client,
			WorkSpace workSpace);

	void updateLocation(LocalDate dateCreation, LocalDate dateDebut, LocalDate dateFin, Client client,
			WorkSpace workSpace,long id);

	void deleteLocation(Location object);

}


