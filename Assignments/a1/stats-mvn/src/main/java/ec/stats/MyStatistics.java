package ec.stats;

import java.util.logging.Logger;

import ec.asgmt.ECStatistics;
import ec.asgmt.Statistics;

public class MyStatistics {
	private static Logger logger = Logger.getLogger(MyStatistics.class.getName());
	
	public static void main(String[] args) {
		Statistics statistics = new ECStatistics();
		
		for (int i = 1; i <= 10000; i++) {
			statistics.addData((double) i);
		}
		
		statistics.stats();
		
		System.out.println("Count: " + statistics.getCount());
		System.out.println("Min: " + statistics.getMin());
		System.out.println("Max: " + statistics.getMax());
		System.out.println("Mean: " + statistics.getMean());
		System.out.println("STD: " + statistics.getSTD());
		
		logger.info("Statistics Method Call");
	}
}
