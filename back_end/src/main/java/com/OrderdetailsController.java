package com;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.dao.CustomerDAO;
import com.dao.OrderDAO;
import com.dao.OrderDetailsDAO;
import com.model.OrderDetails;
import com.model.Orders;

@RestController
public class OrderdetailsController {
	@Autowired
	OrderDetailsDAO orderDetailsDao = new OrderDetailsDAO();
	
	
	@PostMapping("/registerOrderDetails")
	public OrderDetails registerOrderDetails(@RequestBody OrderDetails orderDetails) {
		
		System.out.println("Recieved Register Order : "+orderDetails);
		return orderDetailsDao.registerOrderDetails(orderDetails);
		

	}

}
