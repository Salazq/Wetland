package model;

/** Wetland Class - Wetland Program
 * */
public class Wetland {

	/**
	*  var to save the name
	* */
	private String name;
	
	/**
	*  var to save the location
	* */
	private String location;
	
	/**
	*  var to save the type
	* */
	private String type;
	
	/**
	*  var to save the area (meters^2)
	* */
	private double area;
	
	/**
	*  var to save the url of the Wetland's photo
	* */
	private String urlPhoto;
	
	/**
	*  var to save the protection status of the wetland
	* */
	private boolean protectedArea;
	
	/**
	*  var to save the name of the location
	* */
	private String locationName;
	
	private Species [] species;

	private Event [] events;
	
	private static final int MAX_SPECIES=2;
	
	private static final int MAX_EVENTS=2;
	
	private int wetlandAnimals;
	private int wetlandFlora;
	
	private double  managementPlan;
	
	private int maintenance;
	/**
	* Description: constructor for Wetland
	*<b> pre:</b> name must be declared
	*<b> pre:</b> location must be declared
	*<b> pre:</b> type must be declared
	*<b> pre:</b> area must be declared
	*<b> pre:</b> urlPhoto must be declared
	*<b> pre:</b> protectedArea must be declared
	*<b> pre:</b> locationName must be declared
	* @param newName, must not be empty 
	* @param newLocation, must not be empty
	* @param newType, must not be empty
	* @param newArea, must be bigger than 0
	* @param newUrlPhoto, must not be empty
	* @param newProtectedArea, must not be null
	* @param newLocationName, must not be empty
	*/
	public Wetland(String newName, String newLocation, String newType, double newArea, String newUrlPhoto, boolean newProtectedArea,String newLocationName, double plan){
		name=newName;
		location=newLocation;
		type=newType;
		area=newArea;
		urlPhoto=newUrlPhoto;
		protectedArea=newProtectedArea;
		locationName= newLocationName;
		managementPlan= plan;
		
		wetlandAnimals=0;
		wetlandFlora=0;
		
		species= new Species [MAX_SPECIES];
		events= new Event [MAX_EVENTS];
		
		maintenance=0;
	}
	
	public int speciesEmptyPosition(){
		
		int position= -1;
		
		for(int i=0; i<MAX_SPECIES && position == -1; i++){
			
			if(species [i]==null){
				position=i;
			}
		}
		return position;
	}
	
	public int eventsEmptyPosition(){
		
		int position= -1;
		
		for(int i=0; i<MAX_EVENTS && position == -1; i++){
			
			if(events[i]==null){
				position=i;
			}
		}
		return position;
	}
	
	public void addSpecies(Species newSpecies, int animalFlora) {

		if (animalFlora==1){
			wetlandAnimals++;
		}
		
		else{
			wetlandFlora++;
		}
			
		int emptyPosition= speciesEmptyPosition();
		species[emptyPosition] = newSpecies;
	}
	
	public void addEvent(Event newEvent, int isMaintenance) {
	
		if (isMaintenance==1){
			maintenance++;
		}
		int emptyPosition= eventsEmptyPosition();
		events[emptyPosition] = newEvent;
	}
	
	public boolean findSpecies(String speciesName) {

		boolean out=false;
		
		for(int i=0; i<MAX_SPECIES && out==false; i++){
			
			if(species[i]!=null && species[i].getName().equals(speciesName)){
				
				out=true;
			}
		}
		return out;
	}
	
	
	/**
	* Description: String to represent the object
	*<b> pre:</b> name must be initialized
	*<b> pre:</b> location must be initialized
	*<b> pre:</b> type must be initialized
	*<b> pre:</b> area must be initialized
	*<b> pre:</b> urlPhoto must be initialized
	*<b> pre:</b> protectedArea must be initialized
	*<b> pre:</b> locationName must be initialized
	*@return String, Wetland format
	*/
	
	public String toString(){
		String proArea="No";
		
		if (protectedArea==true){
			proArea="Yes";
		}
		
		return "Name: "+ name +"\n Location: "+ location +"\n Type: "+ type +"\n Area: "+ area + " m2" +"\n Photo url: "+ urlPhoto +"\n Protected area: "+ proArea
		+"\n Location name: "+ locationName + "\n Management plan fulfillment: "+ managementPlan + "%" + "\n Animal species: "+ wetlandAnimals
		+ "\n Flora species: "+ wetlandFlora;
	}


	public String getName() {
		return name;
	}
	
	public int getMaintenance() {
		return maintenance;
	}
	
	public int getWetlandAnimals() {
		return wetlandAnimals;
	}
	
	public int getWetlandFlora() {
		return wetlandFlora;
	}
	

}