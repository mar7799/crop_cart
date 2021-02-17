package com;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.dao.FarmerDAO;
import com.model.Farmer;

@RestController
public class FarmerController {

	@Autowired
	FarmerDAO farmerDAO = new FarmerDAO();

	@PostMapping("/registerFarmer")
	public Farmer registerFarmer(@RequestBody Farmer farmer) {

		return farmerDAO.registerFarmer(farmer);

	}

	@RequestMapping("showAllFarmer")
	public List<Farmer> showAllFarmer() {

		List<Farmer> farmerList = farmerDAO.getFarmers();
		return farmerList;

	}

	@RequestMapping("showFarmerById/{farmerId}")
	public Farmer showFarmerById(@PathVariable("farmerId") Integer farmerId) {
		Farmer farmer = farmerDAO.getFarmerById(farmerId);
		return farmer;

	}

	@GetMapping("getFarmerByMobilePassword/{mobile}/{password}")
	public Farmer getFarmerByMobilePassword(@PathVariable("mobile") String mobile,
			@PathVariable("password") String password) {
		Farmer farmer = farmerDAO.getFarmerByMobile(mobile, password);
		return farmer;

	}

}
