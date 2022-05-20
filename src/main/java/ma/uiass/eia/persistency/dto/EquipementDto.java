package ma.uiass.eia.persistency.dto;

import com.google.gson.annotations.Expose;
import ma.uiass.eia.persistency.entities.WorkSpace;

public class EquipementDto {
    @Expose
    private long id ;
    @Expose
    private  String code,type;
    @Expose
    private boolean etat;

    private WorkSpace workspace;

    public EquipementDto(long id, String code, String type, boolean etat, WorkSpace workspace) {
        this.id = id;
        this.code = code;
        this.type = type;
        this.etat = etat;
        this.workspace = workspace;
    }
}
