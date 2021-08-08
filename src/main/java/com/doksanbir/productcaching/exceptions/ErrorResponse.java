package com.doksanbir.productcaching.exceptions;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.*;

@Data
@AllArgsConstructor
@JsonInclude(JsonInclude.Include.NON_EMPTY)
public class ErrorResponse {
    private String code;
    private String message;
}
