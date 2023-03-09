package com.moisesarrona.segments.detail;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import lombok.Data;

@Data
public class LIN {

    @NotBlank(message = "Assigned Identification cannot be blank")
    @Size(min = 1, max = 20, message = "Assigned Identification must be between {min} and {max} characters long")
    private String assignedIdentification;

    @NotBlank(message = "Product/Service ID Qualifier cannot be blank")
    @Size(min = 2, max = 2, message = "Product/Service ID Qualifier must be {min} characters long")
    private String productServiceIDQualifier;

    @NotBlank(message = "Product/Service ID cannot be blank")
    @Size(min = 1, max = 8, message = "Product/Service ID must be between {min} and {max} characters long")
    private String productServiceID;

}