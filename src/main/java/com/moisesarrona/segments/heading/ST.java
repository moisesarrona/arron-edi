package com.moisesarrona.segments.heading;

import lombok.Data;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Data
public class ST {

    @NotBlank(message = "Transaction Set Identifier Code cannot be blank")
    @Size(min = 3, max = 3, message = "Transaction Set Identifier Code must be 3 characters long")
    private String transactionSetIdentifierCode;

    @NotBlank(message = "Transaction Set Control Number cannot be blank")
    @Size(min = 4, max = 9, message = "Transaction Set Control Number must be between 4 and 9 characters long")
    private String transactionSetControlNumber;

    /*@NotBlank(message = "Implementation Convention Reference cannot be blank")
    @Size(min = 1, max = 35, message = "Implementation Convention Reference must be between 1 and 35 characters long")
    private String implementationConventionReference;*/

}
