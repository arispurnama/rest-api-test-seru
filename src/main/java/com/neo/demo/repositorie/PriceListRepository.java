package com.neo.demo.repositorie;

import com.neo.demo.models.PriceList;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PriceListRepository extends JpaRepository<PriceList, Integer> {
}
