package gradleAssignment;

import static org.junit.Assert.assertEquals;
import org.junit.Test;

public class InvoiceServiceTest {
	@Test
	public void givenDistanceAndTime_ShouldReturnTotalFare() {
		InvoiceGenerator invoiceGenerator = new InvoiceGenerator();
		double distance = 2.0;
		int time = 5;
		Double fare = invoiceGenerator.calculateFare(distance, time);
		Double cfare = 25.0;
		assertEquals(cfare, fare);
	}
	
	@Test
	public void givenLessDistanceOrTime_ShouldReturnMinFare() {
		InvoiceGenerator invoiceGenerator = new InvoiceGenerator();
		double distance = 0.1;
		int time = 1;
		Double fare = invoiceGenerator.calculateFare(distance, time);
		Double cfare = 5.0;
		assertEquals(cfare, fare);
	}
	
	/**
	 * UC 2
	 * 
	 */
	@Test
	public void givenMultipleRides_shouldReturn_TotalFare() {
		InvoiceGenerator invoiceGenerator = new InvoiceGenerator();
		Ride[] rides = { new Ride(2.0, 5),
				         new Ride(0.1, 1)
		               };
		Double fare = invoiceGenerator.calculateFare(rides);
		Double cfare = 30.0;
		assertEquals(cfare, fare);	
	}
	
}
