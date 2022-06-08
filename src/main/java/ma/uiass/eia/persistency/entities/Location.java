package ma.uiass.eia.persistency.entities;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;


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
	@Expose
	private double montant ;
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
		this.setMontant(calculerMontant(dateDebut,dateFin,element.getPrice()));

	}


	public double getMontant() {
		return montant;
	}

	public void setMontant(double montant) {
		this.montant = montant;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public static double calculerMontant(String dadu,String dafi,double prix){
		DateTimeFormatter JEFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
		LocalDate dd=LocalDate.parse(dadu, JEFormatter);
		LocalDate df=LocalDate.parse(dafi, JEFormatter);

		//return this.element.getPrice()* ChronoUnit.DAYS.between(dd,df);
		return  (double)(prix*ChronoUnit.DAYS.between(dd,df));
	}
}
