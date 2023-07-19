package com.moisesarrona.segments.summary;

import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Data
public class IEA {

    @Size(min = 1, max = 5, message = "Number of Included Functional Groups must be between 1 and 5 characters long")
    @NotBlank(message = "Number of Included Functional Groups cannot be blank")
    private String numberOfIncludedFunctionalGroups;

    @Size(min = 9, max = 9, message = "Interchange Control Number must be 9 characters long")
    @NotBlank(message = "Interchange Control Number cannot be blank")
    private String interchangeControlNumber;

}
