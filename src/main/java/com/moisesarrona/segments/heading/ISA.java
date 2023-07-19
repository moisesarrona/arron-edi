package com.moisesarrona.segments.heading;

import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Data
public class ISA {
    @NotBlank(message = "Authorization Information Qualifier cannot be blank")
    @Size(min = 2, max = 2, message = "Authorization Information Qualifier must be 2 characters long")
    private String authorizationInformationQualifier;

    @NotBlank(message = "Authorization Information cannot be blank")
    @Size(min = 10, max = 10, message = "Authorization Information must be 10 characters long")
    private String authorizationInformation;

    @NotBlank(message = "Security Information Qualifier cannot be blank")
    @Size(min = 2, max = 2, message = "Security Information Qualifier must be 2 characters long")
    private String securityInformationQualifier;

    @NotBlank(message = "Security Information cannot be blank")
    @Size(min = 10, max = 10, message = "Security Information must be 10 characters long")
    private String securityInformation;

    @NotBlank(message = "Interchange ID Qualifier cannot be blank")
    @Size(min = 2, max = 2, message = "Interchange ID Qualifier must be 2 characters long")
    private String interchangeIDQualifier1;

    @NotBlank(message = "Interchange Sender ID cannot be blank")
    @Size(min = 15, max = 15, message = "Interchange Sender ID must be 15 characters long")
    private String interchangeSenderID;

    @NotBlank(message = "Interchange ID Qualifier cannot be blank")
    @Size(min = 2, max = 2, message = "Interchange ID Qualifier must be 2 characters long")
    private String interchangeIDQualifier2;

    @NotBlank(message = "Interchange Receiver ID cannot be blank")
    @Size(min = 15, max = 15, message = "Interchange Receiver ID must be 15 characters long")
    private String interchangeReceiverID;

    @NotBlank(message = "Interchange Date cannot be blank")
    @Size(min = 6, max = 6, message = "Interchange Date must be 6 characters long")
    private String interchangeDate;

    @NotBlank(message = "Interchange Time cannot be blank")
    @Size(min = 4, max = 4, message = "Interchange Time must be 4 characters long")
    private String interchangeTime;

    @NotBlank(message = "Interchange Control Standards Identifier cannot be blank")
    @Size(min = 1, max = 1, message = "Interchange Control Standards Identifier must be 1 character long")
    private String interchangeControlStandardsIdentifier;

    @NotBlank(message = "Interchange Control Version Number cannot be blank")
    @Size(min = 5, max = 5, message = "Interchange Control Version Number must be 5 characters long")
    private String interchangeControlVersionNumber;

    @NotBlank(message = "Interchange Control Number cannot be blank")
    @Size(min = 9, max = 9, message = "Interchange Control Number must be 9 characters long")
    private String interchangeControlNumber;

    @NotBlank(message = "Acknowledgment Requested cannot be blank")
    @Size(min = 1, max = 1, message = "Acknowledgment Requested must be 1 character long")
    private String acknowledgmentRequested;

    @NotBlank(message = "Usage Indicator cannot be blank")
    @Size(min = 1, max = 1, message = "Usage Indicator must be 1 character long")
    private String usageIndicator;

    @NotBlank(message = "Component Element Separator cannot be blank")
    @Size(min = 1, max = 1, message = "Component Element Separator must be 1 character long")
    private String componentElementSeparator;
}
