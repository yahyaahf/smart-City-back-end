package ma.uiass.eia.controler;

import static spark.Spark.*;

import ma.uiass.eia.persistency.dto.EquipementDto;
import ma.uiass.eia.persistency.entities.*;
import ma.uiass.eia.service.*;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

import ma.uiass.eia.persistency.dto.WorkSpaceDto;

public class RestServer {
//	private static Service serviceSpark;
	private static VilleServiceInterface serviceV;
	private static SmartBuildingService serviceS;
	private static EtageServiceInterface serviceE;
	private static WorkSpaceServiceInterface serviceW;
	private static ClientService serviceC;
	private static LocationService serviceL;
	private static ElementService serviceEle;
	private static EmployeeServiceInterface serviceEmp;
	private static ReservationServiceInterface serviceR;
	private static EquipementServiceInterface serviceEqu;

	static {
//		serviceSpark=Service.ignite();
		serviceV  = new VilleService();
		serviceS  = new SmartBuildingService();
		serviceE  = new EtageService();
		serviceW  = new WorkSpaceService();
		serviceC  = new ClientService();
		serviceL  = new LocationService();
		serviceEle=new ElementService();
		serviceEmp=new EmployeeService();
		serviceR = new ReservationService();
		serviceEqu=new EquipementService();
	}
	public RestServer() {

	}

	/*
	 * public static void main(String[] args) { Gson gson = new Gson();
	 * 
	 * System.out.println("serveur démarré sur l'adresse http://localhost:4567");
	 */
	public static void main(String[] args) {
    	 Gson gson =  new GsonBuilder().excludeFieldsWithoutExposeAnnotation().create();
		System.out.println("serveur démarré sur l'adresse http://localhost:4567");
    	 
//-=-=-=-=-==--=-=-=-=-=-==--=-=-=-=-=-==--=-=-=-=-=-==--=-=-=-=-=-==--=-=-=-=-=-==--=-=-=-=-=-==--=-=-=-=-=-==--=-=-=-=-=-==--=-=-=-=-=-==--=-=-=-=-=-==--=-=-=-=-=-==--=-=-=-=-=-==--=
    	 get("/api/villes", (req,res)-> {
        
                         
    		 List<Ville> data = serviceV.getAllVilles();
                              
    		 res.type("application/json");
                      
    		 return data;
    	 },gson::toJson);
         
    	 post("/api/villes/add",(req,res)->{
    		 String message="ville créee avec succès";
           
    		 //System.out.println(req.body());
    		 //parse(req.body());
    		 JsonObject ville = new JsonParser().parse(req.body()).getAsJsonObject();
                            
    		 String nom= ville.get("nom").getAsString();
    		 double latitude= ville.get("latitude").getAsDouble();
    		 double longitude = ville.get("longitude").getAsDouble();
    		 //System.out.println(nom + " "+latitude+ " "+longitude);
    		 serviceV.createVille(nom, latitude, longitude);
           
             res.type("application/json");
                  
            return message;
         });
     
    	 delete("/api/villes/:id/remove", (req, res) -> {
    		 String message="ville deleted avec succes";
    		 String parame = req.params("id");
    		 long id =Long.parseLong(parame);
    		 serviceV.deleteVille(serviceV.getVilleById(id));
    	 
    	 
    		 res.type("application/json");
    		 return message;
    	},gson::toJson);
    
     
      
    	get("/api/villes/:id",(req,res)->{
        
        
    		 String parame = req.params("id");
       
    		 long id =Long.parseLong(parame);
    		 Ville v=serviceV.getVilleById(id);
        
    		 //String message =v.toString();
        
        
    		 res.type("application/json");
            
    		 return v; 
    	},gson::toJson);
    
    	put("/api/villes/:id/update", (req, res) -> {
    		String parame = req.params("id");
    		long id =Long.parseLong(parame);
        
    		String message="ville modifié avec succès";
    		JsonObject ville = new JsonParser().parse(req.body()).getAsJsonObject();
    		String nom= ville.get("nom").getAsString();
        	double latitude= ville.get("latitude").getAsDouble();
        	double longitude = ville.get("longitude").getAsDouble();
        	serviceV.updateVille(nom, latitude, longitude, id);;
        	res.type("application/json");
        
        	return message; 
    	},gson::toJson);
       
// --------------------------------------------------------------------------------------------------------------------------------------------------------------------------//
    /*get("/api/smartBuildings", (req, res) -> {
    	List<SmartBuilding> smartBuildings=serviceS.getAllSmartBuildings();
    	res.type("application/json");
        
        return smartBuildings;
        
    },gson::toJson);*/
    
    
    get("/api/smartBuildings/:idVille", (req, res) -> {
    	String parame = req.params("idVille");
     	long idVille =Long.parseLong(parame);
     	System.out.println(idVille);
     	
     	List<SmartBuilding> smartBuildings=serviceS.getAllSmartBuildings(idVille);
        //List<SmartBuilding> smartBuildings=serviceS.getAllSmartBuildings(idVille);
        
        res.type("application/json");
        
        return smartBuildings;
        
    },gson::toJson);
    
    
		
    post("/api/smartBuildings/:idVille/add",(req,res)->{
    	String message="smartBuilding crée avec succès";
    	String parame = req.params("idVille");
     	long id =Long.parseLong(parame);  
		//System.out.println(req.body()); //parse(req.body()); 
		JsonObject smartBuilding = new JsonParser().parse(req.body()).getAsJsonObject();
		int nombreEtages=smartBuilding.get("nombreEtages").getAsInt();
		int surface = smartBuilding.get("surface").getAsInt();
		double longitude=smartBuilding.get("longitude").getAsDouble();
		double latitude=smartBuilding.get("latitude").getAsDouble();
		String adress=smartBuilding.get("adress").getAsString();
		Ville ville=serviceV.getVilleById(id);
		serviceS.createSmartBuilding(nombreEtages, surface, longitude, latitude,adress,ville);
		
		res.type("application/json");
        
        return message; 
    },gson::toJson); 
    
    get("/api/smartBuildings/smartBuilding/:id",(req,res)->{
    	
        
        String parame = req.params("id");
        long id =Long.parseLong(parame);
        SmartBuilding smartBuilding=serviceS.getSmartBuildingById(id);
        
        //String message =v.toString();
        
        
         res.type("application/json");
            
            return smartBuilding; 
    },gson::toJson);
    
    delete("/api/smartBuildings/:id/remove", (req, res) -> {
      	 String message="smartBuilding deleted avec succes";
      	 String parame = req.params("id");
      	 long id =Long.parseLong(parame);
      	 serviceS.deleteSmartBuilding(serviceS.getSmartBuildingById(id));
      	 
      	 
      	 res.type("application/json");
      	 return message;
    },gson::toJson);
    
    
    
    put("/api/smartBuildings/:id/update", (req, res) -> {
    	String parame = req.params("id");
        long id =Long.parseLong(parame);
        
        String message="smartBuilding modifié avec succès";
        JsonObject smartBuilding = new JsonParser().parse(req.body()).getAsJsonObject();
		int nombreEtages=smartBuilding.get("nombreEtages").getAsInt();
		int surface = smartBuilding.get("surface").getAsInt();
		double longitude=smartBuilding.get("longitude").getAsDouble();
		double latitude=smartBuilding.get("latitude").getAsDouble();
		String adress=smartBuilding.get("adress").getAsString();
		serviceS.updateSmartBuilding(nombreEtages, surface, longitude, latitude,adress,id);
        
        res.type("application/json");
        
        return message; 
    },gson::toJson);
    
// --------------------------------------------------------------------------------------------------------------------------------------------------------------------------//  
    
    get("/api/etages/:idBuilding", (req, res) -> {
    	String parame = req.params("idBuilding");
        long id =Long.parseLong(parame);
    	List<Etage> etages=serviceE.getAllEtagesByBuilding(id);
        
        res.type("application/json");
        
        return etages;
        
    },gson::toJson);
    
    
		
    post("/api/etages/:idBuilding/add",(req,res)->{
    	String message="etage créee avec succès";
    	String parame = req.params("idBuilding");
        long id =Long.parseLong(parame);
		  
		//System.out.println(req.body()); //parse(req.body()); 
		JsonObject etage = new JsonParser().parse(req.body()).getAsJsonObject();
		int numEtage = etage.get("numEtage").getAsInt();
		double surface=etage.get("surface").getAsDouble();
		SmartBuilding building=serviceS.getSmartBuildingById(id);
		
		serviceE.createEtage(numEtage, surface,building);
		
		res.type("application/json");
        
        return message; 
    },gson::toJson); 
    
    get("/api/etages/etage/:id",(req,res)->{
        
        
        String parame = req.params("id");
       
        long id =Long.parseLong(parame);
        Etage etage=serviceE.getEtageById(id);
        
        //String message =v.toString();
        
        
         res.type("application/json");
            
            return etage; 
    },gson::toJson);
    
    delete("/api/etages/:id/remove", (req, res) -> {
      	 String message="etage deleted avec succes";
      	 String parame = req.params("id");
      	 long id =Long.parseLong(parame);
      	 serviceE.deleteEtage(serviceE.getEtageById(id));
      	 
      	 
      	 res.type("application/json");
      	 return message;
      	},gson::toJson);
    
    
    
    put("/api/etages/:id/update", (req, res) -> {
    	String parame = req.params("id");
        long id =Long.parseLong(parame);
        
        String message="etage modifié avec succès";
        JsonObject etage = new JsonParser().parse(req.body()).getAsJsonObject();
        int numEtage = etage.get("numEtage").getAsInt();
		double surface=etage.get("surface").getAsDouble();
		serviceE.updateEtage(numEtage, surface, id);
        
        res.type("application/json");
        
        return message; 
    },gson::toJson);
    
//-----=-----=-----=-----=-----=-----=-----=-----=-----=-----=-----=-----=-----=-----=-----=-----=-----=-----=-----=-----=-----=-----=-----=-----=   
    get("/api/workSpaces/:idEtage", (req, res) -> {
    	String parame = req.params("idEtage");
        long idEtage =Long.parseLong(parame);
    	
        List<WorkSpaceDto> workSpaces=serviceW.getAllWorkSpacesByEtage(idEtage);
        
        res.type("application/json");
        
        return workSpaces;
        
    },gson::toJson);
   post("/api/workSpaces/:idEtage/add",(req,res)->{
    	String message="workSpace créee avec succès";
    	
    	String parame = req.params("idEtage");
        long id =Long.parseLong(parame);
		  
		//System.out.println(req.body()); //parse(req.body()); 
		JsonObject workSpace = new JsonParser().parse(req.body()).getAsJsonObject();
		String position =workSpace.get("position").getAsString();
		int surface=workSpace.get("surface").getAsInt();
		String type=workSpace.get("type").getAsString();
		Etage etage=serviceE.getEtageById(id);
		double prix=workSpace.get("prix").getAsDouble();
		//long numero = workSpace.get("numero").getAsLong();
		
		serviceW.createWorkSpace(0,surface, type, etage, position,prix);
		
		res.type("application/json");
        
        return message; 
    },gson::toJson);
    
    
   put("/api/workSpaces/:id/update",(req,res)->{
   	String message="workSpace modifié avec succès";
   	
   	String parame = req.params("id");
       long id =Long.parseLong(parame);
		  
		//System.out.println(req.body()); //parse(req.body()); 
		JsonObject workSpace = new JsonParser().parse(req.body()).getAsJsonObject();
		String position =workSpace.get("position").getAsString();
		int surface=workSpace.get("surface").getAsInt();
		String type=workSpace.get("type").getAsString();
		double prix=workSpace.get("prix").getAsDouble();
		long numero = workSpace.get("numero").getAsLong();
		String equipements=workSpace.get("equipements").getAsString();
		serviceW.updateWorkSpace(numero ,surface, type, position,prix,equipements, id);
		
		res.type("application/json");
       
       return message; 
   },gson::toJson);
    
    
    
   get("/api/workSpaces/workSpace/:id",(req,res)->{
       
       
       String parame = req.params("id");
      
       long id =Long.parseLong(parame);
       WorkSpaceDto workSpace=serviceW.getWorkSpaceByIdDto(id);       
       //String message =v.toString();
       
       
        res.type("application/json");
           
           return workSpace; 
   },gson::toJson);
    
   
   delete("/api/workSpaces/:id/remove", (req, res) -> {
    	 String message="etage deleted avec succes";
    	 String parame = req.params("id");
    	 long id =Long.parseLong(parame);
    	 serviceW.deleteWorkSpace(serviceW.getWorkSpaceById(id));
    	 
    	 
    	 res.type("application/json");
    	 return message;
    	},gson::toJson);
    
    
    
// --------------------------------------------------------------------------------------------------------------------------------------------------------------------------//  
   get("/api/ce/clients", (req, res) -> {
	   List<ClientEntreprise> clients = new ArrayList<ClientEntreprise>() ;
       clients= serviceC.getAllClientsEntreprise();
	   
	   //System.out.println("from server --------->"+clients);
	   res.type("application/json");

	   return clients;
   
   		},gson::toJson);
   
   
   get("/api/ci/clients", (req, res) -> {
	   List<ClientIndividu> clients = new ArrayList<ClientIndividu>() ;
       clients=serviceC.getAllClientsIndividu();
       
	   System.out.println("from server --------->"+clients);
	   res.type("application/json");
	   
   	   return clients;
   
   		},gson::toJson);
   
   
   
  post("/api/clients/add",(req,res)->{
   	String message="client créee avec succès";
   	
   	
		  
		//System.out.println(req.body()); 
		JsonObject client = new JsonParser().parse(req.body()).getAsJsonObject();
		String  email =client.get("email").getAsString();
		String telephone=client.get("telephone").getAsString();
		String adress=client.get("adress").getAsString();
		String sexe=client.get("sexe").getAsString();
		String formeJuridique=client.get("formeJuridique").getAsString();
		String patente=client.get("patente").getAsString();
		String nom=client.get("nom").getAsString();
		String prenom=client.get("prenom").getAsString();
		String type=client.get("type").getAsString();
		
		
		
		serviceC.createClient(email, telephone, adress, formeJuridique, patente, nom, prenom, sexe,type);
				
		
		res.type("application/json");
       
       return message; 
   },gson::toJson);
      
   
  get("/api/clients/:id",(req,res)->{
      
      
      String parame = req.params("id");
     
      long id =Long.parseLong(parame);
      ClientEntreprise client = serviceC.getClientEntrepriseById(id);
      //String message =v.toString();
      
      
       res.type("application/json");
          
          return client; 
  },gson::toJson);
   
   
//--=-=-=-=-=-=--=-=-=-=-=-=--=-=-=-=-=-=--=-=-=-=-=-=--=-=-=-=-=-=--=-=-=-=-=-=--=-=-=-=-=-=--=-=-=-=-=-=--=-=-=-=-=-=--=-=-=-=-=-=--=-=-=-=-=-=--=-=-=-=-=-=--=-=-=-=-=-=--=-=-=-=-=-= 
  
  get("/api/locations", (req, res) -> {
	  
	  List<Location> locations = serviceL.getAllLocations();
	  System.out.println("From server ------->"+locations);
	   res.type("application/json");

	   return locations;
  
  		},gson::toJson);
   
   
 post("/api/locations/:idClient/:idElement/add",(req,res)->{
  	String message="location créee avec succès";
  	
  	String parame = req.params("idClient");
    long idClient =Long.parseLong(parame);
    
    String par = req.params("idElement");
    long idElement =Long.parseLong(par);
    
    
    Client client = serviceC.getClientById(idClient);
    Element element= serviceEle.getElementById(idElement);
		  
		//System.out.println(req.body()); //parse(req.body()); 
		JsonObject location = new JsonParser().parse(req.body()).getAsJsonObject();
		String dateCreation =location.get("dateCreation").getAsString();
		String dateDebut=location.get("dateDebut").getAsString();
		String dateFin = location.get("dateFin").getAsString();
		
		serviceL.createLocation(dateCreation, dateDebut, dateFin, client,element)	;
		
		res.type("application/json");
      
      return message; 
  },gson::toJson);
		post("/api/locations/:idClient/add",(req,res)->{
			String message="location créee avec succès";

			String parame = req.params("idClient");
			long idClient =Long.parseLong(parame);




			Client client = serviceC.getClientById(idClient);


			//System.out.println(req.body()); //parse(req.body());
			JsonObject location = new JsonParser().parse(req.body()).getAsJsonObject();
			String dateCreation =location.get("dateCreation").getAsString();
			String dateDebut=location.get("dateDebut").getAsString();
			String dateFin = location.get("dateFin").getAsString();
			String workSpaces=location.get("workSpaces").getAsString();

			serviceL.createLocationAile(dateCreation, dateDebut, dateFin, client,workSpaces);	;

			res.type("application/json");

			return message;
		},gson::toJson);
   
   
   
   
//--=-=-=-=-=-=--=-=-=-=-=-=--=-=-=-=-=-=--=-=-=-=-=-=--=-=-=-=-=-=--=-=-=-=-=-=--=-=-=-=-=-=--=-=-=-=-=-=--=-=-=-=-=-=--=-=-=-=-=-=--=-=-=-=-=-=--=-=-=-=-=-=--=-=-=-=-=-=--=-=-=-=-=-= 
 
   
   
 get("/api/employees/:idEntreprise", (req, res) -> {
	 String parame = req.params("idEntreprise");
     long idEntreprise =Long.parseLong(parame);
	  List<Employee> employees=serviceEmp.getAllEmployeesByEntreprise(idEntreprise);
	  System.out.println("From server ------->"+employees);
	   res.type("application/json");

	   return employees;
 
 		},gson::toJson);
   
 post("/api/employees/:idEntreprise/add",(req,res)->{
 	String message="employee créee avec succès";
 	
 	String parame = req.params("idEntreprise");
     long idEntreprise =Long.parseLong(parame);
		  
		//System.out.println(req.body()); //parse(req.body()); 
		JsonObject employee = new JsonParser().parse(req.body()).getAsJsonObject();
		String  email =employee.get("email").getAsString();
		String telephone=employee.get("telephone").getAsString();
		String adress=employee.get("adress").getAsString();
		String sexe=employee.get("sexe").getAsString();
		String nom=employee.get("nom").getAsString();
		String prenom=employee.get("prenom").getAsString();
		ClientEntreprise entreprise=serviceC.getClientEntrepriseById(idEntreprise);
		
		serviceEmp.createEmployee(nom, prenom, email, sexe, telephone, adress, entreprise);	
		
		res.type("application/json");
     
     return message; 
 },gson::toJson); 
 get("/api/employees/employee/:id",(req,res)->{
     
     
     String parame = req.params("id");
     long id =Long.parseLong(parame);
     
     
     Employee employee=serviceEmp.getEmployeeById(id);
     //String message =v.toString();
     
     
      res.type("application/json");
         
         return employee; 
 },gson::toJson);
   
//--=-=-=-=-=-=--=-=-=-=-=-=--=-=-=-=-=-=--=-=-=-=-=-=--=-=-=-=-=-=--=-=-=-=-=-=--=-=-=-=-=-=--=-=-=-=-=-=--=-=-=-=-=-=--=-=-=-=-=-=--=-=-=-=-=-=--=-=-=-=-=-=--=-=-=-=-=-=--=-=-=-=-=-= 
 get("/api/reservations", (req, res) -> {
	 
	  List<Reservation> reservations = serviceR.getAllReservations();
	  System.out.println("From server ------->"+reservations);
	   res.type("application/json");

	   return reservations;
 
 		},gson::toJson);
 
 
 post("/api/reservations/:idWorkspace/:idEmployee/add",(req,res)->{
	 	String message="reservation créee avec succès";
	 	
	 	String parame = req.params("idWorkspace");
	     long idWorkspace =Long.parseLong(parame);
	     
	     
	     String par = req.params("idEmployee");
	     long idEmployee =Long.parseLong(par);
			  
			//System.out.println(req.body()); //parse(req.body()); 
			JsonObject reservation = new JsonParser().parse(req.body()).getAsJsonObject();
			String dateDebut=reservation.get("dateDebut").getAsString();
			String dateFin = reservation.get("dateFin").getAsString();
			String heureDebut=reservation.get("heureDebut").getAsString();
			String heureFin=reservation.get("heureFin").getAsString();
			
			Employee employee=serviceEmp.getEmployeeById(idEmployee);
			WorkSpace workSpace=serviceW.getWorkSpaceById(idWorkspace);
			
			serviceR.createReservation(dateDebut, dateFin, heureDebut, heureFin, workSpace, employee);
			
			res.type("application/json");
	     
	     return message; 
	 },gson::toJson); 
 
 
 get("/api/reservations/:id",(req,res)->{
     
     
     String parame = req.params("id");
     long id =Long.parseLong(parame);
     
     
     Reservation reservation = serviceR.getReservationById(id);
     //String message =v.toString();
     
     
      res.type("application/json");
         
         return reservation; 
 },gson::toJson);
 //--=-=-=-=-=-=--=-=-=-=-=-=--=-=-=-=-=-=--=-=-=-=-=-=--=-=-=-=-=-=--=-=-=-=-=-=--=-=-=-=-=-=--=-=-=-=-=-=--=-=-=-=-=-=--=-=-=-=-=-=--=-=-=-=-=-=--=-=-=-=-=-=--=-=-=-=-=-=--=-=-=-=-=-=
		get("/api/equipements",(req,res)->{

			List<EquipementDto> equipements= serviceEqu.getAllEquipements();
			//String message =v.toString();


			res.type("application/json");

			return equipements;
		},gson::toJson);


		get("/api/equipements/:id",(req,res)->{


			String parame = req.params("id");
			long id =Long.parseLong(parame);


			Equipement equipement=serviceEqu.getEquipementById(id);
			//String message =v.toString();


			res.type("application/json");

			return equipement;
		},gson::toJson);

		post("/api/equipements/:idWorkSpace/add",(req,res)->{
			String message="equipement créee avec succès";

			String parame = req.params("idWorkSpace");
			long idWorkSpace =Long.parseLong(parame);



			//System.out.println(req.body());
			JsonObject equipement = new JsonParser().parse(req.body()).getAsJsonObject();
			String code =equipement.get("code").getAsString();
			boolean etat=equipement.get("etat").getAsBoolean();
			String type=equipement.get("type").getAsString();

			WorkSpace workSpace=serviceW.getWorkSpaceById(idWorkSpace);

			serviceEqu.createEquipement(code,workSpace,etat,type);



			res.type("application/json");

			return message;
		},gson::toJson);
}
}
