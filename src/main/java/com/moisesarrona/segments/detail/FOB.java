package com.moisesarrona.segments.detail;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import lombok.Data;

@Data
public class FOB {

    @NotBlank(message = "Reference Identification Qualifier cannot be blank")
    @Size(min = 2, max = 3, message = "Reference Identification Qualifier must be between 2 and 3 characters long")
    private String referenceIdentificationQualifier;

    @Size(min = 1, max = 5, message = "Reference Identification must be between 1 and 5 characters long")
    private String referenceIdentification;

}
