package com.moisesarrona.segments.detail;

import javax.validation.constraints.Digits;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import lombok.Data;

@Data
public class SN1 {

    @Size(min = 1, max = 20, message = "Assigned Identification must be between {min} and {max} characters long")
    private String assignedIdentification;

    @NotBlank(message = "Number of Units Shipped cannot be blank")
    @Digits(integer = 10, message = "Number of Units Shipped must contain only digits", fraction = 0)
    @Size(min = 1, max = 10, message = "Number of Units Shipped must be between {min} and {max} characters long")
    private Integer numberOfUnitsShipped;

    @NotBlank(message = "Unit or Basis for Measurement Code cannot be blank")
    @Size(min = 2, max = 2, message = "Assigned Identification must be {min} characters long")
    private String unitOrBasisForMeasurementCode;

    @Digits(integer = 10, message = "Quantity Shipped To Date must contain only digits", fraction = 0)
    @Size(min = 1, max = 10, message = "Quantity Shipped To Date must be between {min} and {max} characters long")
    private Integer quantityShippedToDate;

    /*@NotBlank(message = "Quantity Ordered cannot be blank")
    private Integer quantityOrdered;*/

}
