package ma.uiass.eia.service;

import ma.uiass.eia.persistency.dao.ElementDaoImp;
import ma.uiass.eia.persistency.dao.VilleDaoImp;
import ma.uiass.eia.persistency.entities.Element;
import ma.uiass.eia.persistency.entities.Ville;

public class ElementService {
	private ElementDaoImp elementDao;
	 
	public ElementService() {
		this.elementDao=new ElementDaoImp();
	}
	
	public Element getElementById(long id) {
		
		return this.elementDao.getById(id);
		}

}
