package com.example.role.models;

import com.example.common.utils.BaseModel;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Data
@Entity
@Table(name = "user_role")
public class UserRole extends BaseModel {

    @JsonProperty
    @Column(name = "user_id")
    private Long userId;

    @JsonProperty
    @Column(name = "role_id")
    private Long roleId;

}
