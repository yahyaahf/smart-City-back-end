package ma.uiass.eia.persistency.entities;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue("BureauFerme")

public class BureauFerme extends WorkSpace {

	public BureauFerme() {
		super();
		// TODO Auto-generated constructor stub
	}

	public BureauFerme(int surface, Etage etage, String position) {
		super(surface, etage, position);
		// TODO Auto-generated constructor stub
	}

	public BureauFerme( int surface, String position) {
		super( surface, position);
		// TODO Auto-generated constructor stub
	}
	
	

}
