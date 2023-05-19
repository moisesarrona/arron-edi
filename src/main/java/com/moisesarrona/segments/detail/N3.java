package com.moisesarrona.segments.detail;

import lombok.Data;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Data
public class N3 {

    @NotBlank(message = "Address Information cannot be blank")
    @Size(min = 1, max = 55, message = "Address Information must be between 1 and 55 characters long")
    private String addressInformation;

    @Size(min = 1, max = 55, message = "Address Information 2 must be between 1 and 55 characters long")
    private String addressInformation2;

}
