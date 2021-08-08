package com.doksanbir.productcaching.model.entity;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

@Entity
@Data
public class Brand implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private String name;

    private String center;

    @Column(name = "founded")
    @Temporal(TemporalType.DATE)
    private Date founded;

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(
            name = "brand_phone",
            joinColumns = @JoinColumn(name = "brand_id"),
            inverseJoinColumns = @JoinColumn(name = "phone_id")
    )
    private Set<Phone> phones = new HashSet<>();
}
