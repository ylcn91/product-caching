package com.doksanbir.productcaching.model.entity;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

@Entity
@Data
@Table(name = "phone")
public class Phone implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private String phone;

    @Column(name = "release_date")
    @Temporal(TemporalType.DATE)
    private Date releaseDate;

    @ManyToMany(
            fetch = FetchType.LAZY,
            mappedBy = "phones"
    )
    private Set<User> users = new HashSet<>();


    @ManyToMany(
            fetch = FetchType.LAZY,
            mappedBy = "phones"
    )
    private Set<Brand> brands = new HashSet<>();

}
