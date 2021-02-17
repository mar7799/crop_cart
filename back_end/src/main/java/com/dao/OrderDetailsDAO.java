package com.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.model.OrderDetails;
import com.model.Orders;

@Service
public class OrderDetailsDAO {
	
	@Autowired
	private OrderDetailsRepository orderDetailsRepository;
	
	public OrderDetails registerOrderDetails(OrderDetails orderDetails) {
		return orderDetailsRepository.save(orderDetails);
	}

}
