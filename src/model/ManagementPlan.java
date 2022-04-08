package model;
public class ManagementPlan {

	/**
	*  var to save the percentaje of fulfillment of the management plan
	* */
	private double fulfillmentPercentage;
	
	/**
	* Description: constructor for ManagementPlan
	*<b> pre:</b> fulfillmentPercentage must be declared
	*@param newFulfillmentPercentage double, must between 0 and 100
	*/
	public ManagementPlan(double NewFulfillmentPercentage){
		fulfillmentPercentage=NewFulfillmentPercentage;
	}
	
	/**
	* Description: String to represent the object
	*<b> pre:</b> fulfillmentPercentage must be initialized
	*@return String, ManagementPlan format
	*/
	public String toString(){
		return "Fulfilment Percentage: "+ fulfillmentPercentage;
	}


	public double getFulfillmentPercentage() {
		return fulfillmentPercentage;
	}

	public void setFulfillmentPercentage(double newFulfillmentPercentage) {
		fulfillmentPercentage = newFulfillmentPercentage;
	}
	
}