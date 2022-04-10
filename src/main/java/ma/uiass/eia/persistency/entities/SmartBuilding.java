package ma.uiass.eia.persistency.entities;

import java.io.Serializable;
import java.util.Collection;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name="SMARTBUILDING")
public class SmartBuilding implements Serializable{

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private long numero;
	
	private int nombreEtages;
	
	private String adress;
	
	@Column(name="SURFACE")
	private int surface;
	
	private double longitude;
	private double latitude;
	
	@ManyToOne
	private Ville ville;
	
	@OneToMany(mappedBy="building")
	@JsonIgnore
	private  Collection<Etage> etages;
	
	public SmartBuilding() {
		
	}

	public long getNumero() {
		return numero;
	}

	public void setNumero(long numero) {
		this.numero = numero;
	}

	public int getNombreEtages() {
		return nombreEtages;
	}

	public void setNombreEtages(int nombreEtages) {
		this.nombreEtages = nombreEtages;
	}

	public Ville getVille() {
		return ville;
	}

	public void setVille(Ville ville) {
		this.ville = ville;
	}


	public int getSurface() {
		return surface;
	}

	public void setSurface(int surface) {
		this.surface = surface;
	}

	public double getLongitude() {
		return longitude;
	}

	public void setLongitude(double longitude) {
		this.longitude = longitude;
	}

	public double getLatitude() {
		return latitude;
	}

	public void setLatitude(double latitude) {
		this.latitude = latitude;
	}

	public SmartBuilding(int nombreEtages, int surface, double longitude, double latitude,String adress) {
		super();
		this.nombreEtages = nombreEtages;
		this.surface = surface;
		this.longitude = longitude;
		this.latitude = latitude;
		this.adress=adress;
	}

	public String getAdress() {
		return adress;
	}

	public void setAdress(String adress) {
		this.adress = adress;
	}
	

	public Collection<Etage> getEtages() {
		return etages;
	}

	public void setEtages(Collection<Etage> etages) {
		this.etages = etages;
	}

	public SmartBuilding(int nombreEtages, String adress, int surface, double longitude, double latitude,
			Ville ville) {
		super();
		this.nombreEtages = nombreEtages;
		this.adress = adress;
		this.surface = surface;
		this.longitude = longitude;
		this.latitude = latitude;
		this.ville = ville;
		
	}
	

	

}
