package model;
public class Event {

	/**
	*  var to save the type
	* */
	private String type;
	
	/**
	*  var to save the description
	* */
	private String description;
	
	/**
	*  var to save the organizer
	* */
	private String clientName;
	
	/**
	*  var to save the total cost
	* */
	private double price;
	
	/**
	* Description: constructor for Event
	*<b> pre:</b> type must be declared
	*<b> pre:</b> description must be declared
	*<b> pre:</b> clientName must be declared
	*<b> pre:</b> price must be declared
	* @param newType String, must not be empty
	* @param newDescription String, must not be empty
	* @param newClientName String, must not be empty
	* @param newPrice String, must be bigger than 0
	*/
	public Event(String newType, String newDescription, String newClientName, double newPrice){
		type=newType;
		description=newDescription;
		clientName=newClientName;
		price=newPrice;
	}
	
	/**
	* Description: String to represent the object
	*<b> pre:</b> type must be initialized
	*<b> pre:</b> description must be initialized
	*<b> pre:</b> clientName must be initialized
	*<b> pre:</b> price must be initialized
	*@return String, event format
	*/
	public String toString(){
		return "Type: "+ type  +"\nDescription: "+ description +"\nclient: "+ clientName +"\nPrice: "+ price;
	}

	
	
	public String getType() {
		return type;
	}

	public String getDescription() {
		return description;
	}

	public String getClientName() {
		return clientName;
	}

	public double getPrice() {
		return price;
	}

	public void setType(String newType) {
		type = newType;
	}

	public void setDescription(String newDescription) {
		description = newDescription;
	}

	public void setClientName(String newClientName) {
		clientName = newClientName;
	}

	public void setPrice(double newPrice) {
		price = newPrice;
	}

}