package ma.uiass.eia.persistency.entities;

import java.io.Serializable;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;


@Entity

public class ClientEntreprise  extends Client implements Serializable{
	
	private String formeJuridique;
    private String patente;
    
   
    public ClientEntreprise() {

    }

    public ClientEntreprise(String email, String telephone, String adress, String formeJuridique, String patente) {
        super(email, telephone, adress);
        this.formeJuridique = formeJuridique;
        this.patente = patente;
    }

	public String getFormeJuridique() {
		return formeJuridique;
	}

	public void setFormeJuridique(String formeJuridique) {
		this.formeJuridique = formeJuridique;
	}

	public String getPatente() {
		return patente;
	}

	public void setPatente(String patente) {
		this.patente = patente;
	}

	@Override
	public String toString() {
		return "ClientEntreprise [formeJuridique=" + formeJuridique + ", patente=" + patente + ", toString()="
				+ super.toString() + "]";
	}
    
    
}
