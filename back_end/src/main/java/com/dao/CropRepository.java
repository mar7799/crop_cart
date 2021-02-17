package com.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.model.Crop;
import com.model.Farmer;

@Repository
public interface CropRepository extends JpaRepository<Crop, Integer> {

	Optional<Crop> findByCropName(String crop_name);

	List<Crop> findAllByFarmer(Farmer farmer);

}
