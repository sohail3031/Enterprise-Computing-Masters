package ec.asgmt;

import static org.junit.Assert.assertEquals;
import org.junit.Before;
import org.junit.Test;

public class StatisticsTest {
	ECStatistics stats;
	
	@Before
	public void setUp() {
		stats = new ECStatistics();
	}
	
	@Test
	public void testAddData() {
		stats.addData(10.0);
		stats.addData(20.0);
		stats.addData(30.0);
		
		assertEquals(3, stats.getCount(), 0.001);
		assertEquals(10.0, stats.getMin(), 0.001);
		assertEquals(30.0, stats.getMax(), 0.001);
		assertEquals(20.0, stats.getMean(), 0.001);
		assertEquals(8.16496580927726, stats.getSTD(), 0.001);
	}
	
	@Test
	public void testStats() {
		stats.addData(10.0);
		stats.addData(20.0);
		stats.addData(30.0);
		
		stats.ds.set(0, 15.0);
		stats.ds.set(1, 25.0);
		stats.ds.set(2, 35.0);

		stats.stats();

		assertEquals(3, stats.getCount(), 0.001);
		assertEquals(15.0, stats.getMin(), 0.001);
		assertEquals(35.0, stats.getMax(), 0.001);
		assertEquals(25.0, stats.getMean(), 0.001);
		assertEquals(125.0, stats.getSTD(), 0.001);
	}
}
