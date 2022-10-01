package com.neo.demo.controller;

import com.neo.demo.common.Response;
import com.neo.demo.models.VehicleBrand;
import com.neo.demo.models.VehicleYear;
import com.neo.demo.models.dto.VehicleBrandDto;
import com.neo.demo.service.VehicleBrandService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(origins = "http://localhost:8081")
@RestController
@RequestMapping("/vehicle-brand")
public class VehicleBrandController {
    @Autowired
    VehicleBrandService vehicleBrandService;

    @GetMapping(params = { "page", "size", "sortBy"})
    public Response findAllData(@RequestParam("page") int page,
                                @RequestParam("size") int size,
                                @RequestParam("sortBy") String sortBy){
        return new Response(vehicleBrandService.findAllData(page,size,sortBy), "Jumlah Data = " + vehicleBrandService.findAlltotalBrand().size(),vehicleBrandService.findAllData(page,size,sortBy).size(),HttpStatus.OK);
    }

    @PostMapping
    public Response createBrand(@RequestBody VehicleBrand param){
        return new Response(vehicleBrandService.createDataBrand(param),
                "Data Barang Disimpan",
                HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public Response deleteData(@PathVariable int id){

        return new Response(vehicleBrandService.deleteDataBrand(id), "Data Berhasil Dihapus", HttpStatus.OK);
    }

    @PutMapping(params = {"id"})
    public Response updatedata(@RequestParam("id") int id,@RequestBody VehicleBrand param){
        return new Response(vehicleBrandService.updateDataBrand(id, param),"Berhasil Diupdate",HttpStatus.OK);
    }
}
