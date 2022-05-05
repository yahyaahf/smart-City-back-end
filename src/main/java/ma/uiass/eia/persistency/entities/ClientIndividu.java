package ma.uiass.eia.persistency.entities;

import java.io.Serializable;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;


@Entity

public class ClientIndividu extends Client implements Serializable {
	
	private String nom,prenom;
	
	private String sexe;
	
	public ClientIndividu() {
	}

	public ClientIndividu(String email, String telephone, String adress, String nom, String prenom,String sexe) {
		super(email, telephone, adress);
		this.nom = nom;
		this.prenom = prenom;
		this.sexe=sexe;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getPrenom() {
		return prenom;
	}

	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}

	@Override
	public String toString() {
		return "ClientIndividu [nom=" + nom + ", prenom=" + prenom + ", sexe=" + sexe + ", toString()="
				+ super.toString() + "]";
	}
	
	
}


