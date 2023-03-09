package com.moisesarrona.segments.detail;

import lombok.Data;

import javax.validation.constraints.Size;

@Data
public class MEA {

    @Size(min = 2, max = 2, message = "Measurement Reference ID Code must be 2 characters long")
    private String measurementReferenceIDCode;

    @Size(min = 1, max = 3, message = "Measurement Qualifier must be between 1 and 3 characters long")
    private String measurementQualifier;

    @Size(min = 1, max = 20, message = "Measurement Value must be between 1 and 20 characters long")
    private String measurementValue;

    @Size(min = 2, max = 2, message = "Composite Unit of Measure must be 2 characters long")
    private String compositeUnitOfMeasure;

    /*@Size(min = 1, max = 20, message = "Range Minimum must be between 1 and 20 characters long")
    private String rangeMinimum;

    @Size(min = 1, max = 20, message = "Range Maximum must be between 1 and 20 characters long")
    private String rangeMaximum;

    @Size(min = 2, max = 2, message = "Measurement Significance Code must be 2 characters long")
    private String measurementSignificanceCode;*/

}
