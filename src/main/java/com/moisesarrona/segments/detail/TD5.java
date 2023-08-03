package com.moisesarrona.segments.detail;

import lombok.Data;

import javax.validation.constraints.Size;

@Data
public class TD5 {

    @Size(min = 1, max = 2, message = "Routing Sequence Code must be between 1 and 2 characters long")
    private String routingSequenceCode;

    @Size(min = 1, max = 2, message = "Identification Code Qualifier must be between 1 and 2 characters long")
    private String identificationCodeQualifier;

    @Size(min = 2, max = 10, message = "Identification Code must be between 2 and 10 characters long")
    private String identificationCode;

    @Size(min = 1, max = 2, message = "Transportation Method/Type Code must be between 1 and 2 characters long")
    private String transportationMethodTypeCode;

}
