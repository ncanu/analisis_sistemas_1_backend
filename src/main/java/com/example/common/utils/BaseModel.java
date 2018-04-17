package com.example.common.utils;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;

@Data
@MappedSuperclass
public class BaseModel implements Serializable {

    @Transient
    @JsonIgnore
    final static long serialVersionUID = 1;

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

}
