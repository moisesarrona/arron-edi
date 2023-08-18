package com.moisesarrona.arronedi.segments.detail;

import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Data
public class MEA {

    @Size(min = 2, max = 2, message = "Measurement Reference ID Code must be 2 characters long")
    private String measurementReferenceIdCode;

    @Size(min = 1, max = 3, message = "Measurement Qualifier must be between 1 and 3 characters long")
    private String measurementQualifier;

    @Size(min = 1, max = 20, message = "Measurement Value must be between 1 and 20 characters long")
    private String measurementValue;

    @NotBlank(message = "Unit or Basis for Measurement Code is mandatory")
    @Size(min = 2, max = 2, message = "Unit or Basis for Measurement Code must be 2 characters long")
    private String unitOrBasisForMeasurementCode;

}
