package ma.uiass.eia.persistency.entities;

import java.io.Serializable;
import java.time.LocalDate;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

@Entity
@Table(name = "LOCATION")
public class Location implements Serializable {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private long id;
    @JsonDeserialize(using = DateHandler.class)
    private LocalDate dateCreation;
    @JsonDeserialize(using = DateHandler.class)
    private LocalDate dateDebut;
    @JsonDeserialize(using = DateHandler.class)
    private LocalDate dateFin ;
    @ManyToOne
    private Client client ;
    @OneToOne
    private WorkSpace workSpace ;
    
    public Location() {
    	
    }

    
	public LocalDate getDateCreation() {
		return dateCreation;
	}


	public void setDateCreation(LocalDate dateCreation) {
		this.dateCreation = dateCreation;
	}


	public WorkSpace getWorkSpace() {
		return workSpace;
	}


	public void setWorkSpace(WorkSpace workSpace) {
		this.workSpace = workSpace;
	}


	public Client getClient() {
		return client;
	}



	public void setClient(Client client) {
		this.client = client;
	}



	public LocalDate getDateDebut() {
		return dateDebut;
	}



	public void setDateDebut(LocalDate dateDebut) {
		this.dateDebut = dateDebut;
	}



	public LocalDate getDateFin() {
		return dateFin;
	}



	public void setDateFin(LocalDate dateFin) {
		this.dateFin = dateFin;
	}


	public Location(LocalDate dateCreation, LocalDate dateDebut, LocalDate dateFin, Client client,
			WorkSpace workSpace) {
		
		this.dateCreation = dateCreation;
		this.dateDebut = dateDebut;
		this.dateFin = dateFin;
		this.client = client;
		this.workSpace = workSpace;
	}


	public Location(LocalDate dateDebut, LocalDate dateFin, Client client) {
		super();
		this.dateDebut = dateDebut;
		this.dateFin = dateFin;
		this.client = client;
	}
	
	


    
}
