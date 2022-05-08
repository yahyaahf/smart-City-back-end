package ma.uiass.eia.persistency.entities;

import javax.persistence.Entity;

@Entity
//@DiscriminatorValue("EspaceIndividuel")

public class EspaceIndividuel extends WorkSpace {

	public EspaceIndividuel() {
		super();
		// TODO Auto-generated constructor stub
	}

	public EspaceIndividuel(long numero,int surface, Etage etage, String position,Double prix) {
		super(numero  ,surface, etage, position,prix);
		// TODO Auto-generated constructor stub
	}

	public EspaceIndividuel(long numero , int surface, String position,Double prix) {
		super(numero , surface, position,prix);
		// TODO Auto-generated constructor stub
	}
	public long getId() {
		return super.getId();
	}
	public void setId(long id) {
		super.setId(id);
	}
	@Override
	public String toString() {
		return "EspaceIndividuel";
	}
	
	

}
