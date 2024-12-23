import java.io.*;
import java.util.*;

public class CustomerManagement {
    private final String FILE_NAME = "customers.txt";
    private final List<Customer> customers;
    private final Set<String> emails;
    private final Set<String> phones;
    private final Map<String, Customer> customerMap;
    private final Stack<Customer> deleteStack;

    public CustomerManagement() {
        customers = new ArrayList<>();
        emails = new HashSet<>();
        phones = new HashSet<>();
        customerMap = new HashMap<>();
        deleteStack = new Stack<>();
        loadCustomersFromFile();
    }

    private String isValidEmail(String email, String type) {
        if (!email.matches("^[\\w-.]+@[\\w-]+\\.[a-z]{2,}$") && !type.equals("update")) {
            return "Invalid email format. Please try again.";
        } else if (email.isEmpty() && !type.equals("update")) {
            return "Email cannot be empty. Please try again.";
        }
        if (type.equals("add") && emails.contains(email)) {
            return "Email is already in use. Please choose another one.";
        }
        return null;
    }

    private String isValidPhone(String phone, String type) {
        if (!phone.matches("\\d{10}") && !type.equals("update")) {
            return "Invalid phone format. Please try again.";
        } else if (phone.isEmpty() && !type.equals("update")) {
            return "Phone cannot be empty. Please try again.";
        }
        if (type.equals("add") && phones.contains(phone)) {
            return "Phone is already in use. Please choose another one.";
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
                    Customer customer = new Customer(customerData[0], customerData[1], customerData[2]);
                    customers.add(customer);
                    emails.add(customer.getEmail());
                    phones.add(customer.getPhone());
                    customerMap.put(customer.getPhone(), customer);
                }
            }
        } catch (IOException ex) {
            System.out.println("Failed to load customers." + ex.getMessage());
        }
    }

    public void getAllCustomers() {
        if (customers.isEmpty()) {
            System.out.println("No customers found.");
        } else {
            System.out.println("====== Customers List ======");
            for (int i = 0; i < customers.size(); i++) {
                Customer customer = customers.get(i);
                System.out.println(i + ". " + "\n" + " Name: " + customer.getName() + "\n" + " Email: " + customer.getEmail() + "\n" + " Phone: " + customer.getPhone());
                System.out.println("--------------------------");
            }
        }
    }

    public void saveCustomerToFile(Customer customer) {
        try (BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(FILE_NAME, true))) {
            bufferedWriter.write(customer.getName() + "," + customer.getEmail() + "," + customer.getPhone());
            bufferedWriter.newLine();
        } catch (IOException ex) {
            System.out.println("Failed to save customers." + ex.getMessage());
        }
    }

    public void updateCustomerInFile(String phone, String newName, String newEmail, String newPhone) {
        try {
            File tempFile = new File("temp_customers.txt");
            try (RandomAccessFile randomAccessFile = new RandomAccessFile(FILE_NAME, "r");
                 BufferedWriter writer = new BufferedWriter(new FileWriter(tempFile))) {
                String line;
                while ((line = randomAccessFile.readLine()) != null) {
                    String[] parts = line.split(",");
                    if (parts.length == 3 && parts[2].trim().equals(phone)) {
                        writer.write(newName + "," + newEmail + "," + newPhone);
                    } else {
                        writer.write(line);
                    }
                    writer.newLine();
                }
            }
            File originalFile = new File(FILE_NAME);
            originalFile.delete();
            tempFile.renameTo(originalFile);
        } catch (IOException ex) {
            System.out.println("Failed to update customer information: " + ex.getMessage());
        }
    }

    public void deleteCustomerFromFile(String phone) {
        try {
            File tempFile = new File("temp_customers.txt");
            try (RandomAccessFile randomAccessFile = new RandomAccessFile(FILE_NAME, "r");
                 BufferedWriter writer = new BufferedWriter(new FileWriter(tempFile))) {
                String line;
                while ((line = randomAccessFile.readLine()) != null) {
                    String[] parts = line.split(",");
                    if (parts.length == 3 && !parts[2].trim().equals(phone)) {
                        writer.write(line);
                        writer.newLine();
                    }
                }
            }
            File originalFile = new File(FILE_NAME);
            originalFile.delete();
            tempFile.renameTo(originalFile);
        } catch (IOException ex) {
            System.out.println("Failed to delete customer information: " + ex.getMessage());
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
            System.out.print("Enter customer phone (10 digits): ");
            phone = scanner.nextLine().trim();
            String validatePhone = isValidPhone(phone, "add");
            if (validatePhone != null) {
                System.out.println(validatePhone);
                continue;
            }
            break;
        }
        Customer newCustomer = new Customer(name, email, phone);
        customers.add(newCustomer);
        emails.add(email);
        phones.add(phone);
        customerMap.put(phone, newCustomer);
        saveCustomerToFile(newCustomer);
        System.out.println("Customer added successfully.");
    }

    public void editCustomerByPhone() {
        Scanner scanner = new Scanner(System.in);
        String phone;
        while (true) {
            System.out.print("Enter customer phone to edit (10 digits): ");
            phone = scanner.nextLine().trim();
            String validatePhone = isValidPhone(phone, "find");
            if (validatePhone != null) {
                System.out.println(validatePhone);
            } else {
                break;
            }
        }

        Customer customer = customerMap.get(phone);
        if (customer != null) {
            System.out.println("Editing customer: " + "\n" + " Name: " + customer.getName() + "\n" + " Email: " + customer.getEmail() + "\n" + " Phone: " + customer.getPhone());
            System.out.println("--------------------------");
            String updatedName, updatedEmail, updatedPhone;
            System.out.print("Enter new name (Keep empty to use old name): ");
            updatedName = scanner.nextLine().trim();

            if (updatedName.isEmpty()) {
                updatedName = customer.getName();
            }

            while (true){
                System.out.print("Enter new email (Keep empty to use old email): ");
                updatedEmail = scanner.nextLine().trim();
                if (updatedEmail.isEmpty()) {
                    updatedEmail = customer.getEmail();
                } else {
                    String validateEmail = isValidEmail(updatedEmail, "update");
                    if (validateEmail != null) {
                        System.out.println(validateEmail);
                        continue;
                    }
                }
                break;
            }

            while (true){
                System.out.print("Enter new phone (10 digits or keep empty to use old phone): ");
                updatedPhone = scanner.nextLine().trim();
                if (updatedPhone.isEmpty()) {
                    updatedPhone = customer.getPhone();
                } else {
                    String validatePhone = isValidPhone(updatedPhone, "update");
                    if (validatePhone != null) {
                        System.out.println(validatePhone);
                        continue;
                    }
                }
                break;
            }

            customer.setName(updatedName);
            customer.setEmail(updatedEmail);
            customer.setPhone(updatedPhone);
            updateCustomerInFile(phone, updatedName, updatedEmail, updatedPhone);
            System.out.println("Customer information updated successfully.");
        } else {
            System.out.println("Customer not found.");
        }
    }

    public void findCustomerByPhone() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter customer phone to search (10 digits): ");
        String phone = scanner.nextLine().trim();
        Customer customer = customerMap.get(phone);
        if (customer != null) {
            System.out.println("Customer found" + "\n" + " Name: " + customer.getName() + "\n" + " Email: " + customer.getEmail() + "\n" + " Phone: " + customer.getPhone());
            System.out.println("--------------------------");
        } else {
            System.out.println("Customer not found.");
        }
    }

    public void deleteCustomerByPhone() {
        Scanner scanner = new Scanner(System.in);
        String phone;
        while (true) {
            System.out.print("Enter customer phone to delete (10 digits): ");
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
                deleteStack.push(customer);
                System.out.println("Customer: " + "\n" + " Name: " + customer.getName() + "\n" + " Email: " + customer.getEmail() + "\n" + " Phone: " + customer.getPhone());
                System.out.println("--------------------------");
                System.out.print("Are you sure you want to delete this customer? (Y/N): ");
                String confirmation = scanner.nextLine().trim().toLowerCase();
                if (confirmation.equals("y")) {
                    iterator.remove();
                    deleteCustomerFromFile(phone);
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

    public void undoLastDelete() {
        Scanner scanner = new Scanner(System.in);
        if (deleteStack.isEmpty()) {
            System.out.println("Nothing to undo.");
        } else {
            System.out.print("Are you sure you want to undo last delete? (Y/N): ");
            String confirmation = scanner.nextLine().trim().toLowerCase();
            if (confirmation.equals("y")) {
                Customer lastDeletedCustomer = deleteStack.pop();
                customerMap.put(lastDeletedCustomer.getPhone(), lastDeletedCustomer);
                saveCustomerToFile(lastDeletedCustomer);
                System.out.println("Last delete undone successfully.");
            } else {
                System.out.println("Undo cancelled.");
            }
        }
    }

    public void batchAddCustomer() {
        Scanner scanner = new Scanner(System.in);
        int quantity;
        while (true) {
            System.out.print("Enter the number of customers to add: ");
            if (scanner.hasNextInt()) {
                quantity = scanner.nextInt();
                scanner.nextLine();
                if (quantity > 0) {
                    break;
                } else {
                    System.out.println("Please enter a positive number.");
                }
            } else {
                System.out.println("Invalid input. Please enter a valid number.");
                scanner.next();
            }
        }
        System.out.println("Adding " + quantity + " customers...");
        addRandomCustomers(quantity);
    }


    public void addRandomCustomers(int quantity) {
        Random random = new Random();
        for (int i = 0; i < quantity; i++) {
            String name = "Customer" + (customers.size() + 1);
            String email;
            String phone;

            do {
                email = "customer" + UUID.randomUUID() + "@example.com";
            } while (emails.contains(email));

            do {
                phone = String.format("%010d", random.nextInt(900000000) + 100000000);
            } while (phones.contains(phone));

            Customer newCustomer = new Customer(name, email, phone);
            customers.add(newCustomer);
            emails.add(email);
            phones.add(phone);
            customerMap.put(phone, newCustomer);
            saveCustomerToFile(newCustomer);
            System.out.println(i);
        }
        System.out.println(quantity + " customers added successfully.");
    }

}