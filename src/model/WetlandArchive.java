package model;

/** WetlandArchive Class - Wetland Program
 * */
public class WetlandArchive {
	
	private int registeredWetlands;
	
	private static final int MAX_WETLANDS = 2;
	
	private Wetland [] wetlands;
	
	private int terrestrialFlora;
	private int aquaticFlora;
	private int birds;
	private int mammals;
	private int aquaticAnimals;
	private int animals;
	private int flora;
	
	/**
	* Description: constructor for WetlandArchive
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
	
	public int emptyPosition(){
		
		int position= -1;
		
		for(int i=0; i<MAX_WETLANDS && position == -1; i++){
			
			if(wetlands [i]==null){
				position=i;
			}
		}
		return position;
	}
	
	public int searchWetland(String name){
		
		int position= -1;
		
		for(int i=0; i<MAX_WETLANDS && position == -1; i++){
			
			if(wetlands[i]!=null && wetlands[i].getName().equals(name)){
				position=i;
			}
		}
		return position;
	}
	
	public int wetlandSpeciesEmptyPosition(int wetlandPosition){
		
		int position= wetlands[wetlandPosition].speciesEmptyPosition();
		return position;
	}
	
	public int wetlandEventsEmptyPosition(int wetlandPosition){
		
		int position= wetlands[wetlandPosition].eventsEmptyPosition();
		return position;
	}
	
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
	* Description: method to find the wetland with most fauna
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
	* Description: method to find the wetlands that has an species
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