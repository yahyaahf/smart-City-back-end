package ma.uiass.eia.persistency.entities;

import javax.persistence.DiscriminatorValue;

import org.hibernate.annotations.Entity;

@Entity
@DiscriminatorValue("EspaceIndividuel")

public class EspaceIndividuel extends WorkSpace {

	public EspaceIndividuel() {
		super();
		// TODO Auto-generated constructor stub
	}

	public EspaceIndividuel(int surface, Etage etage, String position) {
		super(surface, etage, position);
		// TODO Auto-generated constructor stub
	}

	public EspaceIndividuel( int surface, String position) {
		super( surface, position);
		// TODO Auto-generated constructor stub
	}
	
	

}
