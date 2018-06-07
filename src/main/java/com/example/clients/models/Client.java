package com.example.clients.models;


import com.example.common.utils.BaseModel;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import javax.persistence.*;

@NamedQueries
        ({
                @NamedQuery(name = "All Clients", query = "SELECT user FROM Client user"),
                @NamedQuery(name = "Client by email", query = "SELECT user FROM Client user WHERE user.email =:email")
        })


@Data
@Entity
@Table(name = "client")
public class Client extends BaseModel {

    @JsonProperty
    @Column(name = "first_name")
    private String name;

    @JsonProperty
    @Column(name = "last_name")
    private String lastName;

    @JsonProperty
    @Column(name = "email")
    private String email;

    @JsonProperty
    @Column(name = "phone")
    private String phone;

    @JsonProperty
    @Column(name = "address")
    private String address;

    @JsonProperty
    @Column(name = "nit")
    private String nit;

    @JsonProperty
    @Column(name = "status")
    private Boolean status;

}
