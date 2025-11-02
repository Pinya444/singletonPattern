package singletonPattern;

public class PagibigOffice {
    public static void main(String[] args) {
        // Get the single queue system instance
        CentralizedQueueSystem queueSystem = CentralizedQueueSystem.getInstance();

        // Clients get queue numbers
        queueSystem.issueQueueNumber();  // Client 1
        queueSystem.issueQueueNumber();  // Client 2
        queueSystem.issueQueueNumber();  // Client 3

        System.out.println();

        // Help Desk 1 serves a client
        queueSystem.serveNext("1");

        // Help Desk 2 serves a client (same queue!)
        queueSystem.serveNext("2");

        // Show current status
        queueSystem.displayCurrentNumber();

        System.out.println();

        // Admin decides to reset queue
        queueSystem.resetQueue(50);

        // Help Desk 3 serves next after reset
        queueSystem.serveNext("3");
    }
}
