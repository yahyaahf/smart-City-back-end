package ma.uiass.eia.persistency.main;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import ma.uiass.eia.persistency.dao.SmartBuildingDaoImp;
import ma.uiass.eia.persistency.entities.SmartBuilding;


public class InitializeDB {

	public InitializeDB() {
		
	}

	public static void main(String[] args) {
	 EntityManagerFactory factory= Persistence.createEntityManagerFactory("PU_SC");
		/* VilleDaoImp villedao = new VilleDaoImp();
		 villedao.create(new Ville("Rabat",33.97,6.84));
		 
		 villedao.getAll().forEach(System.out::println);
		 */
	 SmartBuildingDaoImp smartbuildingdao=new SmartBuildingDaoImp();
	 //smartbuildingdao.create(new SmartBuilding(3,731,33.57,7.58,"pppppp"));
	 smartbuildingdao.getAllByVille(1).forEach(System.out::println);
	 
	 //smartbuildingdao.getAll().forEach(System.out::println);
		 
	}

}
