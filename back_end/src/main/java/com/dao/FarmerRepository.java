package com.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.model.Farmer;

@Repository
public interface FarmerRepository extends JpaRepository<Farmer, Integer> {
	
	List<Farmer> findAll();

	Optional<Farmer> findByMobileAndPassword(String mobile, String password);

}
