package com.moisesarrona.arronedi.segments.summary;

import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;


@Data
public class CTT {

    @Size(min = 1, max = 6, message = "Number of Line Items must be between 1 and 6 characters long")
    @NotBlank(message = "Number of Line Items cannot be blank")
    private String numberOfLineItems;

    @Size(min = 1, max = 10, message = "Hash Total must be between 1 and 10 characters long")
    private String hashTotal;

}
