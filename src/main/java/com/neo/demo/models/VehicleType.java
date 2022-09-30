package com.neo.demo.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Data
@Entity
public class VehicleType {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "name_type")
    private String nameType;

    @Column(name = "capacity")
    private Integer capacity;


    @JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "brand_id")
    private VehicleBrand vehicleBrand;

    @Transient
    @OneToMany(mappedBy = "vehicleType")
    private List<VehicleModel> vehicleModelList;
}
