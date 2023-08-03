package com.moisesarrona.segments.detail;

import lombok.Data;

import javax.validation.constraints.Size;

@Data
public class TD1 {

    @Size(min = 3, max = 3, message = "Packaging Code must be 3 characters long")
    private String packagingCode;

    @Size(min = 1, max = 7, message = "Lading Quantity must be between 1 and 7 characters long")
    private String ladingQuantity;

}
