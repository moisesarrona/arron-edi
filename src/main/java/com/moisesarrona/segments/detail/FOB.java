package com.moisesarrona.segments.detail;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import lombok.Data;

@Data
public class FOB {

    @NotBlank(message = "Shipment Method of Payment is required")
    @Size(min = 2, max = 2, message = "Shipment Method of Payment must be 2 characters")
    private String shipmentMethodOfPayment;

    /*@Size(min = 1, max = 2, message = "Location Qualifier must be 1-2 characters")
    private String locationQualifier;

    @Size(min = 1, max = 30, message = "Location Identifier must be 1-30 characters")
    private String locationIdentifier;*/

}
