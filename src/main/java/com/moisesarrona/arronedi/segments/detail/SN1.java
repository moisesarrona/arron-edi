package com.moisesarrona.arronedi.segments.detail;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import lombok.Data;

@Data
public class SN1 {

    @Size(min = 1, max = 20, message = "Assigned Identification must be between 1 and 20 characters long")
    private String assignedIdentification;

    @NotBlank(message = "Number of Units Shipped cannot be blank")
    @Size(min = 1, max = 10, message = "Number of Units Shipped must be between 1 and 10 characters long")
    private String numberOfUnitsShipped;

    @NotBlank(message = "Unit or Basis for Measurement Code cannot be blank")
    @Size(min = 2, max = 2, message = "Unit or Basis for Measurement Code must be 2 characters long")
    private String unitOrBasisForMeasurementCode;

    @Size(min = 1, max = 15, message = "Quantity Shipped to Date must be between 1 and 15 characters long")
    private String quantityShippedToDate;

}
