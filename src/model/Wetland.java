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
	public Wetland(String newName, String newLocation, String newType, double newArea, String newUrlPhoto, boolean newProtectedArea,String newLocationName){
		name=newName;
		location=newLocation;
		type=newType;
		area=newArea;
		urlPhoto=newUrlPhoto;
		protectedArea=newProtectedArea;
		locationName= newLocationName;
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
		return "Name: "+ name +"\n Location: "+ location +"\n Type: "+ type +"\n Area: "+ area +"\n Photo: "+ urlPhoto +"\n Protected area: "+ protectedArea
		+"\n Location name: "+ locationName;
	}


	public String getName() {
		return name;
	}

	public String getLocation() {
		return location;
	}

	public String getType() {
		return type;
	}

	public double getArea() {
		return area;
	}

	public String getUrlPhoto() {
		return urlPhoto;
	}

	public boolean getProtectedArea() {
		return protectedArea;
	}

	public String getLocationName() {
		return locationName;
	}

	public void setName(String newName) {
		name = newName;
	}

	public void setLocation(String newLocation) {
		location = newLocation;
	}

	public void setType(String newType) {
		type = newType;
	}

	public void setArea(double newArea) {
		area = newArea;
	}

	public void setUrlPhoto(String newUrlPhoto) {
		
		urlPhoto=newUrlPhoto;
	}

	public void setProtectedArea(boolean newProtectedArea) {
		protectedArea = newProtectedArea;
	}

	public void setLocationName(String newLocationName) {
		locationName = newLocationName;
	}

}