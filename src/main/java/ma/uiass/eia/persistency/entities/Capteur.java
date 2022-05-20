package ma.uiass.eia.persistency.entities;

import javax.persistence.Entity;

@Entity
public class Capteur extends Equipement {
	private static String unite;
	private double valeur,valeurMin,valeurMax;
	
	public Capteur() {
		
		}
	
	public Capteur(String code, WorkSpace workSpace,boolean etat) {
		super(code, workSpace,etat);
		
		
	}
	public long getId(){return  super.getId();}
	public void setId(long id){super.setId(id);}

	public static String getUnite() {
		return unite;
	}

	public static void setUnite(String unite) {
		Capteur.unite = unite;
	}

	public double getValeur() {
		return valeur;
	}

	public void setValeur(double valeur) {
		this.valeur = valeur;
	}

	public double getValeurMin() {
		return valeurMin;
	}

	public void setValeurMin(double valeurMin) {
		this.valeurMin = valeurMin;
	}

	public double getValeurMax() {
		return valeurMax;
	}

	public void setValeurMax(double valeurMax) {
		this.valeurMax = valeurMax;
	}
	
	
	
	
}
