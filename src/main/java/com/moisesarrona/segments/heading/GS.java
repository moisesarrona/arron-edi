package com.moisesarrona.segments.heading;

import lombok.Data;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Data
public class GS {
    @NotBlank(message = "Functional Identifier Code cannot be blank")
    @Size(min = 2, max = 2, message = "Functional Identifier Code must be 2 characters long")
    private String functionalIdentifierCode;

    @NotBlank(message = "Application Sender's Code cannot be blank")
    @Size(min = 2, max = 15, message = "Application Sender's Code must be between 2 and 15 characters long")
    private String applicationSenderCode;

    @NotBlank(message = "Application Receiver's Code cannot be blank")
    @Size(min = 2, max = 15, message = "Application Receiver's Code must be between 2 and 15 characters long")
    private String applicationReceiverCode;

    @NotBlank(message = "Date cannot be blank")
    @Size(min = 8, max = 8, message = "Date must be 8 characters long")
    private String date;

    @NotBlank(message = "Time cannot be blank")
    @Size(min = 4, max = 4, message = "Time must be between 4 and 8 characters long")
    private String time;

    @NotBlank(message = "Group Control Number cannot be blank")
    @Size(min = 1, max = 9, message = "Group Control Number must be between 1 and 9 characters long")
    private String groupControlNumber;

    @NotBlank(message = "Responsible Agency Code cannot be blank")
    @Size(min = 1, max = 2, message = "Responsible Agency Code must be between 1 and 2 characters long")
    private String responsibleAgencyCode;

    @NotBlank(message = "Version / Release / Industry Identifier Code cannot be blank")
    @Size(min = 1, max = 12, message = "Version / Release / Industry Identifier Code must be between 1 and 12 characters long")
    private String versionReleaseIndustryIdentifierCode;
}
