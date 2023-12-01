import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class queueImplementation {
    public static void main(String[] args) {
    
        Queue<Integer> queue = new LinkedList<>();
        Scanner scanner = new Scanner(System.in);

        while (true) {        
            System.out.println("Choose an option:");
            System.out.println("1. Enqueue");
            System.out.println("2. Dequeue");
            System.out.println("3. IsEmpty");
            System.out.println("4. Size");
            System.out.println("5. Exit");

            int choice = scanner.nextInt();

            if (choice == 1) {
                System.out.println("Enter the item to enqueue:");
                int item = scanner.nextInt();
                queue.add(item);
                System.out.println("Item enqueued successfully.");
            } else if (choice == 2) {
                if (!queue.isEmpty()) {
                    int dequeuedItem = queue.poll();
                    System.out.println("Dequeued item: " + dequeuedItem);
                } else {
                    System.out.println("Queue is empty. Cannot dequeue.");
                }
            } else if (choice == 3) {
                boolean isEmpty = queue.isEmpty();
                System.out.println("Is Queue Empty: " + isEmpty);
            } else if (choice == 4) {
                int size = queue.size();
                System.out.println("Queue Size: " + size);
            } else if (choice == 5) {
                System.out.println("Program exited...");
                break;
            } else {
                System.out.println("Invalid choice. Please choose a valid option.");
            }
        }

        scanner.close();
    }
}
