package com.example.warehouse.controllers;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class WarehouseRequest {

    @JsonProperty
    private String name;

    @JsonProperty
    private String code;

    @JsonProperty
    private String status;

}
