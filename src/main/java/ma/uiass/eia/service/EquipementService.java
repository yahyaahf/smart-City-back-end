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
    public void createEquipement(String code, WorkSpace workSpace, boolean etat, String type,int numEquipement) {
        if(type.equalsIgnoreCase("OC")) {
        	for(int i=0;i<numEquipement;i++) { this.equipementDao.create(new ObjetConnecte(code,workSpace,etat));
        }}
        else if (type.equalsIgnoreCase("CH")) {
        	for(int i=0;i<numEquipement;i++) {this.equipementDao.create(new CapteurHumidite(code,workSpace,etat));
        }}
        else if (type.equalsIgnoreCase("CP")) {
        	for(int i=0;i<numEquipement;i++) {this.equipementDao.create(new CapteurPresence(code,workSpace,etat));
        }}
        else if(type.equalsIgnoreCase("CT")) {
        	for(int i=0;i<numEquipement;i++) {this.equipementDao.create(new CapteurTemperature(code,workSpace,etat));
        }}

        }


    }

