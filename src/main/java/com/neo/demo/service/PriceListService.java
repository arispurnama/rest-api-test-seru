package com.neo.demo.service;

import com.neo.demo.models.PriceList;
import com.neo.demo.models.VehicleModel;
import com.neo.demo.models.VehicleYear;
import com.neo.demo.models.dto.PriceListDto;
import com.neo.demo.models.mapper.PriceListMapper;
import com.neo.demo.models.mapper.VehicleModelMapper;
import com.neo.demo.repositorie.PriceListRepository;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class PriceListService {
    @Autowired
    PriceListRepository priceListRepository;

    public List<PriceList> findAllTotalData(){
        return priceListRepository.findAll();
    }

    public List<PriceList> findAllData(Integer pageNo, Integer pageSize, String sortBy){
        Pageable paging = PageRequest.of(pageNo,pageSize, Sort.by(sortBy));

        Page<PriceList> pagedResult = priceListRepository.findAll(paging);

        if(pagedResult.hasContent()) {
            return pagedResult.getContent();
        } else {
            return new ArrayList<PriceList>();
        }
    }

    public PriceListDto createData(PriceListDto param){
        PriceList data = PriceListMapper.INSTANCE.toEntity(param);
        return PriceListMapper.INSTANCE.toDto(priceListRepository.save(data));
    }

    public boolean deleteData(int id){
        PriceList data = priceListRepository.findById(id).orElseThrow(null);
        try{
            priceListRepository.delete(data);
            return  true;
        } catch (Exception e){
            return false;
        }
    }

    public PriceList updateData(int id, PriceList param){
        PriceList data = priceListRepository.findById(id).orElseThrow(null);

        data.setPrice(param.getPrice() == null ? data.getPrice() : data.getPrice());
        data.setCode(param.getCode() == null ? data.getCode() : data.getCode());
        data.setVehicleModel(param.getVehicleModel() == null ? data.getVehicleModel() : data.getVehicleModel());
        data.setVehicleYear(param.getVehicleYear() == null ? data.getVehicleYear() : data.getVehicleYear());

        return priceListRepository.save(data);
    }
}
