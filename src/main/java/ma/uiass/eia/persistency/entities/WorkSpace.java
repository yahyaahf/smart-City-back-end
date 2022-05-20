package ma.uiass.eia.persistency.entities;

import java.io.Serializable;
import java.util.Collection;

import javax.persistence.Column;
import javax.persistence.DiscriminatorColumn;
import javax.persistence.Entity;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.google.gson.annotations.Expose;



@Entity
//@Table(name = "WORKSPACE")
//@Inheritance

public abstract class WorkSpace extends Element {
   //@Id
   //@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Expose
	private long numero;
	@Expose
	private int surface;
	@Expose
	private Double prix;
	@Expose
	private String position;
	@JsonIgnore
	@ManyToOne
	private Etage etage;
	@OneToMany(mappedBy = "workSpace")
	Collection<Equipement> equipements;
	
	
	public WorkSpace() {
		// TODO Auto-generated constructor stub
	}
	

	public WorkSpace(long numero , int surface, String position,Double prix) {
		super();
		this.numero = numero ;
		this.surface = surface;
		this.position = position;
		this.prix=prix;
	}


	public WorkSpace(long numero ,int surface, Etage etage, String position,Double prix) {
		super();
		this.surface = surface;
		this.numero = numero ;
		this.etage = etage;
		this.position = position;
		this.prix=prix;
	}
	public long getId() {
		return super.getId();
	}
	public void setId(long id) {
		super.setId(id);
	}

	public long getNumero() {
		return numero;
	}

	public void setNumero(long numero) {
		this.numero = numero;
	}

	public int getSurface() {
		return surface;
	}

	public void setSurface(int surface) {
		this.surface = surface;
	}

	

	public Etage getEtage() {
		return etage;
	}

	public void setEtage(Etage etage) {
		this.etage = etage;
	}

	public String getPosition() {
		return position;
	}

	public void setPosition(String position) {
		this.position = position;
	}


	public Double getPrix() {
		return prix;
	}


	public void setPrix(Double prix) {
		this.prix = prix;
	}


	public Collection<Equipement> getEquipements() {
		return equipements;
	}


	public void setEquipements(Collection<Equipement> equipements) {
		this.equipements = equipements;
	}
	
	public void addEquipement(Equipement equipement) {
		this.equipements.add(equipement);
	}

	

}
