package ma.uiass.eia.persistency.entities;

import javax.persistence.Entity;

@Entity
public class CapteurPresence extends Capteur {
    public CapteurPresence() {
    }

    public CapteurPresence(String code, WorkSpace workSpace, boolean etat) {
        super(code, workSpace, etat);
    }
    public long getId(){return  super.getId();}
    public void setId(long id){super.setId(id);}
    @Override
    public String toString() {
        return "CapteurPresence";
    }
}
