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
	 * UC 3
	 * 
	 */
	@Test
	public void givenMultipleRides_shouldReturn_InvoiceSummary() {
		InvoiceGenerator invoiceGenerator = new InvoiceGenerator();
		Ride[] rides = { new Ride(2.0, 5),
		         new Ride(0.1, 1)
              };
		InvoiceSummary summary = invoiceGenerator.calculateFare(rides);
		InvoiceSummary expectedInvoiceSummary = new InvoiceSummary(2, 30);
		assertEquals(expectedInvoiceSummary, summary);
	}
	
	/**
	 * UC 4
	 * 
	 */
	@Test
	public void givenUserIDAndRides_shouldReturn_InvoiceSummary() {
		InvoiceGenerator invoiceGenerator = new InvoiceGenerator();
		String userID = "XYZ";
		Ride[] rides = { new Ride(2.0, 5),
		         new Ride(0.1, 1)
              };
		invoiceGenerator.addRides(userID, rides);
		InvoiceSummary summary = invoiceGenerator.getInvoiceSummary(userID);
		InvoiceSummary expectedInvoiceSummary = new InvoiceSummary(2, 30);
		assertEquals(expectedInvoiceSummary, summary);
	}
	
	@Test
	public void given2UserIDAnd3Rides_shouldReturn_InvoiceSummary() {
		InvoiceGenerator invoiceGenerator = new InvoiceGenerator();
		String userID1 = "ABC";
		Ride[] rides1 = { new Ride(2.0, 5),
		         new Ride(0.1, 1),
		         new Ride(0.1, 3)
              };
		invoiceGenerator.addRides(userID1, rides1);
		InvoiceSummary summary = invoiceGenerator.getInvoiceSummary(userID1);
		InvoiceSummary expectedInvoiceSummary = new InvoiceSummary(3, 35);
		assertEquals(expectedInvoiceSummary, summary);
		
		String userID2 = "XYZ";
		Ride[] rides2 = { new Ride(2.0, 5),
		         new Ride(0.1, 1)
              };
		invoiceGenerator.addRides(userID2, rides2);
		InvoiceSummary summary2 = invoiceGenerator.getInvoiceSummary(userID2);
		InvoiceSummary expectedInvoiceSummary2 = new InvoiceSummary(2, 30);
		assertEquals(expectedInvoiceSummary2, summary2);
	}
	
}
