package model;

/** Wetland Class - Wetland Program
 *@author JuanSalazar
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
	
	/**
	*  array to save the species
	* */
	private Species [] species;

	/**
	*  array to save the events
	* */
	private Event [] events;
	
	/**
	*  contant to set the max num of species that can be registered
	* */
	private static final int MAX_SPECIES=10;
	
	/**
	*  contant to set the max num of events that can be registered
	* */
	private static final int MAX_EVENTS=10;
	
	/**
	*  var to count the registered animals
	* */
	private int wetlandAnimals;
	
	/**
	*  var to count the registered flora
	* */
	private int wetlandFlora;
	
	/**
	*  var to save the percentage of fullfilment of the management plan
	* */
	private double  managementPlan;
	
	/**
	*  var to count the num of maintenance there's been in the wetland
	* */
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
	* @param newName String, must not be empty 
	* @param newLocation String, must not be empty
	* @param newType String, must not be empty
	* @param newArea double, must be bigger than 0
	* @param newUrlPhoto String, must not be empty
	* @param newProtectedArea boolean, must not be null
	* @param newLocationName String, must not be empty
	* @param plan double, must be initialized
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
	
	/**
	* Method to find the first empty position in species array
	* @return position int, index of the empty position , -1 if the array is full
	* */
	public int speciesEmptyPosition(){
		
		int position= -1;
		
		for(int i=0; i<MAX_SPECIES && position == -1; i++){
			
			if(species [i]==null){
				position=i;
			}
		}
		return position;
	}
	
	/**
	* Method to find the first empty position in events array
	* @return position int, index of the empty position , -1 if the array is full
	* */
	public int eventsEmptyPosition(){
		
		int position= -1;
		
		for(int i=0; i<MAX_EVENTS && position == -1; i++){
			
			if(events[i]==null){
				position=i;
			}
		}
		return position;
	}
	
	/**
	* Method to add the species to the array
	* @param newSpecies Species, must not be null
	* @param animalFlora int, must be 1 or 2
	* */
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
	
	/**
	* Method to add the event to the array
	* @param newEvent Event, must not be null
	* @param isMaintenance int, must be 1 or 2
	* */
	public void addEvent(Event newEvent, int isMaintenance) {
	
		if (isMaintenance==1){
			maintenance++;
		}
		int emptyPosition= eventsEmptyPosition();
		events[emptyPosition] = newEvent;
	}
	
	/**
	* Method to find a species in the the wetland
	* @param speciesName String, must not be empty
	* @return out boolean, true if the species was found
	* */
	public boolean findSpecies(String speciesName) {

		boolean out=false;
		
		for(int i=0; i<MAX_SPECIES && out==false; i++){
			
			if(species[i]!=null && species[i].getName().equals(speciesName)){
				
				out=true;
			}
		}
		return out;
	}
	
	//getters and setters
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
	
	/**
	* String to represent the object
	*<b> pre:</b> name must be initialized
	*<b> pre:</b> location must be initialized
	*<b> pre:</b> type must be initialized
	*<b> pre:</b> area must be initialized
	*<b> pre:</b> urlPhoto must be initialized
	*<b> pre:</b> protectedArea must be initialized
	*<b> pre:</b> locationName must be initialized
	*<b> pre:</b> managementPlan must be initialized
	*<b> pre:</b> wetlandAnimals must be initialized
	*<b> pre:</b> wetlandAnimals must be initialized
	*<b> pre:</b> wetlandFlora must be initialized
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

}