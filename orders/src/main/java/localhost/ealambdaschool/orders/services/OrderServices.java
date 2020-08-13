package localhost.ealambdaschool.orders.services;

import localhost.ealambdaschool.orders.models.Order;

import java.util.List;

public interface OrderServices {

        Order findOrderById(long id);

        Order save(Order order);

        List<Order> findAdvanceAmount(double advanceamount);

}
