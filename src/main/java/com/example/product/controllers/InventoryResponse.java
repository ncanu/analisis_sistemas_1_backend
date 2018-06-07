package com.example.product.controllers;

import com.example.product.models.Inventory;
import com.example.product.models.Product;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class InventoryResponse {

    @JsonProperty
    Inventory inventory;

    @JsonProperty
    Product product;

}
