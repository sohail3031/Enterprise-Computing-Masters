package ec.asgmt;

import java.util.ArrayList;

/**

ECStatistics is a class that implements the Statistics interface and provides the implementation details
for the interface methods. It uses an ArrayList of Double type to store the data values, and five instance variables
to store the count, min, max, mean, and std values.
@author Mohammed Sohail Ahmed
@version 1.0
@since 2024-01-25 */

public class ECStatistics implements Statistics {
	public ArrayList<Double> ds;
	public double count, min, max, mean, std;
	
	/**
	
	Creates an ECStatistics object and initializes the instance variables with default values. */
	public ECStatistics() {
		// TODO Auto-generated constructor stub
		ds = new ArrayList<Double>();
		
		count = 0;
		min = Double.MAX_VALUE;
		max = Double.MIN_VALUE;
		mean = 0;
		std = 0;
	}

	/**
	
	{@inheritDoc}
	Updates the statistics values using incremental algorithms, which are formulas that use the existing values
	to calculate the new values, without having to traverse the entire data structure. */ 
	@Override
	public void addData(double value) {
		// TODO Auto-generated method stub
		ds.add(value);
		
		count++;
		min = Math.min(min, value);
		max = Math.max(max, value);
		
		double oldMean = mean;
		
		mean = mean + (value - mean) / count;
		std = Math.sqrt(((count - 1) * std * std + (value - oldMean) * (value - mean)) / count);
	}

	/**
	
	{@inheritDoc}
	Computes the statistics values from the ArrayList by one loop, and resets the instance variables with the computed values. */ 
	@Override
	public void stats() {
		// TODO Auto-generated method stub
		int count1 = 0;
		double min1 = Double.MAX_VALUE, max1 = Double.MIN_VALUE, mean1 = 0, std1 = 0;
		
		for (double x : ds) {
			count1++;
			
			min1 = Math.min(min1, x);
			max1 = Math.max(max1, x);
			
			double oleMean = mean1 + (x - mean1) / count1;
			
			mean1 = mean1 + (x - mean1) / count1;
			std1 = std1 + (x - mean1) * (x - oleMean);
		}
		
		count = count1;
		min = min1;
		max = max1;
		mean = mean1;
		std = std1;
	}

	/**
	{@inheritDoc}
	Returns the count */
	@Override
	public double getCount() {
		// TODO Auto-generated method stub
		return count;
	}

	/**
	
	{@inheritDoc}
	Returns the minimum value */
	@Override
	public double getMin() {
		// TODO Auto-generated method stub
		return min;
	}

	/**
	
	{@inheritDoc}
	Returns the maximum value */
	@Override
	public double getMax() {
		// TODO Auto-generated method stub
		return max;
	}

	/**
	{@inheritDoc} */
	@Override
	public double getMean() {
		// TODO Auto-generated method stub
		return mean;
	}

	/**
	
	{@inheritDoc}
	Returns the standard deviation value */
	@Override
	public double getSTD() {
		// TODO Auto-generated method stub
		return std;
	}
	
}
