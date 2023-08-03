package com.moisesarrona.segments.detail;

import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Data
public class PRF {

    @NotBlank(message = "Purchase Order Number cannot be blank")
    @Size(min = 5, max = 5, message = "Purchase Order Number must be 5 characters long")
    private String purchaseOrderNumber;

    @NotBlank(message = "Release Number cannot be blank")
    @Size(min = 2, max = 2, message = "Release Number must be 2 characters long")
    private String releaseNumber;

}
