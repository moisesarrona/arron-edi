package com.moisesarrona.arronedi.segments.body;

import com.moisesarrona.arronedi.segments.summary.CTT;
import com.moisesarrona.arronedi.segments.summary.GE;
import com.moisesarrona.arronedi.segments.summary.IEA;
import com.moisesarrona.arronedi.segments.summary.SE;
import lombok.Data;

@Data
public class Summary {

    private CTT ctt;

    private SE se;

    private GE ge;

    private IEA iea;

}
