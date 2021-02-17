package com;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.dao.CustomerDAO;
import com.dao.OrderDAO;
import com.model.Farmer;
import com.model.Orders;

@RestController
public class OrderController {
	
	@Autowired
	OrderDAO orderDao = new OrderDAO();
	
	@Autowired
	CustomerDAO customerDao = new CustomerDAO();
	
	@PostMapping("/registerOrders")
	public Orders registerOrders(@RequestBody Orders orders) {

		return orderDao.registerOrders(orders);

	}

}
