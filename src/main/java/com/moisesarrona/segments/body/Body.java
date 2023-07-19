package com.moisesarrona.segments.body;

import lombok.Data;

import java.util.List;

@Data
public class Body {

    private Head HEAD;

    private List<Detail> DETAIL;

    private Summary SUMMARY;

}
