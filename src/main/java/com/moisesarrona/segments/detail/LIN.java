package com.moisesarrona.segments.detail;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import lombok.Data;

@Data
public class LIN {

    @Size(min = 1, max = 20, message = "Assigned Identification must be between 1 and 20 characters long")
    private String assignedIdentification;

    @NotBlank(message = "Product/Service ID Qualifier cannot be blank")
    @Size(min = 2, max = 2, message = "Product/Service ID Qualifier must be 2 characters long")
    private String productServiceIdQualifier;

    @NotBlank(message = "Product/Service ID cannot be blank")
    @Size(min = 6, max = 8, message = "Product/Service ID must be between 6 and 8 characters long")
    private String productServiceID;

}