package com.example.clients.models;


import com.example.common.utils.BaseModel;
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

    @Column(name = "first_name")
    private String name;

    @Column(name = "last_name")
    private String lastName;

    @Column(name = "email")
    private String email;

    @Column(name = "phone")
    private String phone;

    @Column(name = "address")
    private String address;

    @Column(name = "nit")
    private String nit;

    @Column(name = "status")
    private Boolean status;

}
