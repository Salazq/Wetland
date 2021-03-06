package ui;

import java.util.Scanner;
import model.WetlandArchive;


/** Main Class - Wetland Program
 * @author JuanSalazar
 * 
 * */
public class MainWetland {
	
	/**
	*  sc is the var to read inputs
	* */
	private Scanner sc;
	
	/**
	*  archive is the controller obj of the program
	* */
	private WetlandArchive archive;
	
	/**
	*  constructor of the class
	* */
	public MainWetland() {
		sc= new Scanner(System.in);
		archive= new WetlandArchive();
	}
	
	/**
	* Main mathod of the class
	** @param args String[]
	*/
	public static void main (String [] args) {
		
		System.out.println("\n***Welcome***");
		MainWetland main = new MainWetland();
		
		int option=0;
		do{
			option= main.menu();
			main.operation(option);
		}while (option!=0);
	}
	
	/**
	* Method that shows the menu of the program and recives the selection
	* @return option int, reference of the selected option
	* */
	public int menu() {
		int option;
		System.out.println("\nSelect an option\n"+ 
		                    " 1.Register a wetland\n"+
		                    " 2.Register a species\n"+
		                    " 3.Register an event\n"+
		                    " 4.Show maintenance of a wetland\n"+
		                    " 5.Show wetland with most animals\n"+
							" 6.Show wetland with less flora\n"+
							" 7.Show wetland that contain a species\n"+
							" 8.Show wetlands\n"+
		                    " 0.Exit\n");
		option = sc.nextInt();
		sc.nextLine();
		return option;
	}
	
	/**
	* Method that calls the methods to execute the selected option
	*@param option int,must be initialized
	* */
	public void operation(int option) {
		
		switch(option){
		case 0:
			System.out.println("Bye!");
			break;
			
		case 1:
			registerWetland();
			
			break;
			
		case 2:
			if (archive.getRegisteredWetlands() > 0){
				registerSpecies();
			}
			else{
				System.out.println("There are no wetlands registered");
			}
			
			break;
			
		case 3:
		
			if (archive.getRegisteredWetlands() > 0){
				registerEvent();
			}
			else{
				System.out.println("There are no wetlands registered");
			}
			
			break;

		case 4:
		
			if (archive.getRegisteredWetlands() > 0){
				showMaintenance();
			}
			else{
				System.out.println("There are no wetlands registered");
			}

			break;
		
		case 5:
		
			if (archive.getRegisteredWetlands() > 0){
				
				if (archive.getAnimals ()!=0){
					String wetlandName= archive.findMostAnimals();
					System.out.println("The wetland with most animals is: "+ wetlandName);
				}
				else{
					System.out.println("There are no animals registered");
				}
			}
			else{
				System.out.println("There are no wetlands registered");
			}

			break;
		
		case 6:
		
			if (archive.getRegisteredWetlands() > 0){
				
				if (archive.getFlora () !=0){
					String wetlandName= archive.findLessFlora();
					System.out.println("The wetland with less flora is: "+ wetlandName);
				}
				else{
					System.out.println("There are no flora species registered");
				}
			}
			else{
				System.out.println("There are no wetlands registered");
			}

			break;
			
		case 7:
			if (archive.getRegisteredWetlands() > 0){
				showSpeciesWetland();
			}
			else{
				System.out.println("There are no wetlands registered");
			}
			break;
			
		case 8:
			if (archive.getRegisteredWetlands() > 0){
				System.out.println(archive.toString());
			}
			else{
				System.out.println("There are no wetlands registered");
			}
			break;
			
		default:
			System.out.println("\nInvalid option");
		}
	}
	
	/**
	* Method that recives the inputs to create a wetland.
	* */
	public void registerWetland(){
		
		if (archive.emptyPosition() != -1){
			
			String name;
			int location;
			int type;
			double area;
			String url;
			int protectedArea;
			String locationName;
			double plan;
			
			System.out.println("Type the name");
			name= sc.nextLine();
			System.out.println("");
			
			System.out.println("Type the location (1.Urban / 2. Rural)");
			location= sc.nextInt();
			System.out.println("");
			
			System.out.println("Type the type (1.Public / 2. Private)");
			type= sc.nextInt();
			System.out.println("");
			
			System.out.println("Type the area");
			area= sc.nextDouble();
			System.out.println("");
			
			System.out.println("Type the photo's url");
			url= sc.next();
			System.out.println("");
			
			System.out.println("Is it a protected area? (1.Yes / 2.No)");
			protectedArea= sc.nextInt();
			System.out.println("");
			
			System.out.println("Type the location name");
			locationName= sc.next();
			System.out.println("");
			
			System.out.println("Type the percentage of fullfilment of the management plan");
			plan= sc.nextDouble();
			System.out.println("");
			
			archive.addWetland(name, location, type, area, url, protectedArea, locationName, plan);
			System.out.println("Wetland: "+ name + " has been registered");
			
		}
		
		else { 
		  
		  System.out.println ("\nNo more wetlands can be registered");
		}
	}
	
	/**
	* Method that recives the inputs to create a species.
	* */
	public void registerSpecies(){
		
			String name;
			String scientificName;
			int type;
			int migratory;
			String wetlandName;
			int position;
			
			System.out.println("Type wetland's name");
			wetlandName= sc.nextLine();
			System.out.println("");
			
			position=archive.searchWetland(wetlandName);
			
			if  (position != -1) {
				
				if (archive.wetlandSpeciesEmptyPosition(position) != -1){
			
					System.out.println("Type the name of the species");
					name= sc.nextLine();
					System.out.println("");
					
					System.out.println("Type the scientific name");
					scientificName= sc.nextLine();
					System.out.println("");
					
					System.out.println("Type the type\n" +
										"1. Terrestrial flora\n"+
										"2. Aquatic flora\n"+
										"3. Bird\n"+
										"4. Mammal\n"+
										"5. Aquatic animal\n");
					type= sc.nextInt();
					System.out.println("");
					
					System.out.println("Is it migratory? (1.Yes / 2.No)");
					migratory= sc.nextInt();
					System.out.println("");
					
					archive.addSpeciesToWetland(wetlandName, name, scientificName, type, migratory, position);
					System.out.println("Species: "+ name + " has been registered");
					
				}
				
				else {
					System.out.println ("\nNo more species can be registered in this wetland");
				}
			}
			else{
				 System.out.println ("\nThis wetland is not registered");
			}
	}
	
	/**
	* Method that recives the inputs to create a event.
	* */
	public void registerEvent(){
		
			int day;
			int month;
			int year;
			int type;
			String description;
			String clientName;
			String wetlandName;
			double price;
			int position;
			
			System.out.println("Type wetland's name");
			wetlandName= sc.nextLine();
			System.out.println("");
			
			position=archive.searchWetland(wetlandName);
			
			if  (position != -1) {
				
				if (archive.wetlandEventsEmptyPosition(position) != -1){
					
					System.out.println("Type the type\n" +
										"1. Maintenance\n"+
										"2. School Visits\n"+
										"3. Improvement\n"+
										"4. Celebrations\n");
					type= sc.nextInt();
					System.out.println("");
			
					System.out.println("Type the day of the event");
					day= sc.nextInt();
					System.out.println("");
					
					System.out.println("Type the month of the event");
					month= sc.nextInt();
					System.out.println("");
					
					System.out.println("Type the year of the event");
					year= sc.nextInt();
					System.out.println("");
					
					System.out.println("Type the description");
					description= sc.next();
					System.out.println("");
					
					System.out.println("Type the name of the organizer");
					clientName= sc.next();
					System.out.println("");
					
					System.out.println("Type the price");
					price= sc.nextDouble();
					System.out.println("");
					
					
					archive.addEventToWetland(type, day, month, year, description, clientName, price, position);
					System.out.println("Event has been registered");
					
				}
				
				else {
					System.out.println ("\nNo more events can be registered in this wetland");
				}
			}
			else{
				 System.out.println ("\nThis wetland is not registered");
			}
	}
	
	/**
	* Method that recives the inputs to find the wetland where a species can be found and prints the information
	* */
	public void showSpeciesWetland(){
		
			String speciesName="";
			String wetlandName="";
			
			System.out.println("Type the species name");
			speciesName= sc.nextLine();
			System.out.println("");
			
			wetlandName= archive.findSpeciesWetland(speciesName);
			
			System.out.println ("\nThis species " + wetlandName);
			
	}
	
	/**
	* Method that recives the input to find and show the number of maintenance of a wetland
	* */
	public void showMaintenance(){
		
			String wetlandName="";
			int maintenance=0;
			int position=0;
			
			System.out.println("Type the wetland name");
			wetlandName= sc.next();
			System.out.println("");
			
			position=archive.searchWetland(wetlandName);
			
			if  (position != -1) {
				
				maintenance= archive.findMaintenance(position);
				System.out.println ("\nThis wetland has had "+ maintenance + " maintenance");
				
			}
			else{
				System.out.println ("\nThis wetland is not registered");
			}
			
	}

}
		
