package ma.uiass.eia.service;

import java.util.ArrayList;
import java.util.List;

import ma.uiass.eia.persistency.dao.WorkSpaceDaoImp;
import ma.uiass.eia.persistency.dto.WorkSpaceDto;
import ma.uiass.eia.persistency.entities.BureauFerme;
import ma.uiass.eia.persistency.entities.EspaceIndividuel;
import ma.uiass.eia.persistency.entities.Etage;
import ma.uiass.eia.persistency.entities.SalleReunion;

import ma.uiass.eia.persistency.entities.WorkSpace;

public class WorkSpaceService implements WorkSpaceServiceInterface {
	WorkSpaceDaoImp workSpaceDao ;
	public WorkSpaceService() {
		this.workSpaceDao=new WorkSpaceDaoImp();
	}
	@Override
	public List<WorkSpaceDto> getAllWorkSpaces() {
		List<WorkSpaceDto> list = new ArrayList<WorkSpaceDto>();
		List<WorkSpace> l= this.workSpaceDao.getAll();
		for (WorkSpace workSpace : l) {
			WorkSpaceDto wDto=new WorkSpaceDto(workSpace.getNumero(),workSpace.getPosition(),workSpace.toString(),workSpace.getSurface(),workSpace.getEtage().getNumEtage(),workSpace.getPrix());
			list.add(wDto);
		}		
		return list ;
	}

	@Override
	public WorkSpaceDto getWorkSpaceById(long numero) {
		WorkSpace work= this.workSpaceDao.getById(numero);
		WorkSpaceDto wDto=new WorkSpaceDto(work.getNumero(), work.getPosition(),work.toString(),work.getSurface(),work.getEtage().getNumEtage(),work.getPrix());
		
		return wDto;
	}

	@Override
	public void createWorkSpace(int surface, String type, Etage etage, String position,Double prix) {
		if (type.equals("BF")) {
			this.workSpaceDao.create(new BureauFerme(surface, etage, position,prix));
			
		}
		else if(type.equals("SR")) {
			this.workSpaceDao.create(new SalleReunion(surface, etage, position,prix));
		}
		else this.workSpaceDao.create(new EspaceIndividuel(surface, etage, position,prix));
		

	}

	@Override
	public void updateWorkSpace(int surface, String type, String position,Double prix,long id) {
		
		if (type.equals("BF")) {
			this.workSpaceDao.update(new BureauFerme(surface,  position,prix),id);
		}
		else if(type.equals("SR")) {
			this.workSpaceDao.update(new SalleReunion(surface,  position,prix),id);
		}
		this.workSpaceDao.update(new EspaceIndividuel(surface, position,prix),id);
	}

	@Override
	public void deleteWorkSpace(WorkSpace object) {
		this.workSpaceDao.delete(object);

	}
	@Override
	public List<WorkSpaceDto> getAllWorkSpacesByEtage(long idEtage) {
		List<WorkSpaceDto> list = new ArrayList<WorkSpaceDto>();
		List<WorkSpace> l= this.workSpaceDao.getAll();
		for (WorkSpace workSpace : l) {
			WorkSpaceDto wDto=new WorkSpaceDto(workSpace.getNumero(),workSpace.getPosition(),workSpace.toString(),workSpace.getSurface(),workSpace.getEtage().getNumEtage(),workSpace.getPrix());
			list.add(wDto);
		}		
		return list ;
	}

}
