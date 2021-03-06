package model;

/** WetlandArchive Class - Wetland Program
 *@author JuanSalazar
 * */
public class WetlandArchive {
	
	/**
	*  var to count the number of registered wetlands
	* */
	private int registeredWetlands;
	
	/**
	*  constant to set the max num of wetlands that can be registered
	* */
	private static final int MAX_WETLANDS = 80;
	
	/**
	*  array to save the wetlands
	* */
	private Wetland [] wetlands;
	
	/**
	*  var to count var the number of registered terrestrial Flora
	* */
	private int terrestrialFlora;
	
	/**
	*  var to count var the number of registered aquatic Flora
	* */
	private int aquaticFlora;
	
	/**
	*  var to count var the number of registered birds
	* */
	private int birds;
	
	/**
	*  var to count var the number of registered mammals
	* */
	private int mammals;
	
	/**
	*  var to count var the number of registered aquatic animals
	* */
	private int aquaticAnimals;
	
	/**
	*  var to count var the number of registered animals
	* */
	private int animals;
	
	/**
	*  var to count var the number of registered flora
	* */
	private int flora;
	
	/**
	* constructor for WetlandArchive
	*/
	public WetlandArchive(){
		wetlands= new Wetland[MAX_WETLANDS];
		registeredWetlands=0;
		terrestrialFlora=0;
		aquaticFlora=0;
		birds=0;
		mammals=0;
		aquaticAnimals=0;
		animals=0;
		flora=0;
	}
	
	/**
	* Method to create and add a wetland to the array
	* @param name String, must be initialized
	* @param location int, must be 1 or 2
	* @param type int, must be 1 or 2
	* @param area double, must be initialized
	* @param url String, must be initialized
	* @param protectedArea int, must be initialized
	* @param locationName String,must be initialized
	* @param plan double, must be initialized
	* */
	public void addWetland(String name, int location, int type, double area, String url, int protectedArea, String locationName, double plan) {
	
		String stringLocation="Rural";
		String stringType="Private";
		boolean booleanArea=false;
		
		if (plan  >100){
			plan=100;
		}
		
		if (plan  <0){
			plan=0;
		}
		
		if (location==1){
			stringLocation="Urban";
		}
		
		if (type==1){
			stringType="Public";
		}
		
		if (protectedArea==1){
			booleanArea=true;
		}
		
		int emptyPosition= emptyPosition();
		wetlands [emptyPosition] = new Wetland (name, stringLocation, stringType, area, url, booleanArea, locationName, plan);
		
		registeredWetlands++;
	}
	
	/**
	* Method to find the first empty position in wetlands array
	* @return position int, index of the empty position , -1 if the array is full
	* */
	public int emptyPosition(){
		
		int position= -1;
		
		for(int i=0; i<MAX_WETLANDS && position == -1; i++){
			
			if(wetlands [i]==null){
				position=i;
			}
		}
		return position;
	}
	
	/**
	* Method to find wetlands index with it??s name
	* @param name String, must be initialized
	* @return position int, index of the wetland, -1 if it is not in the array
	* */
	public int searchWetland(String name){
		
		int position= -1;
		
		for(int i=0; i<MAX_WETLANDS && position == -1; i++){
			
			if(wetlands[i]!=null && wetlands[i].getName().equals(name)){
				position=i;
			}
		}
		return position;
	}
	
	/**
	* Method to get the empty position in the species array in a wetland
	* @param wetlandPosition int, must a valid index for wetlands[]
	* @return position int, index of the empty position , -1 if the array is full
	* */
	public int wetlandSpeciesEmptyPosition(int wetlandPosition){
		
		int position= wetlands[wetlandPosition].speciesEmptyPosition();
		return position;
	}
	
	/**
	* Method to get the empty position in the events array in a wetland
	* @param wetlandPosition int, must a valid index for wetlands[]
	* @return position int, index of the empty position , -1 if the array is full
	* */
	public int wetlandEventsEmptyPosition(int wetlandPosition){
		
		int position= wetlands[wetlandPosition].eventsEmptyPosition();
		return position;
	}
	
	/**
	* Method to create and add a species to a wetland
	* @param wetlandName String, must be the name of a registered wetland
	* @param name String, must be initialized
	* @param scientificName String, must be initialized
	* @param type int, must be initialized
	* @param migratory int, must be 1 or 2
	* @param wetlandPosition int, must be a valid index in wetlands[]
	* */
	public void addSpeciesToWetland(String wetlandName, String name, String scientificName, int type, int migratory, int wetlandPosition){
		
		SpeciesType speciesType=null;
		boolean booleanMigratory=false;
		int animalFlora=1;
		
		if (migratory==1){
			booleanMigratory=true;
		}
		
		switch (type){
			case 1:
				speciesType=SpeciesType.TERRESTRIAL_FLORA;
				terrestrialFlora++;
				flora++;
				animalFlora=2;
				break;
			
			case 2:
				speciesType=SpeciesType.AQUATIC_FLORA;
				aquaticFlora++;
				flora++;
				animalFlora=2;
				break;
			
			case 3:
				speciesType=SpeciesType.BIRD;
				birds++;
				animals++;
				break;
			
			case 4:
				speciesType=SpeciesType.MAMMAL;
				mammals++;
				animals++;
				break;
				
			case 5:
				speciesType=SpeciesType.AQUATIC;
				aquaticAnimals++;
				animals++;
				break;
				
			default:
				speciesType=SpeciesType.TERRESTRIAL_FLORA;
				terrestrialFlora++;
				flora++;
				animalFlora=2;
		}
		Species newSpecies= new Species (name, scientificName, speciesType, booleanMigratory);
		wetlands[wetlandPosition].addSpecies(newSpecies, animalFlora);
	}
	
	/**
	* Method to create and add a event to a wetland
	* @param type int, must be initialized
	* @param day int, must be initialized
	* @param month int, must be initialized
	* @param year int, must be initialized
	* @param description String, must be initialized
	* @param clientName String, must be initialized
	* @param price double, must be initialized
	* @param wetlandPosition int,must be a valid index in wetlands[]
	* */
	public void addEventToWetland(int type, int day, int month, int year, String description, String clientName, double price, int wetlandPosition){
		
		int isMaintenance=0;
		EventType eventType=null;
		
		switch (type){
			case 1:
				eventType=EventType.MAINTENANCE;
				isMaintenance=1;

				break;
			
			case 2:
				eventType=EventType.SCHOOL_VISIT;

				break;
			
			case 3:
				eventType=EventType.IMPROVEMENT;

				break;
			
			case 4:
				eventType=EventType.CELEBRATIONS;
				
				break;
				
			default:
				eventType=EventType.MAINTENANCE;
		}
		
		Date newDate= new Date (day, month, year);
		
		Event newEvent= new Event (eventType, description, clientName, price, newDate);
		
		wetlands[wetlandPosition].addEvent(newEvent, isMaintenance);
	}
	
	/**
	* Method to find the wetland with most fauna
	* @return wetlandName String, name of the wetland/s with most fauna
	*/
	public String findMostAnimals(){
		
		String wetlandName="";
		int mostNum=0;
		
		for(int i=0; i<MAX_WETLANDS ; i++){
			
			if (wetlands[i]!=null){
			
				int current =wetlands[i].getWetlandAnimals();
				
				if (current > mostNum){
					
					mostNum= current;
					wetlandName=wetlands[i].getName();

				}
				
				else if (current == mostNum){
					wetlandName+=" and " + wetlands[i].getName();
				}
			
			}
		}
		return wetlandName;
	}
	
	/**
	* Description: method to find the wetland with less flora
	* @return wetlandName String, name of the wetland/s with less flora
	*/
	public String findLessFlora(){
		
		String wetlandName="";
		int lessNum=flora+1;
		
		for(int i=0; i<MAX_WETLANDS ; i++){
			
			if (wetlands[i]!=null){
			
				int current =wetlands[i].getWetlandFlora();
				
				if (current < lessNum){
					
					lessNum= current;
					wetlandName=wetlands[i].getName();

				}
				
				else if (current == lessNum){
					wetlandName+=" and " + wetlands[i].getName();
				}
			}
		}
		return wetlandName;
	}
	
	


	/**
	* Method to find the wetlands where a species can be found
	* @param speciesName String, must be the name of a registered species
	* @return wetlandName String, name of the wetland/s where the species can be found 
	*/
	public String findSpeciesWetland(String speciesName) {
		
		String wetlandName="can be found in: ";
		boolean found=false;
		
		for(int i=0; i<MAX_WETLANDS ; i++){
			
			if(wetlands[i]!=null){
				
				if (wetlands[i].findSpecies(speciesName) ==true) {
					
					found=true;
					wetlandName+= wetlands[i].getName()+ "  ";
				}
			}
		}
		
		if (found==false){
			wetlandName="is not registered";
		}
		return wetlandName;
	}
	
	public int findMaintenance(int position) {
		
		int maintenance= wetlands[position].getMaintenance();
		return maintenance;
	}

	
	//getters ans setters
	
	public double getRegisteredWetlands() {
		return registeredWetlands;
	}
	
	public double getAnimals() {
		return animals;
	}
	
	public double getFlora() {
		return flora;
	}
	
	/**
	* Method to gather the information of WetlandArchive
	* @return String, list of wetlands and count of registered species
	*/
	public String toString() {

		String wetlandsList="";
		
		for(int i=0; i<MAX_WETLANDS; i++){
			
			if (wetlands [i] != null) {
				wetlandsList+= "\n"+ (i+1)+"." + "\n" + wetlands [i];
			}
		}
		return "\nWetlands" + 
		        "\nTotal animal species: " + animals +
				"\nTotal flora species: " + flora+
				"\n" + wetlandsList;		
	}
}