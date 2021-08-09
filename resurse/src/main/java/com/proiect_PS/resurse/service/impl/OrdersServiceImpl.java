package com.proiect_PS.resurse.service.impl;

import com.proiect_PS.resurse.model.Orders;
import com.proiect_PS.resurse.repository.OrderRepository;
import com.proiect_PS.resurse.repository.ProductRepository;
import com.proiect_PS.resurse.service.OrdersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrdersServiceImpl implements OrdersService {

    @Autowired
    private OrderRepository orderRepository;
    @Override
    public Orders saveOrder(Orders order) {
        return orderRepository.save(order);
    }

    @Override
    public List<Orders> getAllOrders() {
        return (List<Orders>) orderRepository.findAll();
    }

}
