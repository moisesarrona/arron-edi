package com.moisesarrona.segments.heading;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class BSN {

    @NotNull(message = "Transaction Set Purpose Code cannot be null")
    @Size(min = 2, max = 2, message = "Transaction Set Purpose Code must be 3 characters long")
    private String transactionSetPurposeCode;

    @NotNull(message = "Shipment Identification cannot be null")
    @Size(min = 2, max = 15, message = "Shipment Identification must be between 2 and 15 characters long")
    private String shipmentIdentification;

    @NotNull(message = "Date cannot be null")
    @Pattern(regexp = "\\d{8}", message = "Date must be in the format YYYYMMDD")
    private String date;

    @NotNull(message = "Time cannot be null")
    @Pattern(regexp = "\\d{4}", message = "Time must be in the format HHMM")
    private String time;

}
