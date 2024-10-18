import java.io.*;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

public class CustomerManagement {
    private final String FILE_NAME = "customers.txt";
    private List<Customer> customers;

    public CustomerManagement() {
        customers = new ArrayList<>();
        loadCustomersFromFile();
    }

    private String isValidEmail(String email, String type) {
        if (!email.matches("^[\\w-\\.]+@[\\w-]+\\.[a-z]{2,}$") && !type.isEmpty()) {
            return "Invalid email format. Please try again.";
        } else if (email.isEmpty() && !type.isEmpty()) {
            return "Email cannot be empty. Please try again.";
        }
        if (type.equals("add")) {
            for (Customer customer : customers) {
                if (customer.getEmail().equals(email)) {
                    return "Email is already in use. Please choose another one.";
                }
            }
        }
        return null;
    }

    private String isValidPhone(String phone, String type) {
        if (!phone.matches("\\d{10}") && !type.isEmpty()) {
            return "Invalid phone format. Please try again.";
        } else if (phone.isEmpty() && !type.isEmpty()) {
            return "Phone cannot be empty. Please try again.";
        }
        if (type.equals("add")) {
            for (Customer customer : customers) {
                if (customer.getPhone().equals(phone)) {
                    return "Phone is already in use. Please choose another one.";
                }
            }
        }
        return null;
    }

    public void loadCustomersFromFile() {
        File file = new File(FILE_NAME);
        if (!file.exists()) {
            try {
                boolean createdFile = file.createNewFile();
                if (createdFile) {
                    System.out.println("File created: " + FILE_NAME);
                } else {
                    System.out.println(FILE_NAME + " is already exists");
                }
            } catch (IOException ex) {
                System.out.println("Error creating file: " + ex.getMessage());
            }
            return;
        }
        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(FILE_NAME))) {
            String line;
            while ((line = bufferedReader.readLine()) != null) {
                String[] customerData = line.split(",");
                if (customerData.length == 3) {
                    customers.add(new Customer(customerData[0], customerData[1], customerData[2]));
                }
            }
        } catch (IOException ex) {
            System.out.println("Failed to load customers." + ex.getMessage());
        }
    }

    public void saveCustomersToFile() {
        try (BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(FILE_NAME))) {
            for (Customer customer : customers) {
                bufferedWriter.write(customer.getName() + "," + customer.getEmail() + "," + customer.getPhone());
                bufferedWriter.newLine();
            }
        } catch (IOException ex) {
            System.out.println("Failed to save customers." + ex.getMessage());
        }
    }

    public void getAllCustomers() {
        if (customers.isEmpty()) {
            System.out.println("No customers found.");
        } else {
            System.out.println("====== Customers List ======");
            for (int i = 0; i < customers.size(); i++) {
                Customer customer = customers.get(i);
                System.out.println(i + 1 + ". " + "\n" + " Name: " + customer.getName() + "\n" + " Email: " + customer.getEmail() + "\n" + " Phone: " + customer.getPhone());
                System.out.println("--------------------------");
            }
        }
    }

    public void addCustomer() {
        Scanner scanner = new Scanner(System.in);
        String name, email, phone;
        while (true) {
            System.out.print("Enter customer name: ");
            name = scanner.nextLine().trim();
            if (name.isEmpty()) {
                System.out.println("Name cannot be empty. Please try again.");
                continue;
            }
            break;
        }
        while (true) {
            System.out.print("Enter customer email: ");
            email = scanner.nextLine().trim();
            String validateEmail = isValidEmail(email, "add");
            if (validateEmail != null) {
                System.out.println(validateEmail);
                continue;
            }
            break;
        }
        while (true) {
            System.out.print("Enter customer phone: ");
            phone = scanner.nextLine().trim();
            String validatePhone = isValidPhone(phone, "add");
            if (validatePhone != null) {
                System.out.println(validatePhone);
                continue;
            }
            break;
        }
        customers.add(new Customer(name, email, phone));
        saveCustomersToFile();
        System.out.println("Customer added successfully.");
    }

    public void findCustomerByPhone() {
        Scanner scanner = new Scanner(System.in);
        String phone;
        while (true) {
            System.out.print("Enter customer phone to find: ");
            phone = scanner.nextLine().trim();
            String validatePhone = isValidPhone(phone, "find");
            if (validatePhone != null) {
                System.out.println(validatePhone);
            } else {
                break;
            }
        }

        for (Customer customer : customers) {
            if (customer.getPhone().equals(phone)) {
                System.out.println("Customer found" + "\n" + " Name: " + customer.getName() + "\n" + " Email: " + customer.getEmail() + "\n" + " Phone: " + customer.getPhone());
                System.out.println("--------------------------");
                return;
            }
        }
        System.out.println("Customer not found.");
    }

    public void editCustomerByPhone() {
        Scanner scanner = new Scanner(System.in);
        String phone;
        while (true) {
            System.out.print("Enter customer phone to edit: ");
            phone = scanner.nextLine().trim();
            String validatePhone = isValidPhone(phone, "find");
            if (validatePhone != null) {
                System.out.println(validatePhone);
            } else {
                break;
            }
        }

        for (Customer customer : customers) {
            if (customer.getPhone().equals(phone)) {
                System.out.println("Editing customer: " + "\n" + " Name: " + customer.getName() + "\n" + " Email: " + customer.getEmail() + "\n" + " Phone: " + customer.getPhone());
                System.out.println("--------------------------");
                String updatedName, updatedEmail, updatedPhone;
                System.out.print("Enter new name (Keep empty to use old name): ");
                String newName = scanner.nextLine().trim();
                updatedName = newName;
                while (true) {
                    System.out.print("Enter new email (Keep empty to use old email): ");
                    String newEmail = scanner.nextLine().trim();
                    String validateEmail = isValidEmail(newEmail, "");
                    if (validateEmail != null) {
                        System.out.println(validateEmail);
                    } else {
                        updatedEmail = newEmail;
                        break;
                    }
                }

                while (true) {
                    System.out.print("Enter new phone (Keep empty to use old phone): ");
                    String newPhone = scanner.nextLine().trim();
                    String validatePhone = isValidPhone(newPhone, "");
                    if (validatePhone != null) {
                        System.out.println(validatePhone);
                    } else {
                        updatedPhone = newPhone;
                        break;
                    }
                }

                customer.setName(updatedName);
                customer.setEmail(updatedEmail);
                customer.setPhone(updatedPhone);
                saveCustomersToFile();
                System.out.println("Customer information updated successfully.");
                return;
            }
        }
        System.out.println("Customer not found.");
    }

    public void deleteCustomerByPhone() {
        Scanner scanner = new Scanner(System.in);
        String phone;
        while (true) {
            System.out.print("Enter customer phone to delete: ");
            phone = scanner.nextLine().trim();
            String validatePhone = isValidPhone(phone, "find");

            if (validatePhone != null) {
                System.out.println(validatePhone);
            } else {
                break;
            }
        }
        boolean foundCustomer = false;
        for (Iterator<Customer> iterator = customers.iterator(); iterator.hasNext(); ) {
            Customer customer = iterator.next();
            if (customer.getPhone().equals(phone)) {

                foundCustomer = true;

                System.out.println("Customer: " + "\n" + " Name: " + customer.getName() + "\n" + " Email: " + customer.getEmail() + "\n" + " Phone: " + customer.getPhone());
                System.out.println("--------------------------");
                System.out.print("Are you sure you want to delete this customer? (yes/no): ");
                String confirmation = scanner.nextLine().trim().toLowerCase();

                if (confirmation.equals("yes")) {
                    iterator.remove();
                    saveCustomersToFile();
                    System.out.println("Customer deleted successfully.");
                } else {
                    System.out.println("Deletion cancelled.");
                }
                break;
            }
        }

        if (!foundCustomer) {
            System.out.println("Customer not found.");
        }
    }
}