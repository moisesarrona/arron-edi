package com.moisesarrona.segments.detail;

import lombok.Data;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Data
public class PID {

    @NotBlank(message = "Item Description Type cannot be blank")
    @Size(min = 1, max = 1, message = "Item Description Type must be 1 characters long")
    private String itemDescriptionType;

    @Size(min = 1, max = 30, message = "Product Description must be between 1 and 30 characters long")
    private String productDescription;

    @Size(min = 2, max = 2, message = "Agency QualifierCode must be 2 characters long")
    private String agencyQualifierCode;

    /*@Size(min = 1, max = 12, message = "Product Or ServiceId Qualifier must be between 1 and 30 characters long")
    private String productOrServiceIdQualifier;

    @Size(min = 1, max = 30, message = "Product Description must be between 1 and 30 characters long")
    private String productOrServiceId;

    private String productCharacteristicsCode;

    private String description;

    @NotNull(message = "Surface or Layer Count cannot be null")
    private Integer surfaceOrLayerCount;

    private String surfaceOrLayerCode;*/

}
