package com.doksanbir.productcaching.model.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PhoneIdNameDto {

    @JsonProperty("id")
    private long id;

    @JsonProperty("title")
    private String name;
}
