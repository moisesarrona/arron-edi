package com.moisesarrona.segments.detail;

import lombok.Data;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

@Data
public class REF {

    @NotBlank(message = "Reference Identification Qualifier cannot be blank")
    @Size(min = 2, max = 3, message = "Reference Identification Qualifier must be between 2 and 3 characters long")
    private String referenceIdentificationQualifier;

    @Size(min = 1, max = 30, message = "Reference Identification must be between 1 and 30 characters long")
    private String referenceIdentification;

    @Size(min = 2, max = 50, message = "Description cannot be longer than 50 characters")
    private String description;

}
