package com.neo.demo.service;

import com.neo.demo.models.VehicleBrand;
import com.neo.demo.models.dto.VehicleBrandDto;
import com.neo.demo.models.mapper.VehicleBrandMapper;
import com.neo.demo.repositorie.VehicleBrandRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class VehicleBrandService {
    @Autowired
    private VehicleBrandRepository vehicleBrandRepository;

    public List<VehicleBrand> findAllBrand(int pageNo, int pageSize){
        Pageable paging = PageRequest.of(pageNo, pageSize);
        Page<VehicleBrand> pageResult = vehicleBrandRepository.findAll(paging);

        return pageResult.toList();
    }

    public VehicleBrandDto createBrand(VehicleBrandDto param){
        VehicleBrand vehicleBrand = VehicleBrandMapper.INSTANCE.toEntitiy(param);
        return VehicleBrandMapper.INSTANCE.toDto(vehicleBrandRepository.save(vehicleBrand));
    }
}
