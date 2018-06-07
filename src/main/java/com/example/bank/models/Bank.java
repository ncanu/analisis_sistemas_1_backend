package com.example.bank.models;

import com.example.common.utils.BaseModel;
import lombok.Data;

import javax.persistence.*;
import java.math.BigDecimal;


@NamedQueries
        ({
                @NamedQuery(name = "All Banks", query = "SELECT bank FROM Bank bank")
        })


@Data
@Entity
@Table(name = "bank_acc")
public class Bank extends BaseModel {

    @Column(name = "number")
    private String number;

    @Column(name = "bank")
    private String bank;

    @Column(name = "balance")
    private BigDecimal balance;

}
