package com.neo.demo.models;

import lombok.Data;

import javax.persistence.*;

import java.util.List;

import static org.eclipse.jdt.internal.compiler.parser.Parser.name;

@Data
@Entity
public class VehicleBrand {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "name")
    private String name;

    @Transient
    @OneToMany(mappedBy = "vehicleBrand")
    private List<VehicleType> vehicleTypeList;

}
