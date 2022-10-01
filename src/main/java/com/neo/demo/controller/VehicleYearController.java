package com.neo.demo.controller;

import com.neo.demo.common.Response;
import com.neo.demo.models.VehicleYear;
import com.neo.demo.service.VehicleYearService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/vehicle-year")
public class VehicleYearController {
    @Autowired
    VehicleYearService vehicleYearService;

    @GetMapping(params = { "page", "size", "sortBy"})
    public Response findAllData(@RequestParam("page") int page,
                                @RequestParam("size") int size,
                                @RequestParam("sortBy") String sortBy){
        return new Response(vehicleYearService.findAllData(page,size,sortBy), "Jumlah Data = " + vehicleYearService.findAllTotalData().size(),vehicleYearService.findAllData(page,size,sortBy).size(),HttpStatus.OK);
    }

//    @GetMapping(name = "/get-year", params = { "size", "param"})
//    public Response findAllDataByYear(@RequestParam("size") int size,
//                                @RequestParam("param") String param){
//        return new Response(vehicleYearService.findByYear(size,param), "Jumlah Data = " + vehicleYearService.findAllTotalData().size(),vehicleYearService.findByYear(size,param).size(),HttpStatus.OK);
//    }


    @PostMapping
    public Response save(@RequestBody VehicleYear param){
        return new Response(vehicleYearService.createData(param), "Data Berhasil Disimpan",HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public Response deleteData(@PathVariable int id){

        return new Response(vehicleYearService.deleteData(id), "Data Berhasil Dihapus", HttpStatus.OK);
    }

    @PutMapping(params = {"id"})
    public Response updatedataYear(@RequestParam("id") int id,@RequestBody VehicleYear param){
        return new Response(vehicleYearService.updateDataYear(id, param),"Berhasil Diupdate",HttpStatus.OK);
    }
}
