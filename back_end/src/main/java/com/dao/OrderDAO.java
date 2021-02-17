package com.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.model.Orders;

@Service
public class OrderDAO {
	
	@Autowired
	private OrderRepository orderRepository;
	
	public Orders registerOrders(Orders orders) {
		return orderRepository.save(orders);
	}
	

}
