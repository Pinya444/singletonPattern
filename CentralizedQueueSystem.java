package singletonPattern;

public class CentralizedQueueSystem {
    private static CentralizedQueueSystem instance;
    private int currentNumber;
    private int nextNumber;

    // Private constructor prevents external instantiation
    private CentralizedQueueSystem() {
        currentNumber = 0;
        nextNumber = 1;
    }

    // Get single instance (Singleton)
    public static synchronized CentralizedQueueSystem getInstance() {
        if (instance == null) {
            instance = new CentralizedQueueSystem();
        }
        return instance;
    }

    // Issue next queue number to a client
    public synchronized int issueQueueNumber() {
        int issued = nextNumber;
        System.out.println("Queue number " + issued + " issued to client.");
        nextNumber++;
        return issued;
    }

    // Serve next client at the help desk
    public synchronized void serveNext(String deskName) {
        if (currentNumber < nextNumber - 1) {
            currentNumber++;
            System.out.println("Help Desk " + deskName + " is now serving number " + currentNumber);
        } else {
            System.out.println("No more clients in the queue for " + deskName);
        }
    }

    // View the currently served number
    public synchronized void displayCurrentNumber() {
        System.out.println("Currently serving number: " + currentNumber);
    }

    // Reset the queue system to a specific number
    public synchronized void resetQueue(int startNumber) {
        currentNumber = startNumber;
        nextNumber = startNumber + 1;
        System.out.println("Queue has been reset. Starting from number " + startNumber);
    }
}
