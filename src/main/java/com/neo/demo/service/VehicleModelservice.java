package com.neo.demo.service;

import com.neo.demo.models.VehicleModel;
import com.neo.demo.models.mapper.VehicleModelMapper;
import com.neo.demo.repositorie.VehicleModelRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class VehicleModelservice {
    @Autowired
    VehicleModelRepository repository;

    public List<VehicleModel> findAllData(Integer pageNo, Integer pageSize, String sortBy){
        Pageable paging = PageRequest.of(pageNo,pageSize, Sort.by(sortBy));

        Page<VehicleModel> pagedResult =  repository.findAll(paging);

        if(pagedResult.hasContent()) {
            return pagedResult.getContent();
        } else {
            return new ArrayList<VehicleModel>();
        }
    }

    public com.neo.demo.models.dto.VehicleModelDto createData(com.neo.demo.models.dto.VehicleModelDto param){
        VehicleModel data = VehicleModelMapper.INSTANCE.toEntity(param);
        return VehicleModelMapper.INSTANCE.toDto(repository.save(data));
    }

    public boolean deleteData(int id){
        VehicleModel data = repository.findById(id).orElseThrow(null);
        try{
            repository.delete(data);
            return  true;
        } catch (Exception e){
            return false;
        }
    }

    public VehicleModel updateData(int id, VehicleModel param){
        VehicleModel data = repository.findById(id).orElseThrow(null);

        data.setNameModel(param.getNameModel() == null ? data.getNameModel() : data.getNameModel());
        data.setPriceListList(param.getPriceListList() == null ? data.getPriceListList() : data.getPriceListList());

        return repository.save(data);
    }
}
