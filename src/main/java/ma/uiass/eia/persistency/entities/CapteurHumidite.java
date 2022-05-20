package ma.uiass.eia.persistency.entities;

import javax.persistence.Entity;

@Entity
public class CapteurHumidite extends Capteur {
    public CapteurHumidite() {
    }

    public CapteurHumidite(String code, WorkSpace workSpace, boolean etat) {
        super(code, workSpace, etat);
    }

    @Override
    public String toString() {
        return "CapteurHumidite";
    }
    public long getId(){return  super.getId();}
    public void setId(long id){super.setId(id);}
}
