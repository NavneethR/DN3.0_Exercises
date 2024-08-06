package Week_1_Exercises.Design_Patterns;

import java.util.*;

interface CustomerRepository {
    Customer findCustomerById(String id);
}

class CustomerRepositoryImpl implements CustomerRepository {
    public Customer findCustomerById(String id) {
        System.out.println("Searching for customer in database...");
        return new Customer(id, "John Doe", "john.doe@example.com");
    }
}

class Customer {
    String id;
    String name;
    String email;

    public Customer(String id, String name, String email) {
        this.id = id;
        this.name = name;
        this.email = email;
    }

}

class CustomerService {
    private final CustomerRepository customerRepository;

    public CustomerService(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    public void displayCustomerById(String id) {
        Customer customer = customerRepository.findCustomerById(id);
        if (customer != null) {
            System.out.println("Customer Found:");
            System.out.println("ID: " + customer.id);
            System.out.println("Name: " + customer.name);
            System.out.println("Email: " + customer.email);
        } else {
            System.out.println("Customer not found.");
        }
    }
}

public class DependancyInjectionExample {
    public static void main(String[] args) {

        CustomerRepository repository = new CustomerRepositoryImpl();
        CustomerService service = new CustomerService(repository);

        System.out.println("Fetching customer Info...");
        service.displayCustomerById("123");
    }
}
