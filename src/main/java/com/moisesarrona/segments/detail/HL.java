package com.moisesarrona.segments.detail;

import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Data
public class HL {

    @NotBlank(message = "Hierarchical ID Number cannot be null")
    @Size(min = 1, max = 12, message = "Hierarchical ID Number must be between 1 and 12 characters long")
    private String hierarchicalIDNumber;

    @Size(min = 1, max = 12, message = "Hierarchical Parent ID Number must be between 1 and 12 characters long")
    private String hierarchicalParentIDNumber;

    @NotBlank(message = "Hierarchical Level Code cannot be null")
    @Size(min = 1, max = 2, message = "Hierarchical Level Code must be between 1 and 2 characters long")
    private String hierarchicalLevelCode;

    /*@Size(min = 1, max = 1, message = "Hierarchical Child Code must be 1 character long")
    private String hierarchicalChildCode;*/

}
