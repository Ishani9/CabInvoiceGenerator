package gradleAssignment;

public class InvoiceGenerator {

	private static final double MINIMUM_COST_PER_KILOMETER = 10;
	private static final int COST_PER_TIME = 1;
	private static final double MINIMUM_FARE = 5;
	private RideRepository rideRepository;
	
	public InvoiceGenerator() {
		rideRepository = new RideRepository();
	}
	
	/**
	 * UC 1
	 * 
	 * @param distance
	 * @param time
	 * @return
	 */
	public double calculateFare(double distance, int time) {
		double totalFare = distance * MINIMUM_COST_PER_KILOMETER + time*COST_PER_TIME;
		return Math.max(MINIMUM_FARE, totalFare);
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
			totalFare = totalFare + this.calculateFare(ride.distance, ride.time);
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

}
