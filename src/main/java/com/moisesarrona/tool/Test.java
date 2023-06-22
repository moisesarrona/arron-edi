package com.moisesarrona.tool;

import com.moisesarrona.segments.body.*;
import com.moisesarrona.segments.detail.*;
import com.moisesarrona.segments.heading.*;
import com.moisesarrona.segments.summary.*;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class Test implements TestInterface {

    final String pathJson = "./edi/edi.json";

    final String pathEdi = "./edi/edi.x12";

    @Override
    public String getStrJson () {
        Utility utility = new Utility();
        return utility.readFile(pathJson);
    }

    @Override
    public String getStrEdi () {
        Utility utility = new Utility();
        return utility.readFile(pathEdi);
    }

    @Override
    public Body getObjectEdi() {
        //HEAD
        ISA isa = new ISA();
        isa.setAuthorizationInformationQualifier("AI");
        isa.setAuthorizationInformation("1234567890");
        isa.setSecurityInformationQualifier("SI");
        isa.setSecurityInformation("1234567890");
        isa.setInterchangeIdQualifier1("ZZ");
        isa.setInterchangeSenderId("SENDER1234567890");
        isa.setInterchangeIdQualifier2("ZZ");
        isa.setInterchangeReceiverId("RECEIVER1234567");
        isa.setInterchangeDate("220315");
        isa.setInterchangeTime("1200");
        isa.setInterchangeControlStandardsIdentifier("U");
        isa.setInterchangeControlVersionNumber("00401");
        isa.setInterchangeControlNumber("000000001");
        isa.setAcknowledgmentRequested("0");
        isa.setUsageIndicator("P");
        isa.setComponentElementSeparator(":");

        GS gs = new GS();
        gs.setFunctionalIdentifierCode("FI");
        gs.setApplicationSendersCode("ASCode");
        gs.setApplicationReceiversCode("ARCode");
        gs.setDate("20220315");
        gs.setTime("1200");
        gs.setGroupControlNumber("123456789");
        gs.setResponsibleAgencyCode("RA");
        gs.setVersionReleaseIndustryIdentifierCode("VRIC");

        ST st = new ST();
        st.setTransactionSetIdentifierCode("123");
        st.setTransactionSetControlNumber("456789");

        BSN bsn = new BSN();
        bsn.setTransactionSetPurposeCode("XX");
        bsn.setShipmentIdentification("123456789");
        bsn.setDate("20220315");
        bsn.setTime("1530");

        DTM dtm = new DTM();
        dtm.setDateTimeQualifier("DTM");
        dtm.setDate("20220315");
        dtm.setTime("1245");
        dtm.setTimeCode("PT");

        HL hl = new HL();
        hl.setHierarchicalIDNumber("1234567890");
        hl.setHierarchicalParentIDNumber("0987654321");
        hl.setHierarchicalLevelCode("1");

        MEA mea = new MEA();
        mea.setMeasurementReferenceIDCode("01");
        mea.setMeasurementQualifier("WE");
        mea.setMeasurementValue("100");
        mea.setCompositeUnitOfMeasure("LB");

        TD1 td1 = new TD1();
        td1.setPackagingCode("PKG");
        td1.setLadingQuantity("1000");

        TD5 td5 = new TD5();
        td5.setRoutingSequenceCode("1");
        td5.setIdentificationCodeQualifier("ZZ");
        td5.setIdentificationCode("Carrier123");
        td5.setTransportationMethodCode("AA");

        REF ref = new REF();
        ref.setReferenceIdentificationQualifier("IA");
        ref.setReferenceIdentification("1234");

        FOB fob = new FOB();
        fob.setShipmentMethodOfPayment("PP");

        N1 n1 = new N1();
        n1.setEntityIdentifierCode("AC");
        n1.setName("ABC Corporation");
        n1.setIdentificationCodeQualifier("91");
        n1.setIdentificationCode("123456789");

        N3 n3 = new N3();
        n3.setAddressInformation("123 Main St.");
        n3.setAddressInformation2("Suite 100");

        N4 n4 = new N4();
        n4.setCityName("Los Angeles");
        n4.setStateOrProvinceCode("CA");
        n4.setCountryCode("US");
        n4.setPostalCode("90001");

        LIN lin = new LIN();
        lin.setAssignedIdentification("12345");
        lin.setProductServiceIDQualifier("AB");
        lin.setProductServiceID("6789");

        SN1 sn1 = new SN1();
        sn1.setAssignedIdentification("12345");
        sn1.setNumberOfUnitsShipped(100);
        sn1.setUnitOrBasisForMeasurementCode("EA");
        sn1.setQuantityShippedToDate(500);

        PRF prf = new PRF();
        prf.setPurchaseOrderNumber("12345");
        prf.setReleaseNumber("01");
        prf.setChangeOrderSequenceNumber("12345678");

        PID pid = new PID();
        pid.setItemDescriptionType("1");
        pid.setProductDescription("Product Description");
        pid.setAgencyQualifierCode("AG");

        CTT ctt = new CTT();
        ctt.setNumberOfLineItems(10);
        ctt.setHashTotal(1234.56);

        GE ge = new GE();
        ge.setNumberOfTransactionSetsIncluded(2);
        ge.setGroupControlNumber("123456789");

        IEA iea = new IEA();
        iea.setNumberOfIncludedGroups(1);
        iea.setInterchangeControlNumber("000000001");

        SE se = new SE();
        se.setNumberOfIncludedSegments(20);
        se.setTransactionSetControlNumber("0001");

        Head head = new Head();
        head.setIsa(isa);
        head.setGs(gs);
        head.setSt(st);
        head.setBsn(bsn);
        head.setDtm(dtm);

        List<Detail> details = new ArrayList<>();
        Detail detail = new Detail();
        detail.setHl(hl);
        detail.setMea(mea);
        detail.setTd1(td1);
        detail.setTd5(td5);
        detail.setRef(ref);
        detail.setFob(fob);
        detail.setN1(n1);
        detail.setN3(n3);
        detail.setN4(n4);
        detail.setLin(lin);
        detail.setSn1(sn1);
        detail.setPrf(prf);
        detail.setPid(pid);
        details.add(detail);
        details.add(detail);

        Summary summary = new Summary();
        summary.setCtt(ctt);
        summary.setSe(se);
        summary.setGe(ge);
        summary.setIea(iea);

        Body body = new Body();
        body.setHead(head);
        body.setDetails(details);
        body.setSummary(summary);

        return body;
    }

}
