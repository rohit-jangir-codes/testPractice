public enum Status { MOVING, IDLE }
public enum Direction { UP, DOWN, IDLE }

public class Request {
    int floor;
    Direction direction; // UP/DOWN for Hall requests, IDLE for Car requests

    public Request(int floor, Direction dir) {
        this.floor = floor;
        this.direction = dir;
    }
}
public class ElevatorController {
    int id;
    int currentFloor;
    Direction currentDirection;
    Status status;

    // Priority Queues for "LOOK" algorithm
    PriorityQueue<Integer> upQueue;
    PriorityQueue<Integer> downQueue;

    public ElevatorController(int id) {
        this.id = id;
        this.currentDirection = Direction.IDLE;
        this.status = Status.IDLE;
        this.upQueue = new PriorityQueue<>(); // 1, 2, 3...
        this.downQueue = new PriorityQueue<>((a, b) -> b - a); // 10, 9, 8...
    }

    public void addRequest(int floor) {
        if (floor > currentFloor) {
            upQueue.add(floor);
        } else {
            downQueue.add(floor);
        }
        // If IDLE, decide direction immediately
        if (currentDirection == Direction.IDLE) {
            currentDirection = (floor > currentFloor) ? Direction.UP : Direction.DOWN;
            status = Status.MOVING;
        }
    }

    public void move() {
        // Logic to move floor-by-floor and check queues
        // Simplified for study guide:
        if (currentDirection == Direction.UP && !upQueue.isEmpty()) {
            int nextStop = upQueue.peek();
            if (currentFloor == nextStop) {
                upQueue.poll();
                System.out.println("Stopped at " + currentFloor);
            } else {
                currentFloor++;
            }
        }
        // Handle switching direction when queue is empty...
    }
}

public class ElevatorSystem {
    List<ElevatorController> elevators;

    // Simple Strategy: Odd/Even or Nearest Idle
    public void handleExternalRequest(int floor, Direction direction) {
        ElevatorController bestElevator = findBestElevator(floor, direction);
        bestElevator.addRequest(floor);
    }

    private ElevatorController findBestElevator(int floor, Direction direction) {
        // Optimization logic: Find elevator moving in same direction
        // that hasn't passed the floor yet.
        return elevators.get(0); // Placeholder
    }
}


boolean reserveInventory(String productId) {
    reserveInventory.reserve("productId:"+productId);
}

interface InventoryService {
    boolean reserve(String productId);
    void release(String productId);
}