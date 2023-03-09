package com.moisesarrona.segments.detail;

import lombok.Data;

import javax.validation.constraints.Size;

@Data
public class TD5 {

    @Size(min = 1, max = 2, message = "Routing Sequence code must be between 1 and 2 characters long")
    private String routingSequenceCode;

    @Size(min = 1, max = 2, message = "Routing Sequence Qualifier code must be between 1 and 2 characters long")
    private String identificationCodeQualifier;

    @Size(min = 1, max = 80, message = "Identification Code must be between 1 and 80 characters long")
    private String identificationCode;

    @Size(min = 2, max = 2, message = "Transportation Method code must be 2 characters long")
    private String transportationMethodCode;

    /*@Size(min = 1, max = 35, message = "Routing must be between 1 and 35 characters long")
    private String routing;

    @Size(min = 2, max = 2, message = "Shipment or Order Status Code must be 2 characters long")
    private String shipmentOrOrderStatusCode;

    @Size(min = 1, max = 2, message = "Location Qualifier must be between 1 and 2 characters long")
    private String locationQualifier;

    @Size(min = 1, max = 30, message = "Location Identifier must be between 1 and 30 characters long")
    private String locationIdentifier;*/

}
