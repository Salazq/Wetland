package model;

/** Event Class - Wetland Program
 *@author JuanSalazar
 * */
public class Event {

	/**
	*  var to save the description
	* 
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
	*  var to save the date
	* */
	private Date date;
	
	/**
	*  var to save the type
	* */
	private EventType type;
	
	/**
	* Description: constructor for Event
	*<b> pre:</b> type must be declared
	*<b> pre:</b> description must be declared
	*<b> pre:</b> clientName must be declared
	*<b> pre:</b> price must be declared
	* @param newType EventType, must not be null
	* @param newDescription String, must not be empty
	* @param newClientName String, must not be empty
	* @param newPrice double, must be bigger than 0
	* @param newDate Date, must 
	*/
	public Event(EventType newType, String newDescription, String newClientName, double newPrice, Date newDate){
		description=newDescription;
		clientName=newClientName;
		price=newPrice;
		date=newDate;
		type=newType;
	}
	
	/**
	* Description: String to represent the object
	*<b> pre:</b> type must be initialized
	*<b> pre:</b> description must be initialized
	*<b> pre:</b> clientName must be initialized
	*<b> pre:</b> price must be initialized
	*<b> pre:</b> date must be initialized
	*@return String, event format
	*/
	public String toString(){
		return "\nType: "+ type  +"\nDescription: "+ description +"\nclient: "+ clientName +"\nPrice: " + price +"\nDate: "+ date ;
	}

	//getterS and setters
	public String getDescription() {
		return description;
	}

	public String getClientName() {
		return clientName;
	}

	public double getPrice() {
		return price;
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