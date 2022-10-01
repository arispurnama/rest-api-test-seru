package com.neo.demo.controller;

import com.neo.demo.common.Response;
import com.neo.demo.models.VehicleType;
import com.neo.demo.models.VehicleYear;
import com.neo.demo.models.dto.VehicleTypeDto;
import com.neo.demo.service.VehicleTypeService;
import com.neo.demo.service.VehicleYearService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/vehicle-type")
public class VehicleTypeController {
    @Autowired
    VehicleTypeService service;

    @GetMapping(params = { "page", "size", "sortBy"})
    public Response findAllData(@RequestParam("page") int page,
                                @RequestParam("size") int size,
                                @RequestParam("sortBy") String sortBy){
        return new Response(service.findAllData(page,size,sortBy), "Jumlah Data = " + service.findAllTotalData().size(),service.findAllData(page,size,sortBy).size(), HttpStatus.OK);
    }

    @PostMapping
    public Response save(@RequestBody VehicleTypeDto param){
        return new Response(service.createdata(param), "Data Berhasil Disimpan",HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public Response deleteData(@PathVariable int id){

        return new Response(service.deleteData(id), "Data Berhasil Dihapus", HttpStatus.OK);
    }

    @PutMapping(params = {"id"})
    public Response updatedataYear(@RequestParam("id") int id,@RequestBody VehicleType param){
        return new Response(service.updateData(id, param),"Berhasil Diupdate",HttpStatus.OK);
    }
}
