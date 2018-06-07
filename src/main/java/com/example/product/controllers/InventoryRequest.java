package com.example.product.controllers;


import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import javax.persistence.Column;
import java.math.BigDecimal;

@Data
public class InventoryRequest {


    @JsonProperty
    private Long warehouse;


    @JsonProperty
    private Long product;


    @JsonProperty
    private Long quantity;


    @JsonProperty
    private BigDecimal price;


    @JsonProperty
    private BigDecimal cost;

}
