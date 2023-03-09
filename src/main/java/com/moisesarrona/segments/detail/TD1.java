package com.moisesarrona.segments.detail;

import lombok.Data;

import javax.validation.constraints.Size;

@Data
public class TD1 {

    @Size(min = 3, max = 3, message = "Packaging Code must be 3 characters long")
    private String packagingCode;

    @Size(min = 1, max = 7, message = "Lading Quantity must be between 1 and 7 characters long")
    private String ladingQuantity;

    /*@Size(min = 1, max = 1, message = "Commodity CodeQualifier must be 1 characters long")
    private String commodityCodeQualifier;

    @Size(min = 1, max = 30, message = "Commodity Code must be between 1 and 30 characters long")
    private String commodityCode;

    @Size(min = 1, max = 50, message = "Lading Description must be between 1 and 50 characters long")
    private String ladingDescription;

    @Size(min = 1, max = 2, message = "Weight Qualifier must be between 1 and 2 characters long")
    private String weightQualifier;

    @Size(min = 1, max = 10, message = "Weight must be between 1 and 10 characters long")
    private String Weight;*/

}
