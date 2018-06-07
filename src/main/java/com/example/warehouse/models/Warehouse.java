package com.example.warehouse.models;

import com.example.common.utils.BaseModel;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import javax.persistence.*;

@NamedQueries
        ({
                @NamedQuery(name = "All warehouses", query = "SELECT warehouse FROM Warehouse warehouse")

        })


@Data
@Entity
@Table(name = "warehouse")
public class Warehouse extends BaseModel {

    @JsonProperty
    @Column(name = "name")
    private String name;

    @JsonProperty
    @Column(name = "code")
    private String code;

    @JsonProperty
    @Column(name = "local")
    private String local;

    @JsonProperty
    @Column(name = "status")
    private Boolean status;
}
