package com;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.dao.CropDAO;
import com.dao.FarmerDAO;
import com.model.Crop;
import com.model.Farmer;

@RestController
public class CropController {
	@Autowired
	CropDAO cropDAO = new CropDAO();
	@Autowired
	FarmerDAO farmerDAO = new FarmerDAO();

	@PostMapping("/registerCrop")
	//@RequestMapping("/registerCrop")
	public Crop registerCrop(@RequestBody Crop crop) {
		
		/*
		 * Crop crop =new Crop(); crop.setCropName("Cron"); crop.setCropType("Food");
		 * crop.setCropQuantity(89); crop.setPrice(67); Farmer farmer =
		 * farmerDAO.getFarmerById(3); crop.setFarmer(farmer);
		 */
		
		crop = cropDAO.registerCrop(crop);
		
		return crop;

	}

	//@RequestMapping("getAllCrop")
	@GetMapping("getAllCrop")
	public List<Crop> getAllCrop() {

		List<Crop> cropList = cropDAO.getCrops();
		return cropList;

	}
	
	//@RequestMapping("getAllCropByFarmer/{farmerId}")
	@GetMapping("getAllCropByFarmer/{farmerId}")
	public List<Crop> getAllCropByFarmer(@PathVariable("farmerId") Integer farmerId) {
		Farmer farmer = farmerDAO.getFarmerById(farmerId);
		List<Crop> cropList = cropDAO.getCropsByFarmer(farmer);
		return cropList;

	}

	@RequestMapping("showCropById/{cropId}")
	public Crop showCropById(@PathVariable("cropId") Integer cropId) {
		Crop crop = cropDAO.getCropById(cropId);
		return crop;

	}

	//@GetMapping("getCropByName/{cropName}")
	@RequestMapping("getCropByName/{cropName}")
	public Crop getCropByName(@PathVariable("cropName") String cropName) {
		Crop crop = cropDAO.getCropByName(cropName);
		return crop;

	}



}
