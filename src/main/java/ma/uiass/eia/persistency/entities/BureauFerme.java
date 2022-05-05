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

	public BureauFerme(int surface, Etage etage, String position,Double prix) {
		super(surface, etage, position,prix);
		// TODO Auto-generated constructor stub
	}

	public BureauFerme( int surface, String position,Double prix) {
		super( surface, position,prix);
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString() {
		return "BureauFerme";
	}
	
	

}
