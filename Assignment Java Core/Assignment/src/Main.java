import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        CustomerManagement customerManagement = new CustomerManagement();
        Scanner scanner = new Scanner(System.in);
        while (true) {
            int choice;
            System.out.println("Welcome to the Customer Management System");
            System.out.println("1. All Customers");
            System.out.println("2. Add Customer");
            System.out.println("3. Search Customer");
            System.out.println("4. Edit Customer");
            System.out.println("5. Delete Customer");
            System.out.println("6. Undo last edit");
            System.out.println("7. Undo last delete");
            System.out.println("0. Exit");
            System.out.println("Please enter your choice:");

            try {
                choice = scanner.nextInt();
                scanner.nextLine();

                switch (choice) {
                    case 1:
                        customerManagement.getAllCustomers();
                        break;
                    case 2:
                        customerManagement.addCustomer();
                        break;
                    case 3:
                        customerManagement.findCustomerByPhone();
                        break;
                    case 4:
                        customerManagement.editCustomerByPhone();
                        break;
                    case 5:
                        customerManagement.deleteCustomerByPhone();
                        break;
                    case 6:
                        customerManagement.undoLastEdit();
                        break;
                    case 7:
                        customerManagement.undoLastDelete();
                        break;
                    case 0:
                        System.out.println("See ya!");
                        return;
                    default:
                        System.out.println("Invalid choice! Please try again.");
                }
            } catch (Exception ex) {
                System.out.println("Invalid choice! Please try again." + ex.getMessage());
                scanner.nextLine();
            }
        }
    }
}