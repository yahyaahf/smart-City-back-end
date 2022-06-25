package ma.uiass.eia.service;



import ma.uiass.eia.persistency.dto.EquipementDto;
import ma.uiass.eia.persistency.entities.Equipement;
import ma.uiass.eia.persistency.entities.WorkSpace;

import java.util.List;

public interface EquipementServiceInterface {
    List<EquipementDto> getAllEquipements();

    Equipement getEquipementById(long id);

    void createEquipement(String code, WorkSpace workSpace, boolean etat,String type,int numEquipement);
}
