package com.moisesarrona.segments.summary;

import lombok.Data;

import javax.validation.constraints.*;

@Data
public class CTT {

    @NotBlank(message = "Number of Line Items cannot be blank")
    @Digits(integer = 6, message = "Number of Line Items must contain only digits", fraction = 0)
    @Size(min = 1, max = 6, message = "Number of Line Items must be between 1 and 6 digits long")
    private Integer numberOfLineItems;

    @Digits(integer=10, message="Number of Line Items must contain only digits", fraction=0)
    @Size(min = 1, max = 10, message = "Number of Line Items must be between 1 and 10 digits long")
    private Double hashTotal;

}
