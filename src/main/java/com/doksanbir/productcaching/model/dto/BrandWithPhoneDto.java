package com.doksanbir.productcaching.model.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;
import java.util.Set;


@Getter
@Setter
public class BrandWithPhoneDto {

    @JsonProperty("id")
    private long id;

    @JsonProperty("name")
    private String name;

    @JsonProperty("center")
    private String center;

    @JsonProperty("founded")
    private Date founded;

    @JsonProperty("phones")
    private Set<PhoneIdNameDto> phones;

}
