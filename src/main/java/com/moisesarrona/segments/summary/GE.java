package com.moisesarrona.segments.summary;

import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Data
public class GE {

    @NotBlank(message = "Number of Transaction Sets Included cannot be blank")
    @Size(min = 1, max = 6, message = "Number of Transaction Sets Included must be between 1 and 6 characters long")
    private Integer numberOfTransactionSetsIncluded;

    @NotBlank(message = "Group Control Number cannot be blank")
    @Size(min = 1, max = 9, message = "Group Control Number must be between 1 and 9 characters long")
    private String groupControlNumber;

}
