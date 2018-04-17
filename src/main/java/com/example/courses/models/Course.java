package com.example.courses.models;

import com.example.common.utils.BaseModel;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Data
@Entity
@Table(name = "course")
public class Course extends BaseModel {

    @JsonProperty
    @Column
    private String name;

    @JsonProperty
    @Column
    private String description;

    @JsonProperty
    @Column
    private String code;

    @JsonProperty
    @Column
    private Long pensum;

}
