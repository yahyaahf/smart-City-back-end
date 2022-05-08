package ma.uiass.eia.persistency.entities;

import java.util.Collection;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.google.gson.annotations.Expose;

@Entity
@Table(name="ETAGE")
public class Etage extends Element {
	
	//@Id
	//@GeneratedValue(strategy=GenerationType.IDENTITY)
	//private long numEtage;
	@Expose
	private int etageNum;
	@Expose
	private double surface;
	
	
	@OneToMany(mappedBy="etage")
	@JsonIgnore
	private Collection<WorkSpace> workSpaces;
	
	@JsonIgnore
	@ManyToOne
	private SmartBuilding building;
	
	public Etage() {
		
	}
	public Etage(int etageNum, double surface) {
		super();
		this.etageNum = etageNum;
		this.surface = surface;
		
	}
	public Etage(int etageNum, double surface,SmartBuilding building) {
		super();
		this.etageNum = etageNum;
		this.surface = surface;
		this.building=building;
		
	}
	public Etage(int etageNum, double surface, List<WorkSpace> workSpaces, SmartBuilding building) {
		super();
		this.etageNum = etageNum;
		this.surface = surface;
		this.workSpaces = workSpaces;
		this.building = building;
	}


	public long getNumEtage() {
		return super.getId();
	}


	public void setNumEtage(long numEtage) {
		super.setId(numEtage);;
	}


	public double getSurface() {
		return surface;
	}


	public void setSurface(double surface) {
		this.surface = surface;
	}


	public Collection<WorkSpace> getWorkSpaces() {
		return workSpaces;
	}


	public void setWorkSpaces(Collection<WorkSpace> workSpaces) {
		this.workSpaces = workSpaces;
	}


	public SmartBuilding getSmartBuilding() {
		return building;
	}


	public void setSmartBuilding(SmartBuilding smartBuilding) {
		this.building = smartBuilding;
	}
	public SmartBuilding getBuilding() {
		return building;
	}
	public void setBuilding(SmartBuilding building) {
		this.building = building;
	}
	public int getEtageNum() {
		return etageNum;
	}
	public void setEtageNum(int etageNum) {
		this.etageNum = etageNum;
	}
	
	

}
