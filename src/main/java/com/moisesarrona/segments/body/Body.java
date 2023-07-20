package com.moisesarrona.segments.body;

import lombok.Data;

import java.util.List;

@Data
public class Body {

    private Head head;

    private List<Detail> details;

    private Summary summary;

}
