package com;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.dao.CustomerDAO;
import com.model.Customer;

@RestController
public class CustomerController {

	@Autowired
	CustomerDAO customerDAO = new CustomerDAO();

	@PostMapping("/registerCustomer")
	// @RequestMapping("registerCustomer")
	public Customer registerCustomer(@RequestBody Customer customer) {

//		Customer customer = new Customer();
//		customer.setCustomerFirstName("Deep");
//		customer.setCustomerLastName("DEF");
//		customer.setCustomerMobileNo("9999999995");
//		customer.setCustomerEmailId("abc@gmail.com");
//		customer.setPassword("password");

		return customerDAO.registerCustomer(customer);

	}

	@GetMapping("getCustomerByMobilePassword/{mobile}/{password}")
	public Customer getCustomerByMobilePassword(@PathVariable("mobile") String mobile,
			@PathVariable("password") String password) {
		Customer customer = customerDAO.getCustomerByMobile(mobile, password);
		return customer;

	}

	@RequestMapping("showAllCustomer")
	public List<Customer> showAllCustomer() {

		List<Customer> customerList = customerDAO.getCustomers();
		return customerList;

	}

	@RequestMapping("showCustomerById/{customerId}")
	public Customer showCustomerById(@PathVariable("customerId") Integer customerId) {
		Customer customer = customerDAO.getCustomerById(customerId);
		return customer;

	}

}
