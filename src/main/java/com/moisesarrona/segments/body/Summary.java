package com.moisesarrona.segments.body;

import com.moisesarrona.segments.summary.CTT;
import com.moisesarrona.segments.summary.GE;
import com.moisesarrona.segments.summary.IEA;
import com.moisesarrona.segments.summary.SE;
import lombok.Data;

@Data
public class Summary {

    private CTT ctt;

    private SE se;

    private GE ge;

    private IEA iea;

}
