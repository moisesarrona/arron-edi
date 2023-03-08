package com.moisesarrona.segments.summary;

import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Data
public class IEA {

    @NotBlank(message = "Number of Included Groups cannot be blank")
    @Size(min = 1, max = 5, message = "Number of Included Groups must be between 1 and 5 characters long")
    private Integer numberOfIncludedGroups;

    @NotBlank(message = "Interchange Control Number cannot be blank")
    @Size(min = 9, max = 9, message = "Interchange Control Number must be exactly 9 characters long")
    private String interchangeControlNumber;

}
