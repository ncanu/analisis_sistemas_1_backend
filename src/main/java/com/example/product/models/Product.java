package com.example.product.models;

import com.example.common.utils.BaseModel;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import javax.persistence.*;
import java.math.BigDecimal;

@NamedQueries
        ({
                @NamedQuery(name = "All products", query = "SELECT product FROM Product product")

        })


@Data
@Entity
@Table(name = "product")
public class Product extends BaseModel {

    @Column(name = "code")
    @JsonProperty
    private String code;

    @Column(name = "name")
    @JsonProperty
    private String name;

    @Column(name = "measurement")
    @JsonProperty
    private String measurement;

    @Column(name = "price")
    @JsonProperty
    private BigDecimal price;
}
