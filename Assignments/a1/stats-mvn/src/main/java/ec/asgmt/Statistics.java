package ec.asgmt;

/**

Statistics is an interface that defines methods for performing simple descriptive statistics
operations on a collection of data values.
@author Mohammed Sohail Ahmed 
@version 1.0
@since 2024-01-25 */

public interface Statistics {
	/**
	
	Adds a data value to the data structure and updates the statistics values.
	@param value a double value to be added */
	public void addData(double value);
	
	/** 
	
	Computes the statistics values from the data structure by one loop and resets the instance variables. */
	public void stats();
	
	/**
	
	Returns the number of data values in the data structure.
	@return an int value representing the count */
	public double getCount();
	
	/**
	
	Returns the minimum value among the data values in the data structure.
	@return a double value representing the minimum */
	public double getMin();
	
	/**
	
	Returns the maximum value among the data values in the data structure.
	@return a double value representing the maximum */
	public double getMax();
	
	/**
	
	Returns the average value of the data values in the data structure.
	@return a double value representing the mean */
	public double getMean();
	
	/**
	
	Returns the standard deviation of the data values in the data structure.
	@return a double value representing the standard deviation */
	public double getSTD();
}
