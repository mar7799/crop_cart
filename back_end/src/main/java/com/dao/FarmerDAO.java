package com.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.model.Farmer;

@Service
public class FarmerDAO {

	@Autowired
	private FarmerRepository farmerRepository;

	public List<Farmer> getFarmers() {

		List<Farmer> farmerList = farmerRepository.findAll();
		return farmerList;
	}

	public Farmer registerFarmer(Farmer farmer) {

		return farmerRepository.save(farmer);

	}

	public Farmer getFarmerById(Integer farmerId) {

		return farmerRepository.findById(farmerId).orElse(new Farmer());
	}

	public Farmer getFarmerByMobile(String mobile, String password) {

		return farmerRepository.findByMobileAndPassword(mobile, password).orElse(new Farmer());

	}

}