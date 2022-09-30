package com.neo.demo.controller;

import com.neo.demo.common.Response;
import com.neo.demo.models.dto.VehicleBrandDto;
import com.neo.demo.service.VehicleBrandService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/vehicle-brand")
public class VehicleBrandController {
    @Autowired
    private VehicleBrandService vehicleBrandService;

    @GetMapping("/{pageNo}/{pageSize}")
    public Response getAllBrand(@PathVariable int pageNo, @PathVariable int pageSize){
        return new Response(vehicleBrandService.findAllBrand(pageNo, pageSize),
                vehicleBrandService.findAllBrand(pageNo, pageSize).size(),
                HttpStatus.OK);
    }

    @PostMapping
    public Response createBrand(@RequestBody VehicleBrandDto param){
        return new Response(vehicleBrandService.createBrand(param),
                "Data Barang Disimpan",
                HttpStatus.OK);
    }
}
