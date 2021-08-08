package com.doksanbir.productcaching.model.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.sun.istack.NotNull;
import lombok.Data;


import javax.validation.constraints.Email;

@Data
public class UserDtoPost {

    @JsonProperty("id")
    private long id;

    @Email
    @NotNull
    @JsonProperty("email")
    private String email;

    @NotNull
    @JsonProperty("password")
    private String password;

    @JsonProperty("firstname")
    private String firstName;

    @JsonProperty("lastName")
    private String lastName;
}
