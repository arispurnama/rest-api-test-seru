package com.neo.demo.service;

import com.neo.demo.models.VehicleBrand;
import com.neo.demo.models.VehicleType;
import com.neo.demo.models.VehicleYear;
import com.neo.demo.models.dto.VehicleTypeDto;
import com.neo.demo.models.mapper.VehicleBrandMapper;
import com.neo.demo.models.mapper.VehicleTypeMapper;
import com.neo.demo.repositorie.VehicleBrandRepository;
import com.neo.demo.repositorie.VehicleTypeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class VehicleTypeService {
    @Autowired
    VehicleTypeRepository repository;

    @Autowired
    VehicleBrandRepository vehicleBrandRepository;

    public List<VehicleType> findAllTotalData(){
        return repository.findAll();
    }
    public List<VehicleType> findAllData(Integer pageNo, Integer pageSize, String sortBy){
        Pageable paging = PageRequest.of(pageNo,pageSize, Sort.by(sortBy));

        Page<VehicleType> pagedResult = repository.findAll(paging);

        if(pagedResult.hasContent()) {
            return pagedResult.getContent();
        } else {
            return new ArrayList<VehicleType>();
        }
    }

    public boolean deleteData(int id){
        VehicleType data = repository.findById(id).orElseThrow(null);
        if (data.equals(null)){
            return false;
        }else{
            repository.delete(data);
            return true;
        }
    }

    public VehicleTypeDto createdata(VehicleTypeDto param){
        VehicleType data = VehicleTypeMapper.INSTANCE.toEntity(param);
        return VehicleTypeMapper.INSTANCE.toDto(repository.save(data));
    }

    public VehicleType updateData(int id, VehicleType param){
        VehicleType data = repository.findById(id).orElseThrow(null);

        data.setNameType(param.getNameType());
        data.setCapacity(param.getCapacity());
        data.setVehicleBrand(param.getVehicleBrand());
        data.setVehicleModelList(param.getVehicleModelList());

        return repository.save(data);
    }
 }
