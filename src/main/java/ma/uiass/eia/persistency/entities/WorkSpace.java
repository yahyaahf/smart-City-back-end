package ma.uiass.eia.persistency.entities;

import java.io.Serializable;

import javax.persistence.DiscriminatorColumn;
import javax.persistence.Entity;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import com.fasterxml.jackson.annotation.JsonIgnore;



@Entity
@Table(name = "WORKSPACE")
@Inheritance(strategy =InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "WS_TYPE")


public abstract class WorkSpace implements Serializable {
   @Id
   @GeneratedValue(strategy=GenerationType.IDENTITY)
   @JsonIgnore
	private long numero;
	
	private int surface;

	
	private String position;
	
	@ManyToOne
	@JsonIgnore
	private Etage etage;
	
	
	public WorkSpace() {
		// TODO Auto-generated constructor stub
	}
	

	public WorkSpace( int surface, String position) {
		super();
		
		this.surface = surface;
		this.position = position;
	}


	public WorkSpace(int surface, Etage etage, String position) {
		super();
		this.surface = surface;
		
		this.etage = etage;
		this.position = position;
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

	

}
