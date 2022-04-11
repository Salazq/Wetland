package model;

/** Species Class - Wetland Program
 *@author JuanSalazar
 * */
public class Species {

	/**
	*  var to save the name
	* */
	private String name;
	
	/**
	*  var to save the scientific name
	* */
	private String scientificName;
	
	/**
	*  var to save the type
	* */
	private SpeciesType type;
	
	/**
	*  var to save the migratory condition 
	* */
	private boolean isMigratory;
	
	/**
	* Description: constructor for Species
	*<b> pre:</b> name must be declared
	*<b> pre:</b> scientificName must be declared
	*<b> pre:</b> isMigratory must be declared
	*<b> pre:</b> type must be declared
	* @param newName String, must not be empty 
	* @param newScientificName String , must not be empty
	* @param newType SpeciesType, must not be null
	* @param newIsMigratory boolean, must not be initialized
	*/
	public Species(String newName, String newScientificName, SpeciesType newType, boolean newIsMigratory){
		name= newName;
		scientificName= newScientificName;
		isMigratory= newIsMigratory;
		type= newType;
	}
	
	
	/**
	* Description: String to represent the object
	*<b> pre:</b> name must be initialized
	*<b> pre:</b> scientific must be initialized
	*<b> pre:</b> type must be initialized
	*<b> pre:</b> isMigratory must be initialized
	*@return String, Species format
	*/
	public String toString(){
		return "Name: "+ name +"\n Scientific name: "+ scientificName +"\n type: "+ type +"\n Migratory: "+ isMigratory;
	}
	
	//getters and setters
	public String getName() {
		return name;
	}

	public SpeciesType getType() {
		return type;
	}

	public String getScientificName() {
		return scientificName;
	}

	public boolean getIsMigratory() {
		return isMigratory;
	}

	public void setName(String newName) {
		name = newName;
	}

	public void setScientificName(String newScientificName) {
		scientificName = newScientificName;
	}

	public void setIsMigratory(boolean newIsMigratory) {
		isMigratory = newIsMigratory;
	}

	public void setType(SpeciesType newType) {
		type = newType;
	}

}