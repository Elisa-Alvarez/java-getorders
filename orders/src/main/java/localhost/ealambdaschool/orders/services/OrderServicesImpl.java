package localhost.ealambdaschool.orders.services;

import localhost.ealambdaschool.orders.models.Agent;
import localhost.ealambdaschool.orders.models.Customer;
import localhost.ealambdaschool.orders.models.Order;
import localhost.ealambdaschool.orders.models.Payment;
import localhost.ealambdaschool.orders.repo.OrderRepositories;
import localhost.ealambdaschool.orders.repo.PaymentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import javax.transaction.Transactional;
import java.util.List;

@Transactional
@Service(value = "orderServices")
public class OrderServicesImpl implements OrderServices
{
    @Autowired
    OrderRepositories orderrepos;

    @Autowired
    PaymentRepository payrepo;

    @Override
    public Order findOrderById(long id)
    {
        return orderrepos.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Order " + id + " Not Found!"));
    }

    @Override
    public List<Order> findAdvanceAmount(double advanceamount)
    {
        List<Order> list = orderrepos.findAllByAdvanceamountGreaterThan(advanceamount);
        return list;
    }

    @Transactional
    @Override
    public Order save(Order order)
    {
        Order neworder = new Order();
        neworder.setOrderdescription(order.getOrderdescription());
        neworder.setCustomer(order.getCustomer());
        neworder.setAdvanceamount(order.getAdvanceamount());




        return neworder;
    }

}