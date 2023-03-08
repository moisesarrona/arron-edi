package com.moisesarrona.segments.detail;

import lombok.Data;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

@Data
public class N1 {

    @NotBlank(message = "Entity Identifier Code cannot be blank")
    @Size(min = 2, max = 3, message = "Entity Identifier Code must be between 2 and 3 characters long")
    private String entityIdentifierCode;

    @Size(min = 1, max = 60, message = "Name must be between 1 and 60 characters long")
    private String name;

    @Size(min = 1, max = 2, message = "Identification Code Qualifier must be between 1 and 2 characters long")
    private String identificationCodeQualifier;

    @Size(min = 9, max = 9, message = "Identification Code must be 9 characters long")
    private String identificationCode;

}
