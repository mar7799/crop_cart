package com.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.model.OrderDetails;

public interface OrderDetailsRepository extends JpaRepository<OrderDetails, Integer>{

}
