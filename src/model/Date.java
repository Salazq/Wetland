package model;

/** Date Class - Wetland Program
 * @author JuanSalazar
 * */
public class Date {

	/**
	*  var to save the day 
	* */
	private int day;
	
	/**
	*  var to save the month
	* */
	private int month;
	
	/**
	*  var to save the year
	* */
	private int year;
	
	
	/**
	* Description: constructor for Date
	*<b> pre:</b> day must be declared
	*<b> pre:</b> month must be declared
	*<b> pre:</b> year must be declared
	* @param newDay int, must be between 1 and 31
	* @param newMonth int, must be between 1 and 31
	* @param newYear int, must be between 1 and 31
	*/
	public Date(int newDay, int newMonth, int newYear){
		day=newDay;
		month=newMonth;
		year=newYear;
	}
	
	/**
	* Description: String to represent the object
	*<b> pre:</b> day must be initialized
	*<b> pre:</b> month must be initialized
	*<b> pre:</b> year must be initialized
	*@return String, date format
	*/
	
	public String toString(){
		return day +"/"+ month +"/"+ year;
	}

}