package localhost.ealambdaschool.orders.controlers;

import localhost.ealambdaschool.orders.models.Customer;
import localhost.ealambdaschool.orders.services.CustomerServices;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("customers")
public class CustomerController {

    @Autowired
    private CustomerServices customerServies;

    //http://localhost:2019/customers/orders
    @GetMapping(value = "/orders", produces = "application/json")
    public ResponseEntity<?>  listCustomerOrders()
    {
        List<Customer> myList = customerServies.findAllCustomerOrders();
        return  new ResponseEntity<>(myList, HttpStatus.OK);
    }
    // http://localhost:2019/customers/customer/7
    @GetMapping(value = "/customer/{custcode}", produces = "application/json")
    public ResponseEntity<?> findCustomerById(@PathVariable long custcode)
    {
        Customer myCustomer = customerServies.findByCustomerId(custcode);
        return new ResponseEntity<>(myCustomer, HttpStatus.OK);
    }

    // http://localhost:2019/customers/namelike/mes
    @GetMapping(value = "/namelike/{custname}", produces = "application/json")
    public ResponseEntity<?> findCustomerByNameLike(@PathVariable String custname)
    {
        List<Customer> myList = customerServies.findAllCustomersByNameLike(custname);
        return new ResponseEntity<>(myList, HttpStatus.OK);
    }

}
