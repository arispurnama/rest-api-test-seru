package com.neo.demo.repositorie;

import com.neo.demo.models.VehicleYear;
import org.springframework.data.domain.Page;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface VehicleYearRepository extends JpaRepository<VehicleYear, Integer> {
    List<VehicleYear> findVehicleYearByYear(String param);
}
