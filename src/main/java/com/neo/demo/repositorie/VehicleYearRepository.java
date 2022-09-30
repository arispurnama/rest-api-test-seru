package com.neo.demo.repositorie;

import com.neo.demo.models.VehicleYear;
import org.springframework.data.jpa.repository.JpaRepository;

public interface VehicleYearRepository extends JpaRepository<VehicleYear, Integer> {
}
