package ma.uiass.eia.service;

import java.util.List;

import ma.uiass.eia.persistency.dao.WorkSpaceDaoImp;
import ma.uiass.eia.persistency.dto.WorkSpaceDto;
import ma.uiass.eia.persistency.entities.Etage;

import ma.uiass.eia.persistency.entities.WorkSpace;

public interface WorkSpaceServiceInterface {
	
	List<WorkSpaceDto> getAllWorkSpacesByEtage(long id);
	
	List<WorkSpaceDto> getAllWorkSpaces();

	WorkSpaceDto getWorkSpaceByIdDto(long numero);
	
	WorkSpace getWorkSpaceById(long numero);

	void createWorkSpace(long numero ,int surface, String type, Etage etage, String position,Double prix);

	void updateWorkSpace(long numero ,int surface, String type, String position,Double prix,String equipements,long id);

	void deleteWorkSpace(WorkSpace object);

}
