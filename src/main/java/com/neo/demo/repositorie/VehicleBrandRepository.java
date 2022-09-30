package com.neo.demo.repositorie;

import com.neo.demo.models.VehicleBrand;
import org.springframework.data.jpa.repository.JpaRepository;

public interface VehicleBrandRepository extends JpaRepository<VehicleBrand, Integer> {
}
