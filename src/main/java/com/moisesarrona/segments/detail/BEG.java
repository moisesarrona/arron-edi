package com.moisesarrona.segments.detail;

import lombok.Data;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

@Data
public class BEG {

    @NotBlank(message = "Transaction Set Purpose Code cannot be blank")
    @Size(min = 2, max = 2, message = "Transaction Set Purpose Code must be 2 characters long")
    private String transactionSetPurposeCode;

    @NotBlank(message = "Purchase Order Type cannot be blank")
    @Size(min = 2, max = 2, message = "Purchase Order Type must be 2 characters long")
    private String purchaseOrderType;

    @NotBlank(message = "Purchase Order Number cannot be blank")
    @Size(min = 1, max = 22, message = "Purchase Order Number must be between 1 and 22 characters long")
    private String purchaseOrderNumber;

    @NotBlank(message = "Release Number cannot be blank")
    @Size(min = 1, max = 30, message = "Release Number must be between 1 and 30 characters long")
    private String releaseNumber;

    @NotBlank(message = "Purchase Order Date cannot be blank")
    @Pattern(regexp = "\\d{8}", message = "Purchase Order Date must be in the format YYYYMMDD")
    private String purchaseOrderDate;

    @NotBlank(message = "Contract Number cannot be blank")
    @Size(min = 1, max = 30, message = "Contract Number must be between 1 and 30 characters long")
    private String contractNumber;

    @NotBlank(message = "Acknowledgment Type cannot be blank")
    @Size(min = 1, max = 2, message = "Acknowledgment Type must be 1 or 2 characters long")
    private String acknowledgmentType;

    @NotBlank(message = "Invoice Type Code cannot be blank")
    @Size(min = 2, max = 2, message = "Invoice Type Code must be 2 characters long")
    private String invoiceTypeCode;

}
