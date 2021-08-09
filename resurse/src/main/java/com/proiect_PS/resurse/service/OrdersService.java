package com.proiect_PS.resurse.service;


import com.proiect_PS.resurse.model.Orders;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface OrdersService {
    Orders saveOrder(Orders order);
    List<Orders> getAllOrders();
}
