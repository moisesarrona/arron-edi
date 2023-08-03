package com.moisesarrona.segments.detail;

import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Data
public class HL {

    @Size(min = 1, max = 12, message = "Hierarchical ID Number must be between 1 and 12 characters long")
    @NotBlank(message = "Hierarchical ID Number cannot be blank")
    private String hierarchicalIdNumber;

    @Size(min = 9, max = 12, message = "Hierarchical Parent ID Number must be between 9 and 12 characters long")
    private String hierarchicalParentIdNumber;

    @Size(min = 1, max = 2, message = "Hierarchical Level Code must be 1 or 2 characters long")
    @NotBlank(message = "Hierarchical Level Code cannot be blank")
    private String hierarchicalLevelCode;

}
