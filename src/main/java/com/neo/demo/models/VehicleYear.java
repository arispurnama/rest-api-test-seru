package com.neo.demo.models;

import lombok.Data;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Data
@Entity
public class VehicleYear {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "year")
    private Date Year;

    @Transient
    @OneToMany(mappedBy = "vehicleYear")
    private List<VehicleYear> vehicleYearList;
}
