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
	
	public void addWetland(String name, int location, int type, double area, String url, int protectedArea, String locationName) {
		
		String stringLocation="Rural";
		String stringType="Private";
		boolean booleanArea=false;
		
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
		wetlands [emptyPosition] = new Wetland (name, stringLocation, stringType, area, url, booleanArea, locationName);
		
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
		}

		Species newSpecies= new Species (name, scientificName, speciesType, booleanMigratory);
		
		wetlands[wetlandPosition].addSpecies(newSpecies, animalFlora);
	}
	
	/**
	* Description: method to find the wetland with most fauna
	*/
	public String findMostAnimals(){
		
		String wetlandName="";
		int mostNum=0;
		
		for(int i=0; i<MAX_WETLANDS ; i++){
			
			int current =wetlands[i].getWetlandAnimals();
			
			if (current > mostNum){
				
				mostNum= current;
				wetlandName=wetlands[i].getName();

			}
			
			else if (current == mostNum){
				wetlandName+=" and " + wetlands[i].getName();
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
			
			int current =wetlands[i].getWetlandFlora();
			
			if (current < lessNum){
				
				lessNum= current;
				wetlandName=wetlands[i].getName();

			}
			
			else if (current == lessNum){
				wetlandName+=" and " + wetlands[i].getName();
			}
		}
		return wetlandName;
	}
	
	

	/**
	* Description: method to find the wetlands that has an species
	*/
	public void findSpeciesWetland(String species) {

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
		return "\nWetlands\n" + 
				wetlandsList;		
	}
}