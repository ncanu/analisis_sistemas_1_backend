package com.example.role.models;

import com.example.common.utils.BaseModel;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Data
@Entity
@Table(name = "role")
public class Role extends BaseModel {

    @JsonProperty
    @Column
    private String name;

}
