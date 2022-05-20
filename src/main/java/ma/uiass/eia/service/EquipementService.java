package ma.uiass.eia.service;

import ma.uiass.eia.persistency.dao.EquipementDaoImp;
import ma.uiass.eia.persistency.dto.EquipementDto;
import ma.uiass.eia.persistency.entities.*;

import java.util.ArrayList;
import java.util.List;

public class EquipementService implements EquipementServiceInterface{
    EquipementDaoImp equipementDao;
    public EquipementService(){
        this.equipementDao=new EquipementDaoImp();
    }
    @Override
    public List<EquipementDto> getAllEquipements() {
        List<Equipement> equipements=  this.equipementDao.getAll();
        List<EquipementDto> equipementDtos=new ArrayList<EquipementDto>();
        for(Equipement elm : equipements){
            equipementDtos.add(new EquipementDto(elm.getId(), elm.getCode(), elm.toString(), elm.getEtat(), elm.getWorkSpace()));
        }
        return equipementDtos;
    }

    @Override
    public Equipement getEquipementById(long id) {
        return this.equipementDao.getById(id);
    }

    @Override
    public void createEquipement(String code, WorkSpace workSpace, boolean etat, String type) {
        if(type.equalsIgnoreCase("OC")) this.equipementDao.create(new ObjetConnecte(code,workSpace,etat));
        else if (type.equalsIgnoreCase("CH"))  this.equipementDao.create(new CapteurHumidite(code,workSpace,etat));
        else if (type.equalsIgnoreCase("CP")) this.equipementDao.create(new CapteurPresence(code,workSpace,etat));
        else if(type.equalsIgnoreCase("CT")) this.equipementDao.create(new CapteurTemperature(code,workSpace,etat));

        }


    }

