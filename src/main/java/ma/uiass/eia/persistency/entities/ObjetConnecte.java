package ma.uiass.eia.persistency.entities;

import javax.persistence.Entity;

@Entity
public  class ObjetConnecte extends Equipement {
	

	public ObjetConnecte() {
		
	}
	
	
	
	public ObjetConnecte(String code, WorkSpace workSpace,boolean etat) {
		super(code, workSpace,etat);
		// TODO Auto-generated constructor stub
		
	}

	public long getId(){return  super.getId();}
	public void setId(long id){super.setId(id);}
	
	
	

}
