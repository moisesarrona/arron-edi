package com.moisesarrona.arronedi.segments.heading;

import lombok.Data;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Data
public class DTM {
    @NotBlank(message = "Date/Time Qualifier cannot be blank")
    @Size(min = 3, max = 3, message = "Date/Time Qualifier must be 3 characters long")
    private String dateTimeQualifier;

    @Size(min = 8, max = 8, message = "Date must be 8 characters long")
    private String date;

    @Size(min = 4, max = 4, message = "Time must be 4 characters long")
    private String time;

    @Size(min = 2, max = 2, message = "Time Code must be 2 characters long")
    private String timeCode;
}
