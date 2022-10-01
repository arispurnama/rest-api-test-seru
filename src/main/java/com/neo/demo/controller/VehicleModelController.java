package com.neo.demo.controller;

import com.neo.demo.common.Response;
import com.neo.demo.models.VehicleModel;
import com.neo.demo.models.dto.VehicleModelDto;
import com.neo.demo.service.VehicleModelservice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/vehicle-model")
public class VehicleModelController {
    @Autowired
    VehicleModelservice modelservice;

    @GetMapping(params = { "page", "size", "sortBy"})
    public Response findAllData(@RequestParam("page") int page,
                                @RequestParam("size") int size,
                                @RequestParam("sortBy") String sortBy){
        return new Response(modelservice.findAllData(page,size,sortBy),modelservice.findAllData(page,size,sortBy).size(), HttpStatus.OK);
    }

    @PostMapping
    public Response saveData(@RequestBody VehicleModelDto param){
        return new Response(modelservice.createData(param),
                "Data Berhasil Disimpan",HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public Response deleteData(@PathVariable Integer id){
        if(modelservice.deleteData(id)){
            return new Response("Berhasil didelete" , HttpStatus.OK);
        }
        return new Response("Gagal dihapus" , HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public Response updateData(@PathVariable Integer id, @RequestBody VehicleModel barang){
        return new Response(
                modelservice.updateData(id, barang),
                "Berhasil di update",
                HttpStatus.OK);
    }
}
