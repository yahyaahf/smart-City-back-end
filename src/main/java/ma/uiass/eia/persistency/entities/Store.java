package ma.uiass.eia.persistency.entities;

import javax.persistence.Entity;

@Entity
public class Store extends ObjetConnecte {
	public Store() {
		
	}
	public Store(String code, WorkSpace workSpace, boolean etat) {
        super(code, workSpace, etat);
    }

    @Override
    public String toString() {
        return "Store";
    }
    public long getId(){return  super.getId();}
    public void setId(long id){super.setId(id);}

}
