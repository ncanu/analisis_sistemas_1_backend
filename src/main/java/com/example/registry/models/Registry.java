package com.example.registry.models;

import com.example.common.utils.BaseModel;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import javax.persistence.*;
import java.util.Date;

@NamedQueries
        ({
                @NamedQuery(name = "All Registries", query = "SELECT registry FROM Registry registry")

        })


@Data
@Entity
@Table(name = "registry")
public class Registry extends BaseModel {


    @Column(name = "user_id")
    @JsonProperty
    private Long userId;

    @Column(name = "date")
    @Temporal(TemporalType.TIMESTAMP)
    private Date date;

    @Column(name = "login")
    @JsonProperty
    private Boolean login;

    @Column(name = "description")
    @JsonProperty
    private String description;

}
