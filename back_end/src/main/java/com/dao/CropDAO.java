package com.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.model.Crop;
import com.model.Farmer;

@Service
public class CropDAO {
	
	@Autowired
	private CropRepository cropRepository;

	public List<Crop> getCrops() {

		List<Crop> cropList = cropRepository.findAll();
		return cropList;
	}

	public Crop registerCrop(Crop crop) {

		return cropRepository.save(crop);

	}

	public Crop getCropById(Integer cropId) {

		return cropRepository.findById(cropId).orElse(new Crop());
	}

	public Crop getCropByName(String cropName) {

		return cropRepository.findByCropName(cropName).orElse(new Crop());

	}

	public List<Crop> getCropsByFarmer(Farmer farmer) {
		List<Crop> cropList = cropRepository.findAllByFarmer(farmer);
		return cropList;
	}

}
