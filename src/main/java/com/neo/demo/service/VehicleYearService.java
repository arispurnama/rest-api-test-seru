package com.neo.demo.service;

import com.neo.demo.models.VehicleYear;
import com.neo.demo.models.dto.VehicleYearDto;
import com.neo.demo.repositorie.VehicleYearRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class VehicleYearService {
    @Autowired
    VehicleYearRepository vehicleYearRepository;

    public List<VehicleYear> findAllTotalData(){
        return vehicleYearRepository.findAll();
    }

    public List<VehicleYear> findAllData(Integer pageNo, Integer pageSize, String sortBy){
        Pageable paging = PageRequest.of(pageNo,pageSize, Sort.by(sortBy));

        Page<VehicleYear> pagedResult = vehicleYearRepository.findAll(paging);

        if(pagedResult.hasContent()) {
            return pagedResult.getContent();
        } else {
            return new ArrayList<VehicleYear>();
        }
    }

//    public List<VehicleYear> findByYear(Integer pageSize, String param){
//        List<VehicleYear> data = vehicleYearRepository.findVehicleYearByYear(param);
//        Pageable paging = PageRequest.ofSize(pageSize);
//
//        Page<VehicleYear> pagedResult =
//
//        if(pagedResult.hasContent()) {
//            return pagedResult.getContent();
//        } else {
//            return new ArrayList<VehicleYear>();
//        }
//    }
    public VehicleYear createData(VehicleYear param){
        return vehicleYearRepository.save(param);
    }

    public boolean deleteData(int id){
        VehicleYear data = vehicleYearRepository.findById(id).orElseThrow(null);

        if (data.equals(null)){
            return false;
        }else{
            vehicleYearRepository.delete(data);
            return true;
        }
    }

    public VehicleYear updateDataYear(Integer id, VehicleYear param){
        VehicleYear data = vehicleYearRepository.findById(id).orElseThrow(null);

        data.setYear(param.getYear());
        data.setPriceListList(param.getPriceListList());

        return vehicleYearRepository.save(data);
    }
}
