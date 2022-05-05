package ma.uiass.eia.persistency.entities;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue("SalleReunion")

public class SalleReunion extends WorkSpace {

	public SalleReunion() {
		super();
		// TODO Auto-generated constructor stub
	}

	public SalleReunion(int surface, Etage etage, String position,Double prix) {
		super(surface, etage, position,prix);
		// TODO Auto-generated constructor stub
	}

	public SalleReunion( int surface, String position,Double prix) {
		super( surface, position,prix);
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString() {
		return "SalleReunion";
	}
	
	

}
