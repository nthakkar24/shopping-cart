package com.nitish.shoppingcart.bean;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.sun.istack.NotNull;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import org.springframework.lang.NonNull;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;

@Getter
@Setter
@Builder
@JsonIgnoreProperties(ignoreUnknown = true)
public class Item {

    @NotBlank(message = "Product Id is manitory parameter")
    String productId;

    @NotBlank(message = "Customer Id is manitory parameter")
    String customerId;

    @Min(value = 1, message = "Quantity Should be greater than 0")
    Integer quantity;
}
