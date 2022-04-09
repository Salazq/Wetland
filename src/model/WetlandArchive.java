package model;

/** WetlandArchive Class - Wetland Program
 * */
public class WetlandArchive {
	
	private int registeredWetlands;
	
	private static final int MAX_WETLANDS = 2;
	
	private Wetland [] wetlands;
	
	/**
	* Description: constructor for WetlandArchive
	*/
	public WetlandArchive(){
		wetlands= new Wetland[MAX_WETLANDS];
		registeredWetlands=0;
	}
	
	public void addWetland(String name, int location, int type, double area, String url, int protectedArea, String locationName) {
		
		String stringLocation="";
		String stringType="";
		boolean booleanArea=false;
		
		if (location==1){stringLocation="Urban";}
		else {stringLocation="Rural";}
		
		if (type==1){stringType="Public";}
		else {stringType="Private";}
		
		if (protectedArea==1){booleanArea=true;}
		else {booleanArea=false;}
		
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
	
	public void addSpeciesToWetland(String wetlandName, String name, String scientificName, int type, int migratory){
		
		String stringType="";
		boolean booleanMigratory=false;
		
		Species newSpecies= new Species (name, scientificName, stringType, booleanMigratory); //Cambiar type y migratory al tipo correcto
		
		wetlands[searchWetland(wetlandName)].addSpecies(newSpecies);
	}
	
	/**
	* Description: method to find the wetland with less flora
	*/
	public void findLessFlora() {

	}
	
	/**
	* Description: method to find the wetland with most fauna
	*/
	public void findMostFauna() {
		
	}

	/**
	* Description: method to find the wetlands that has an species
	*/
	public void findSpeciesWetland(String species) {

	}
	
	/**
	* Description: method to show a wetland'S information
	*/
	public void showWetlandInfo(String wetlandName) {

	}
	
	//getters ans setters
	
	public double getRegisteredWetlands() {
		return registeredWetlands;
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