import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        CustomerManagement customerManagement = new CustomerManagement();
        Scanner scanner = new Scanner(System.in);
        int choice;

        do {
            System.out.println("Welcome to the Customer Management System");
            System.out.println("1. All Customers");
            System.out.println("2. Add Customer");
            System.out.println("3. Search Customer");
            System.out.println("4. Edit Customer");
            System.out.println("5. Delete Customer");
            System.out.println("0. Exit");
            System.out.println("Please enter your choice");
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
                case 0:
                    System.out.println("See ya!");
                    break;
                default:
                    System.out.println("Invalid choice!");
                    break;
            }
        } while (choice != 0);
    }
}