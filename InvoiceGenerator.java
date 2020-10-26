package gradleAssignment;

public class InvoiceGenerator {
	
	private RideRepository rideRepository;
	
	public InvoiceGenerator() {
		rideRepository = new RideRepository();
	}
	
	
	/**
	 * UC 2, 3
	 * 
	 * @param rides
	 * @return
	 */
	public InvoiceSummary calculateFare(Ride[] rides) {
		double totalFare = 0;
		for (Ride ride : rides) {
			totalFare += ride.cabRide.calcCostOfCabRide(ride);
		}
		InvoiceSummary invoiceSummary = new InvoiceSummary(rides.length, totalFare);
		return invoiceSummary;
	}
	
	/**
	 * UC 4
	 * 
	 * @param userId
	 * @param rides
	 */
	public void addRides(String userId, Ride[] rides) {
		rideRepository.addRides(userId, rides);
	}
	
	public InvoiceSummary getInvoiceSummary(String userId) {
		return this.calculateFare(rideRepository.getRides(userId));
	}
	
	public void setRideRepository(RideRepository rideRepository) {
		this.rideRepository = rideRepository;
	}

}
