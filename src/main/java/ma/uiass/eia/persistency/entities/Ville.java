package ma.uiass.eia.persistency.entities;

import java.io.Serializable;
import java.util.Collection;

import javax.persistence.Basic;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.google.gson.annotations.Expose;

@Entity
@Table(name="VILLE")  

public class Ville implements Serializable{
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Expose
	private long numero;
    @Expose
	private String nom;
    @Expose
	private double latitude;
    @Expose
	private double longitude;
	
	@OneToMany(mappedBy="ville")
	@JsonIgnore
	private Collection<SmartBuilding> buildings;
	
	public Ville() {
		
	}


	public Collection<SmartBuilding> getBuildings() {
		return this.buildings;
	}


	public void setBuildings(Collection<SmartBuilding> buildings) {
		this.buildings = buildings;
	}


	public Ville(String nom, double latitude, double longitude) {
		super();
		this.nom = nom;
		this.latitude = latitude;
		this.longitude = longitude;
	}


	public long getNumero() {
		return numero;
	}


	public void setNumero(long numero) {
		this.numero = numero;
	}


	public String getNom() {
		return nom;
	}


	public void setNom(String nom) {
		this.nom = nom;
	}


	public double getLatitude() {
		return latitude;
	}


	public void setLatitude(double latitude) {
		this.latitude = latitude;
	}


	public double getLongitude() {
		return longitude;
	}


	public void setLongitude(double longitude) {
		this.longitude = longitude;
	}
    public String toString() {
    	   return this.getNom()+" "+this.getLatitude()+" "+this.getLongitude();
       }


	


	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Ville other = (Ville) obj;
		if (buildings == null) {
			if (other.buildings != null)
				return false;
		} else if (!buildings.equals(other.buildings))
			return false;
		if (Double.doubleToLongBits(latitude) != Double.doubleToLongBits(other.latitude))
			return false;
		if (Double.doubleToLongBits(longitude) != Double.doubleToLongBits(other.longitude))
			return false;
		if (nom == null) {
			if (other.nom != null)
				return false;
		} else if (!nom.equals(other.nom))
			return false;
		if (numero != other.numero)
			return false;
		return true;
	}


	
	
    
}
