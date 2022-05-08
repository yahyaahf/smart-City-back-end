package ma.uiass.eia.persistency.entities;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.google.gson.annotations.Expose;
@Entity
@Table(name="EMPLOYEE")
public class Employee implements Serializable{
	  @Id
	  @GeneratedValue(strategy= GenerationType.IDENTITY)
	  @Expose
	  private long id;
	  @Expose
	  private String nom , prenom ;
	  @Expose
	  private String email;
	  @Expose
	  private String sexe;
	  @Expose
	  private String thelephone ;
	  @Expose
	  private String adress;
	  @ManyToOne
	  private ClientEntreprise entreprise;


	    public long getId() {
	        return id;
	    }

	    public String getNom() {
	        return nom;
	    }

	    public String getPrenom() {
	        return prenom;
	    }

	    public String getEmail() {
	        return email;
	    }

	    public String getSexe() {
	        return sexe;
	    }

	    public String getThelephone() {
	        return thelephone;
	    }

	    public String getAdress() {
	        return adress;
	    }



	    public void setNumero(long id) {
	        this.id = id;
	    }

	    public void setNom(String nom) {
	        this.nom = nom;
	    }

	    public void setPrenom(String prenom) {
	        this.prenom = prenom;
	    }

	    public void setEmail(String email) {
	        this.email = email;
	    }

	    public void setSexe(String sexe) {
	        this.sexe = sexe;
	    }

	    public void setThelephone(String thelephone) {
	        this.thelephone = thelephone;
	    }

	    public void setAdress(String adress) {
	        this.adress = adress;
	    }


	    public Employee() {
	    }

	    public Employee(String nom, String prenom, String email, String sexe, String thelephone, String adress,ClientEntreprise entreprise) {
	        this.nom = nom;
	        this.prenom = prenom;
	        this.email = email;
	        this.sexe = sexe;
	        this.thelephone = thelephone;
	        this.adress = adress;
	        this.entreprise=entreprise;

	    }

}
