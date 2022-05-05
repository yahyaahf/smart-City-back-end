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

	public EspaceIndividuel(int surface, Etage etage, String position,Double prix) {
		super(surface, etage, position,prix);
		// TODO Auto-generated constructor stub
	}

	public EspaceIndividuel( int surface, String position,Double prix) {
		super( surface, position,prix);
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString() {
		return "EspaceIndividuel";
	}
	
	

}
