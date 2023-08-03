package com.moisesarrona.segments.heading;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class BSN {
    @NotBlank(message = "Transaction Set Purpose Code cannot be blank")
    @Size(min = 2, max = 2, message = "Transaction Set Purpose Code must be 2 characters long")
    private String transactionSetPurposeCode;

    @NotBlank(message = "Shipment Identification cannot be blank")
    @Size(min = 2, max = 15, message = "Shipment Identification must be between 2 and 15 characters long")
    private String shipmentIdentification;

    @NotBlank(message = "Date cannot be blank")
    @Size(min = 8, max = 8, message = "Date must be 8 characters long")
    private String date;

    @NotBlank(message = "Time cannot be blank")
    @Size(min = 4, max = 4, message = "Time must be 4 characters long")
    private String time;
}
