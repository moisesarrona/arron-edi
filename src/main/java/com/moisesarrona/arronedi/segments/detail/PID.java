package com.moisesarrona.arronedi.segments.detail;

import lombok.Data;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Data
public class PID {

    @NotBlank(message = "Item Description Type cannot be blank")
    @Size(min = 1, max = 1, message = "Item Description Type must be 1 character long")
    private String itemDescriptionType;

    @Size(min = 2, max = 3, message = "Product/Process Characteristic Code must be between 2 and 3 characters long")
    private String productProcessCharacteristicCode;

    @Size(min = 2, max = 2, message = "Agency Qualifier Code must be 2 characters long")
    private String agencyQualifierCode;

    @Size(min = 1, max = 12, message = "Product Description Code must be between 1 and 12 characters long")
    private String productDescriptionCode;

    @Size(min = 1, max = 30, message = "Description must be between 1 and 30 characters long")
    private String description;

}
