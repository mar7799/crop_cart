package com.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.model.Customer;

@Service
public class CustomerDAO {
	
	@Autowired
	private CustomerRepository customerRepository;

	public List<Customer> getCustomers() {

		List<Customer> customerList = customerRepository.findAll();
		return customerList;
	}

	public Customer registerCustomer(Customer customer) {

		return customerRepository.save(customer);

	}
	public Customer getCustomerByMobile(String customerMobileNo, String password) {
		
		return customerRepository.findByCustomerMobileNoAndPassword(customerMobileNo, password).orElse(new Customer());
	}


	public Customer getCustomerById(Integer customerId) {

		return customerRepository.findById(customerId).orElse(new Customer());
	}

}
