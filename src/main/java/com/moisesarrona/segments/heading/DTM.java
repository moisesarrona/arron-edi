package com.moisesarrona.segments.heading;

import lombok.Data;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

@Data
public class DTM {

    @NotBlank(message = "Date/Time Qualifier cannot be blank")
    @Size(min = 3, max = 3, message = "Date/Time Qualifier must be 3 characters long")
    private String dateTimeQualifier;

    @Pattern(regexp = "\\d{8}", message = "Interchange Date must be in the format YYYYMMDD")
    private String date;

    @Pattern(regexp = "\\d{4}", message = "Interchange Time must be in the format HHMM")
    private String time;

    @Size(min = 2, max = 2, message = "Time Code must be 2 long")
    private String timeCode;

}
