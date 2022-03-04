package service;


import com.sun.jdi.connect.IllegalConnectorArgumentsException;
import model.Customer;


import java.util.*;

public class CustomerService {

    private static  CustomerService INSTANCE;

    public static CustomerService getInstance() {
        if (INSTANCE ==null) {
            INSTANCE = new CustomerService();
        }
        return INSTANCE;
    }

    public Map<String, Customer> customerMap = new HashMap<>();
    //ArrayList<Customer> customer = new ArrayList<Customer>();


    public Customer addCustomer(String email, String firstName,String lastName) {

        Customer newCustomer = new Customer(email, firstName, lastName);
        customerMap.putIfAbsent(email, newCustomer);
        return newCustomer;
    }

    public Customer getCustomer(String customerEmail) {

        return customerMap.get(customerEmail);
    }

    public Collection<Customer> getAllCustomers() {

        return customerMap.values();
    }

}

