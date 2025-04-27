// Medium/CardCollection.java
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class CardCollection {
    public static void main(String[] args) {
        HashMap<String, String> cards = new HashMap<>();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("\n1. Add Card\n2. View Cards\n3. Search Card\n4. Exit");
            System.out.print("Choose option: ");
            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            if (choice == 1) {
                System.out.print("Enter Card Name: ");
                String name = scanner.nextLine();
                System.out.print("Enter Card Description: ");
                String description = scanner.nextLine();
                cards.put(name, description);
            } else if (choice == 2) {
                System.out.println("Cards in Collection:");
                for (Map.Entry<String, String> entry : cards.entrySet()) {
                    System.out.println("Name: " + entry.getKey() + ", Description: " + entry.getValue());
                }
            } else if (choice == 3) {
                System.out.print("Enter Card Name to Search: ");
                String searchName = scanner.nextLine();
                if (cards.containsKey(searchName)) {
                    System.out.println("Description: " + cards.get(searchName));
                } else {
                    System.out.println("Card not found.");
                }
            } else if (choice == 4) {
                System.out.println("Exiting...");
                break;
            } else {
                System.out.println("Invalid option. Try again.");
            }
        }
        scanner.close();
    }
}
