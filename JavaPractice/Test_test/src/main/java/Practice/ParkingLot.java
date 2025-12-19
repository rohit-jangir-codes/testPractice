public enum VehicleType{CAR, TRUCK, MOTORCYCLE}
public enum ParkingSpotType {COMPACT, LARGE, MOTORCYCLE}

public abstract class Vehicle{
    private String licensePlate;
    private VehicleType vehicleType;
    public Vehicle(VehicleType vehicleType) {
        this.vehicleType = vehicleType;
    }

    public class Car extends Vehicle{
        public Car(){super(VehicleType.CAR);}
    }
}

public abstract class ParkingLot{
    private String id;
    private boolean isFree;
    private Vehicle vehicle;
    private ParkingSpotType parkingSpotType;

    public boolean assignVehicle(Vehicle vehicle){
        this.vehicle = vehicle;
        this.isFree = false;
        return true;
    }

    public boolean removeVehicle() {
        this.vehicle = null;
        this.isFree = true;
        return true;
    }

    public class CompactSpot extends ParkingSpotType {
        public CompactSpot(){super(ParkingSpotType.COMPACT);}
    }

    public class ParkingLot{
        private static parkingLot instance = null;
        private List<ParkingFloor> floors;
        private List<EntryGate> entryGates;
        private List<ExitGate> exitGates;

        private ParkingLot() {
            floors=new ArrayList<>();
        }

        public static ParkingLot getInstance(){
            if(instance==null){
                instance = new ParkingLot();
            }
            return instance;
        }

        public Ticket getNewTicket(Vehicle vehicle) {
            if (this.isFull(vehicle.getType())) {
                throw new RunTimeException();
            }

            ParkingStrategy strategy = new NearestSpotStrategy();
            ParkingSpot spot = strategy.findSpot(vehicle.getType());
            Ticket ticket = new Ticket();
            ticket.setSpot(spot);
            spot.assignVehicle(vehicle);
            return ticket;
        }
    }

}