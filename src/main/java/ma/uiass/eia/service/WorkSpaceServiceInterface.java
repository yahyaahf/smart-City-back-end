package ma.uiass.eia.service;

import java.util.List;

import ma.uiass.eia.persistency.entities.Etage;

import ma.uiass.eia.persistency.entities.WorkSpace;

public interface WorkSpaceServiceInterface {
	
	List<WorkSpace> getAllWorkSpacesByEtage(long id);
	
	List<WorkSpace> getAllWorkSpaces();

	WorkSpace getWorkSpaceById(long numero);

	void createWorkSpace(int surface, String type, Etage etage, String position);

	void updateWorkSpace(int surface, String type, String position,long id);

	void deleteWorkSpace(WorkSpace object);

}
