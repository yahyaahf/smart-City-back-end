package ma.uiass.eia.persistency.entities;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.ManyToOne;

import com.google.gson.annotations.Expose;

@Entity
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
public abstract class Equipement implements Serializable {
	@Id
    @GeneratedValue(strategy=GenerationType.TABLE)
    @Expose
	private long id;
	@Expose
	private String code ;
	@Expose
	private static double cout ;
	@Expose
	private boolean etat ;
	@ManyToOne
	WorkSpace workSpace;
	
	

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public static double getCout() {
		return cout;
	}

	public static void setCout(double cout) {
		Equipement.cout = cout;
	}

	public WorkSpace getWorkSpace() {
		return workSpace;
	}

	public void setWorkSpace(WorkSpace workSpace) {
		this.workSpace = workSpace;
	}

	public boolean getEtat() {
		return etat;
	}

	public void setEtat(boolean etat) {
		this.etat = etat;
	}

	public Equipement(String code, WorkSpace workSpace,boolean etat) {
		super();
		this.code = code;
		this.workSpace = workSpace;
		this.etat = etat;
	}

	public Equipement() {

	}


	
	
	
	
	

}
