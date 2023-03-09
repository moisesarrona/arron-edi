package com.moisesarrona.segments.detail;

import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Data
public class PRF {

    @NotBlank(message = "Purchase Order Number cannot be null")
    @Size(min = 5,max = 5, message = "Purchase Order Number must be {min} characters long")
    private String purchaseOrderNumber;

    @Size(min = 2, max = 2, message = "Release Number must be {min} characters long")
    private String releaseNumber;

    @Size(min = 1, max = 8, message = "Change Order Sequence Number must be between {min} and {max} characters long")
    private String changeOrderSequenceNumber;

}
