package com.moisesarrona.segments.summary;

import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Data
public class SE {

    @NotBlank(message = "Number of Included Segments cannot be blank")
    @Size(min = 1, max = 10, message = "Number of Included Segments must be between 1 and 10 characters long")
    private Integer numberOfIncludedSegments;

    @NotBlank(message = "Transaction Set Control Number cannot be blank")
    @Size(min = 4, max = 9, message = "Transaction Set Control Number must be between 4 and 9 characters long")
    private String transactionSetControlNumber;

}
