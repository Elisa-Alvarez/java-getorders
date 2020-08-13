package localhost.ealambdaschool.orders.services;

import localhost.ealambdaschool.orders.models.Customer;
import localhost.ealambdaschool.orders.repo.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityNotFoundException;
import java.util.ArrayList;
import java.util.List;

@Service(value = "CustomerServices")
public class CustomerServiceImpl implements CustomerServices
{
    @Autowired
   private CustomerRepository custrepos;


    @Override
    public List<Customer> findAllCustomerOrders() {
        List<Customer> list = new ArrayList<>();
        custrepos.findAll().iterator().forEachRemaining(list::add);
        return list;
    }


    @Override
    public Customer findByCustomerId(long custcode) {
        return custrepos.findById(custcode)
                .orElseThrow(() -> new EntityNotFoundException("Customer " + custcode + " Not Found!"));

    }

    @Override
    public List<Customer> findAllCustomersByNameLike(String custname)
    {
        return custrepos.findByCustnameContainingIgnoringCase(custname);
    }

    @Override
    public Customer save(Customer customer){

        return custrepos.save(customer);
    }
}