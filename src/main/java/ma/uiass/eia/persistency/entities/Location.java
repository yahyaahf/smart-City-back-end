package ma.uiass.eia.persistency.entities;

import java.io.Serializable;


import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.google.gson.annotations.Expose;


@Entity
@Table(name = "LOCATION")
public class Location implements Serializable {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Expose
    private long id;
    @Expose
    private String dateCreation;
    @Expose
    private String dateDebut;
    @Expose
    private String dateFin ;
    @ManyToOne
    @JsonIgnore
    private Client client ;
    @OneToOne
    @JsonIgnore
    private Element element ;
    
    public Location() {
    	
    }

    
	public String getDateCreation() {
		return dateCreation;
	}


	public void setDateCreation(String dateCreation) {
		this.dateCreation = dateCreation;
	}


	public Element getElement() {
		return element;
	}


	public void setElement(Element element) {
		this.element = element;
	}


	public Client getClient() {
		return client;
	}



	public void setClient(Client client) {
		this.client = client;
	}



	public String getDateDebut() {
		return dateDebut;
	}



	public void setDateDebut(String dateDebut) {
		this.dateDebut = dateDebut;
	}



	public String getDateFin() {
		return dateFin;
	}



	public void setDateFin(String dateFin) {
		this.dateFin = dateFin;
	}


	public Location(String dateCreation, String dateDebut, String dateFin, Client client,
			Element element) {
		
		this.dateCreation = dateCreation;
		this.dateDebut = dateDebut;
		this.dateFin = dateFin;
		this.client = client;
		this.element = element;
	}


	
	
	


    
}
