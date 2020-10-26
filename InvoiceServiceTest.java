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
	
}
