package ma.uiass.eia.service;

import java.util.List;

import ma.uiass.eia.persistency.dao.WorkSpaceDaoImp;
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
	public List<WorkSpace> getAllWorkSpaces() {
		
		return this.workSpaceDao.getAll();
	}

	@Override
	public WorkSpace getWorkSpaceById(long numero) {
		
		return this.workSpaceDao.getById(numero);
	}

	@Override
	public void createWorkSpace(int surface, String type, Etage etage, String position) {
		if (type.equals("BF")) {
			this.workSpaceDao.create(new BureauFerme(surface, etage, position));
			
		}
		else if(type.equals("SR")) {
			this.workSpaceDao.create(new SalleReunion(surface, etage, position));
		}
		else this.workSpaceDao.create(new EspaceIndividuel(surface, etage, position));
		

	}

	@Override
	public void updateWorkSpace(int surface, String type, String position,long id) {
		
		if (type.equals("BF")) {
			this.workSpaceDao.update(new BureauFerme(surface,  position),id);
		}
		else if(type.equals("SR")) {
			this.workSpaceDao.update(new SalleReunion(surface,  position),id);
		}
		this.workSpaceDao.update(new EspaceIndividuel(surface, position),id);
	}

	@Override
	public void deleteWorkSpace(WorkSpace object) {
		this.workSpaceDao.delete(object);

	}
	@Override
	public List<WorkSpace> getAllWorkSpacesByEtage(long idEtage) {
		
		return this.getAllWorkSpacesByEtage(idEtage);
	}

}
