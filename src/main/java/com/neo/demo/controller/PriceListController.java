package com.neo.demo.controller;

import com.neo.demo.common.Response;
import com.neo.demo.models.PriceList;
import com.neo.demo.models.VehicleModel;
import com.neo.demo.models.dto.PriceListDto;
import com.neo.demo.models.dto.VehicleModelDto;
import com.neo.demo.service.PriceListService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/price-list")
public class PriceListController {
    @Autowired
    PriceListService service;

    @GetMapping(params = { "page", "size", "sortBy"})
    public Response findAllData(@RequestParam("page") int page,
                                @RequestParam("size") int size,
                                @RequestParam("sortBy") String sortBy){
        return new Response(service.findAllData(page,size,sortBy),"Jumalh Data = " + service.findAllTotalData().size(),service.findAllData(page,size,sortBy).size(), HttpStatus.OK);
    }

    @PostMapping
    public Response saveData(@RequestBody PriceListDto param){
        return new Response(service.createData(param),
                "Data Berhasil Disimpan",HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public Response deleteData(@PathVariable Integer id){
        if(service.deleteData(id)){
            return new Response("Berhasil didelete" , HttpStatus.OK);
        }
        return new Response("Gagal dihapus" , HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public Response updateData(@PathVariable Integer id, @RequestBody PriceList barang){
        return new Response(
                service.updateData(id, barang),
                "Berhasil di update",
                HttpStatus.OK);
    }
}
