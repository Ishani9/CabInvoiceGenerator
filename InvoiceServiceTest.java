package gradleAssignment;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

public class InvoiceServiceTest {
	
	InvoiceGenerator invoiceGenerator;
	InvoiceSummary expectedInvoiceSummary;
	RideRepository rideRepository;
	
	@Before
	public void setup() {
		invoiceGenerator = new InvoiceGenerator();
		expectedInvoiceSummary = new InvoiceSummary(2, 45);
		rideRepository = new RideRepository();
	}
	
	
	/**
	 * UC 3
	 * 
	 */
	@Test
	public void givenMultipleRides_shouldReturn_InvoiceSummary() {
		Ride[] rides = { new Ride(CabRide.NORMAL, 2.0, 5),
				new Ride(CabRide.PREMIUM, 0.1, 1)
             };
		InvoiceSummary summary = invoiceGenerator.calculateFare(rides);
		assertEquals(expectedInvoiceSummary, summary);
	}
	
	/**
	 * UC 4
	 * 
	 */
	@Test
	public void givenUserIDAndRides_shouldReturn_InvoiceSummary() {
		String userID = "XYZ";
		Ride[] rides = { new Ride(CabRide.NORMAL, 2.0, 5),
				new Ride(CabRide.PREMIUM, 0.1, 1)
             };
		rideRepository.addRides(userID, rides);
		invoiceGenerator.setRideRepository(rideRepository);
		InvoiceSummary summary = invoiceGenerator.getInvoiceSummary(userID);
		assertEquals(expectedInvoiceSummary, summary);
	}
	
	
	@Test
	public void given2UserIDAnd3Rides_shouldReturn_InvoiceSummary() {
		String userID1 = "ABC";
		Ride[] rides1 = { new Ride(CabRide.NORMAL, 2.0, 5),
		         new Ride(CabRide.PREMIUM, 0.1, 1),
		         new Ride(CabRide.NORMAL, 0.1, 3)
              };
		rideRepository.addRides(userID1, rides1);
		invoiceGenerator.setRideRepository(rideRepository);
		InvoiceSummary summary = invoiceGenerator.getInvoiceSummary(userID1);
		InvoiceSummary expectedInvoiceSummary = new InvoiceSummary(3, 50);
		assertEquals(expectedInvoiceSummary, summary);
		
		String userID2 = "XYZ";
		Ride[] rides2 = { new Ride(CabRide.NORMAL, 2.0, 5),
		         new Ride(CabRide.PREMIUM, 0.1, 1)
              };
		rideRepository.addRides(userID2, rides2);
		invoiceGenerator.setRideRepository(rideRepository);
		InvoiceSummary summary2 = invoiceGenerator.getInvoiceSummary(userID2);
		InvoiceSummary expectedInvoiceSummary2 = new InvoiceSummary(2, 45);
		assertEquals(expectedInvoiceSummary2, summary2);
	}
	
}
