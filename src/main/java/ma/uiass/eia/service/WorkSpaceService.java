package ma.uiass.eia.service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;

import ma.uiass.eia.persistency.dao.WorkSpaceDaoImp;
import ma.uiass.eia.persistency.dto.WorkSpaceDto;
import ma.uiass.eia.persistency.entities.BureauFerme;
import ma.uiass.eia.persistency.entities.CapteurHumidite;
import ma.uiass.eia.persistency.entities.CapteurPresence;
import ma.uiass.eia.persistency.entities.CapteurTemperature;
import ma.uiass.eia.persistency.entities.Equipement;
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
			WorkSpaceDto wDto=new WorkSpaceDto(workSpace.getId(),workSpace.getNumero(),workSpace.getPosition(),workSpace.toString(),workSpace.getSurface(),workSpace.getEtage().getNumEtage(),workSpace.getPrix());
			list.add(wDto);
		}		
		return list ;
	}

	@Override
	public WorkSpaceDto getWorkSpaceByIdDto(long numero) {
		WorkSpace work= this.workSpaceDao.getById(numero);
		WorkSpaceDto wDto=new WorkSpaceDto(work.getId(), work.getNumero(), work.getPosition(),work.toString(),work.getSurface(),work.getEtage().getNumEtage(),work.getPrix());
		
		return wDto;
	}

	@Override
	public void createWorkSpace(long numero ,int surface, String type, Etage etage, String position,Double prix) {
		int num =1;
		if (etage.getWorkSpaces()!=null) num=etage.getWorkSpaces().size()+1 ;

		if (type.equals("BF")) {
			this.workSpaceDao.create(new BureauFerme( num , surface, etage, position,prix));
			
		}
		else if(type.equals("SR")) {
			this.workSpaceDao.create(new SalleReunion(num ,surface, etage, position,prix));
		}
		else this.workSpaceDao.create(new EspaceIndividuel(num ,surface, etage, position,prix));
		

	}

	@Override
	public void updateWorkSpace(long numero ,int surface, String type, String position,Double prix,long id) {
		
		
		
		if (type.equals("BF")) {
			this.workSpaceDao.update(new BureauFerme(numero ,surface,  position,prix),id);
		}
		else if(type.equals("SR")) {
			this.workSpaceDao.update(new SalleReunion(numero ,surface,  position,prix),id);
		}
		this.workSpaceDao.update(new EspaceIndividuel(numero ,surface, position,prix),id);
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
			if(workSpace.getEtage().getId()==idEtage) {
				WorkSpaceDto wDto = new WorkSpaceDto(workSpace.getId(), workSpace.getNumero(), workSpace.getPosition(), workSpace.toString(), workSpace.getSurface(), workSpace.getEtage().getEtageNum(), workSpace.getPrix());
				list.add(wDto);
			}
		}		
		return list ;
	}
	@Override
	public WorkSpace getWorkSpaceById(long numero) {
		
		return this.workSpaceDao.getById(numero);
	}

}
