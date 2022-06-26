package ma.uiass.eia.persistency.entities;

import javax.persistence.Entity;

@Entity
public class Vitre extends ObjetConnecte {
	public Vitre() {
		
	}
	public Vitre(String code, WorkSpace workSpace, boolean etat) {
        super(code, workSpace, etat);
    }

    @Override
    public String toString() {
        return "Vitre";
    }
    public long getId(){return  super.getId();}
    public void setId(long id){super.setId(id);}

}
