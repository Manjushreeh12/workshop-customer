import java.util.*;

// Step 1: Customer JavaBean Class (non-public)
class Customer {
    private String firstName;
    private String lastName;
    private String customerId;
    private double balance;

    // Default constructor
    public Customer() {
        
    }

    // Parameterized constructor
    public Customer(String firstName, String lastName, String customerId, double balance) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.customerId = customerId;
        this.balance = balance;
    }

    // Getters and Setters
    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getCustomerId() {
        return customerId;
    }

    public void setCustomerId(String customerId) {
        this.customerId = customerId;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }
    public String toString() {
        return "Customer ID: " + customerId + ", Name: " + firstName + " " + lastName + ", Balance: " + balance;
    }
}

// Step 2: Comparator for Sorting
class CustomerComparator implements Comparator<Customer> {
    @Override
    public int compare(Customer c1, Customer c2) {
        // Compare by First Name
        int firstNameCompare = c1.getFirstName().compareTo(c2.getFirstName());
        if (firstNameCompare != 0) {
            return firstNameCompare;
        }

        // If First Name is the same, compare by Last Name
        int lastNameCompare = c1.getLastName().compareTo(c2.getLastName());
        if (lastNameCompare != 0) {
            return lastNameCompare;
        }

        // If First Name and Last Name are the same, compare by Customer ID
        int idCompare = c1.getCustomerId().compareTo(c2.getCustomerId());
        if (idCompare != 0) {
            return idCompare;
        }
        return Double.compare(c1.getBalance(), c2.getBalance());
    }
}

// Step 3: Main Class to Test the Application
public class CustomerApp {
    public static void main(String[] args) {
        // Create a list of customers
        List<Customer> customers = new ArrayList<>();

        customers.add(new Customer("John", "Doe", "C001", 1500.75));
        customers.add(new Customer("Jane", "Smith", "C002", 3000.50));
        customers.add(new Customer("Alice", "Johnson", "C003", 2500.30));
        customers.add(new Customer("John", "Smith", "C004", 1200.00));
        customers.add(new Customer("Bob", "Doe", "C005", 5000.10));

        // Print unsorted list
        System.out.println("Unsorted list of customers:");
        for (Customer customer : customers) {
            System.out.println(customer);
        }

        // Sort customers using the custom comparator
        Collections.sort(customers, new CustomerComparator());

        // Print sorted list
        System.out.println("\nSorted list of customers:");
        for (Customer customer : customers) {
            System.out.println(customer);
}
}
}
