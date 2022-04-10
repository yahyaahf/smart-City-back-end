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

	public SalleReunion(int surface, Etage etage, String position) {
		super(surface, etage, position);
		// TODO Auto-generated constructor stub
	}

	public SalleReunion( int surface, String position) {
		super( surface, position);
		// TODO Auto-generated constructor stub
	}
	

}
