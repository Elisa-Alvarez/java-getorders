package localhost.ealambdaschool.orders.services;

import localhost.ealambdaschool.orders.models.Customer;

import java.util.List;


public interface CustomerServices {

        List<Customer> findAllCustomerOrders();

        Customer findByCustomerId(long custcode);

        List<Customer> findAllCustomersByNameLike(String custname);

        Customer save(Customer customer);


}