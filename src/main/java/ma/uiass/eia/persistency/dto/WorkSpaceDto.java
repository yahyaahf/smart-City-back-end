package ma.uiass.eia.persistency.dto;

import java.time.LocalDate;

import com.google.gson.annotations.Expose;

public class WorkSpaceDto {
	@Expose
	private long id ;
	@Expose
	private  long numero;
	@Expose
	private String position;
	@Expose
	private String type ; 
	@Expose
	private int  surface;
	@Expose
	private long numeroEtage;
	@Expose
	private double prix ;
	public long getNumero() {
		return numero;
	}
	public void setNumero(long numero) {
		this.numero = numero;
	}
	public String getPosition() {
		return position;
	}
	public void setPosition(String position) {
		this.position = position;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public int getSurface() {
		return surface;
	}
	public void setSurface(int surface) {
		this.surface = surface;
	}
	public long getNumeroEtage() {
		return numeroEtage;
	}
	public void setNumeroEtage(long numeroEtage) {
		this.numeroEtage = numeroEtage;
	}
	public double getPrix() {
		return prix;
	}
	public void setPrix(double prix) {
		this.prix = prix;
	}
	
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public WorkSpaceDto(long id ,long numero, String position, String type, int surface, long numeroEtage, double prix) {
		super();
		this.numero = numero;
		this.position = position;
		this.type = type;
		this.surface = surface;
		this.numeroEtage = numeroEtage;
		this.prix = prix;
		this.id=id;
	}
	

}
