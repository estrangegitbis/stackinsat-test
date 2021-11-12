package com.stackinsat.test.model;

import lombok.*;

import javax.persistence.*;

@Data
@NoArgsConstructor
@Entity(name = "account")
public class Account {

    @Id
    @GeneratedValue
    private long id;

    @Column(name = "number")
    private String number;

    @Column(name = "amount")
    private Float amount;

    @ManyToOne
    private AppUser user;
}
