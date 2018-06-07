package com.example.product.models;

import com.example.common.utils.BaseModel;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import javax.persistence.*;
import java.math.BigDecimal;

@NamedQueries
        ({
                @NamedQuery(name = "All inventory", query = "SELECT inventory FROM Inventory inventory"),
                @NamedQuery(name = "All inventory by warehouse", query = "SELECT inventory FROM Inventory inventory WHERE inventory.warehouseId=:warehouseId")
        })


@Data
@Entity
@Table(name = "inventory")
public class Inventory extends BaseModel {

    @Column(name = "warehouse_id")
    @JsonProperty
    private Long warehouseId;

    @Column(name = "product_id")
    @JsonProperty
    private Long productId;

    @Column(name = "quantity")
    @JsonProperty
    private Long quantity;

    @Column(name = "price")
    @JsonProperty
    private BigDecimal price;

    @Column(name = "cost")
    @JsonProperty
    private BigDecimal cost;
}
