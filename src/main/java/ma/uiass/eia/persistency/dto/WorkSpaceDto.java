package ma.uiass.eia.persistency.dto;

import java.time.LocalDate;

public class WorkSpaceDto {
	private  long numero;
	private String position;
	private String type ; 
	private int  surface;
	private long numeroEtage;
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
	public WorkSpaceDto(long numero, String position, String type, int surface, long numeroEtage, double prix) {
		super();
		this.numero = numero;
		this.position = position;
		this.type = type;
		this.surface = surface;
		this.numeroEtage = numeroEtage;
		this.prix = prix;
	}
	

}
