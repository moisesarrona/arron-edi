package com.moisesarrona.segments.detail;

import lombok.Data;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

@Data
public class N4 {

    @NotBlank(message = "City Name cannot be blank")
    @Size(min = 2, max = 30, message = "City Name must be between 2 and 30 characters long")
    private String cityName;

    @NotBlank(message = "State or Province Code cannot be blank")
    @Size(min = 2, max = 2, message = "State or Province Code must be 2 characters long")
    private String stateOrProvinceCode;

    @Size(min = 3, max = 15, message = "Postal Code must be between 3 and 15 characters long")
    private String postalCode;

    @Size(min = 2, max = 3, message = "Country Code must be between 2 and 3 characters long")
    private String countryCode;

    @Size(min = 1, max = 2, message = "Location Qualifier must be between 1 and 2 characters long")
    private String locationQualifier;

}
