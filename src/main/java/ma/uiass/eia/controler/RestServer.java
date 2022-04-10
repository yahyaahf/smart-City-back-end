package ma.uiass.eia.controler;

import static spark.Spark.*;
import spark.Service;
import java.util.List;
import java.util.Map;

import javax.print.attribute.standard.Severity;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

import ma.uiass.eia.persistency.entities.Etage;
import ma.uiass.eia.persistency.entities.SmartBuilding;
import ma.uiass.eia.persistency.entities.Ville;

import ma.uiass.eia.persistency.entities.WorkSpace;
import ma.uiass.eia.service.EtageService;
import ma.uiass.eia.service.EtageServiceInterface;
import ma.uiass.eia.service.SmartBuildingService;
import ma.uiass.eia.service.SmartBuildingServiceInterface;
import ma.uiass.eia.service.VilleService;
import ma.uiass.eia.service.VilleServiceInterface;
import ma.uiass.eia.service.WorkSpaceService;
import ma.uiass.eia.service.WorkSpaceServiceInterface;

public class RestServer {
//	private static Service serviceSpark;
	private static VilleServiceInterface serviceV;
	private static SmartBuildingService serviceS;
	private static EtageServiceInterface serviceE;
	private static WorkSpaceServiceInterface serviceW;

	static {
//		serviceSpark=Service.ignite();
		serviceV = new VilleService();
		serviceS = new SmartBuildingService();
		serviceE = new EtageService();
		serviceW = new WorkSpaceService();
	}
	public RestServer() {

	}

	/*
	 * public static void main(String[] args) { Gson gson = new Gson();
	 * 
	 * System.out.println("serveur démarré sur l'adresse http://localhost:4567");
	 */
	public static void main(String[] args) {
    	 Gson gson = new Gson();
    	
    	 
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
    	String message="smartBuilding créee avec succès";
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
    
    get("/api/smartBuildings/:id",(req,res)->{
    	
        
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
    
    get("/api/etages/:id",(req,res)->{
        
        
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
    	
        List<WorkSpace> workSpaces=serviceW.getAllWorkSpacesByEtage(idEtage);
        
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
		
		serviceW.createWorkSpace(surface, type, etage, position);		
		
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
		
		
		serviceW.updateWorkSpace(surface, type, position, id);		
		
		res.type("application/json");
       
       return message; 
   },gson::toJson);
    
    
    
   get("/api/workSpaces/:id",(req,res)->{
       
       
       String parame = req.params("id");
      
       long id =Long.parseLong(parame);
       WorkSpace workSpace=serviceW.getWorkSpaceById(id);       
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
		
}
}
