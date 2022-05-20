package ma.uiass.eia.persistency.entities;

import javax.persistence.Entity;

@Entity
public class CapteurTemperature extends Capteur {
    public CapteurTemperature() {
    }

    public CapteurTemperature(String code, WorkSpace workSpace, boolean etat) {
        super(code, workSpace, etat);
    }
    public long getId(){return  super.getId();}
    public void setId(long id){super.setId(id);}
    @Override
    public String toString() {
        return "CapteurTemperature";
    }
}
