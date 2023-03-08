package com.moisesarrona.segments.heading;

import lombok.Data;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

@Data
public class GS {

    @NotBlank(message = "Functional Identifier Code cannot be blank")
    @Size(min = 2, max = 2, message = "Functional Identifier Code must be 2 characters long")
    private String functionalIdentifierCode;

    @NotBlank(message = "Application Sender's Code cannot be blank")
    @Size(min = 2, max = 15, message = "Application Sender's Code must be between 2 and 15 characters long")
    private String applicationSendersCode;

    @NotBlank(message = "Application Receiver's Code cannot be blank")
    @Size(min = 2, max = 15, message = "Application Receiver's Code must be between 2 and 15 characters long")
    private String applicationReceiversCode;

    @NotBlank(message = "Date cannot be blank")
    @Pattern(regexp = "\\d{8}", message = "Date must be in the format YYYYMMDD")
    private String date;

    @NotBlank(message = "Time cannot be blank")
    @Pattern(regexp = "\\d{4}", message = "Time must be in the format HHMM")
    private String time;

    @NotBlank(message = "Group Control Number cannot be blank")
    @Size(min = 1, max = 9, message = "Group Control Number must be between 1 and 9 characters long")
    private String groupControlNumber;

    @NotBlank(message = "Responsible Agency Code cannot be blank")
    @Size(min = 1, max = 2, message = "Responsible Agency Code must be 1 or 2 characters long")
    private String responsibleAgencyCode;

    @NotBlank(message = "Version / Release / Industry Identifier Code cannot be blank")
    @Size(min = 1, max = 12, message = "Version / Release / Industry Identifier Code must be between 1 and 12 characters long")
    private String versionReleaseIndustryIdentifierCode;

}
