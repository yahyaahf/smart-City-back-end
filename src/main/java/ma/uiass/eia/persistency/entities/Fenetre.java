package ma.uiass.eia.persistency.entities;

import javax.persistence.Entity;

@Entity
public class Fenetre extends ObjetConnecte {
	public Fenetre() {
		
	}
	public Fenetre(String code, WorkSpace workSpace, boolean etat) {
        super(code, workSpace, etat);
    }
    @Override
    public String toString() {
        return "Fenetre";
    }
    public long getId(){return  super.getId();}
    public void setId(long id){super.setId(id);}

}
