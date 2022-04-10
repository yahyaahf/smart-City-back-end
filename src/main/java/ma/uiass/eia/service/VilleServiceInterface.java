package ma.uiass.eia.service;

import java.util.List;

import ma.uiass.eia.persistency.entities.Ville;

public interface VilleServiceInterface {
	
	List<Ville> getAllVilles();

	Ville getVilleById(long numero);

	void createVille(String intitule,double latitude,double longitude);

	void updateVille(String nom,double latitude,double longitude,long id);

	void deleteVille(Ville object);


	}
