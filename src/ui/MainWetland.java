package ui;

import java.util.Scanner;
import model.WetlandArchive;

/** Main Class - Wetland Program
 * @author JuanSalazar
 * 
 * */


public class MainWetland {
	
	private Scanner sc;
	private WetlandArchive archive;
	
	public MainWetland() {
		sc= new Scanner(System.in);
		archive= new WetlandArchive();
	}
	
	/**
	* Creates obj and calls methods  
	** @param args String[]
	*/
	public static void main (String [] args) {
		
		System.out.println("\nWelcome");
		MainWetland main = new MainWetland();
		
		int option=0;
		do{
			option= main.menu();
			main.operation(option);
		}while (option!=0);
	}
	
	public int menu() {
		int option;
		System.out.println("\nSelect an option\n"+ 
		                    " 1.Register a wetland\n"+
		                    " 2.Register a species\n"+
		                    " 3. \n"+
		                    " 4. \n"+
		                    " 5.Show wetland with most animals\n"+
							" 6.Show wetland with less flora\n"+
							" 7. \n"+
							" 8.Show wetlands\n"+
		                    " 0.Exit\n");
		option = sc.nextInt();
		sc.nextLine();
		return option;
	}
	
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

			break;

		case 4:

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
	
	public void registerWetland(){
		
		if (archive.emptyPosition() != -1){
			
			String name;
			int location;
			int type;
			double area;
			String url;
			int protectedArea;
			String locationName;
			
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
			
			archive.addWetland(name, location, type, area, url, protectedArea, locationName);
			System.out.println("Wetland: "+ name + " has been registered");
			
		}
		
		else { 
		  
		  System.out.println ("\nNo more wetlands can be registered");
		}
	}
	
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

}
		
