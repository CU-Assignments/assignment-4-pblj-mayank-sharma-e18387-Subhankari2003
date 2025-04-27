// Easy/EmployeeManagement.java
import java.util.ArrayList;
import java.util.Scanner;

class Employee {
    int id;
    String name;
    String department;

    Employee(int id, String name, String department) {
        this.id = id;
        this.name = name;
        this.department = department;
    }

    void displayDetails() {
        System.out.println("ID: " + id + ", Name: " + name + ", Department: " + department);
    }
}

public class EmployeeManagement {
    public static void main(String[] args) {
        ArrayList<Employee> employees = new ArrayList<>();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("\n1. Add Employee\n2. View Employees\n3. Exit");
            System.out.print("Choose option: ");
            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            if (choice == 1) {
                System.out.print("Enter ID: ");
                int id = scanner.nextInt();
                scanner.nextLine();
                System.out.print("Enter Name: ");
                String name = scanner.nextLine();
                System.out.print("Enter Department: ");
                String department = scanner.nextLine();
                employees.add(new Employee(id, name, department));
            } else if (choice == 2) {
                System.out.println("Employee List:");
                for (Employee emp : employees) {
                    emp.displayDetails();
                }
            } else if (choice == 3) {
                System.out.println("Exiting...");
                break;
            } else {
                System.out.println("Invalid option. Try again.");
            }
        }
        scanner.close();
    }
}
