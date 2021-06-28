package com.nitish.shoppingcart.bean;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;

@Builder
@JsonIgnoreProperties(ignoreUnknown = true)
public class ErrorResponse {
    @JsonProperty
    private String errorCode;

    @JsonProperty
    private String name;

    @JsonProperty
    private String errorMessage;
}
