package com.neo.demo.service;

import com.neo.demo.models.VehicleBrand;
import com.neo.demo.repositorie.VehicleBrandRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class VehicleBrandService {
    @Autowired
    private VehicleBrandRepository vehicleBrandRepository;

    public List<VehicleBrand> findAlltotalBrand(){
        return vehicleBrandRepository.findAll();
    }

    public List<VehicleBrand> findAllData(Integer pageNo, Integer pageSize, String sortBy){
        Pageable paging = PageRequest.of(pageNo,pageSize, Sort.by(sortBy));

        Page<VehicleBrand> pagedResult =  vehicleBrandRepository.findAll(paging);

        if(pagedResult.hasContent()) {
            return pagedResult.getContent();
        } else {
            return new ArrayList<VehicleBrand>();
        }
    }

    public VehicleBrand createDataBrand(VehicleBrand param){
        return vehicleBrandRepository.save(param);
    }

    public boolean deleteDataBrand(int id){
        VehicleBrand data = vehicleBrandRepository.findById(id).orElseThrow(null);

        if (data.equals(null)){
            return false;
        }else{
            vehicleBrandRepository.delete(data);
            return true;
        }
    }

    public VehicleBrand updateDataBrand(Integer id, VehicleBrand param){
        VehicleBrand data = vehicleBrandRepository.findById(id).orElseThrow(null);

        data.setName(param.getName());
        data.setVehicleTypeList(param.getVehicleTypeList());

        return vehicleBrandRepository.save(data);
    }
}
