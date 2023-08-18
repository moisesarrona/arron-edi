package com.moisesarrona.arronedi.tool;

import com.moisesarrona.arronedi.segments.body.*;
import com.moisesarrona.arronedi.segments.detail.*;
import com.moisesarrona.arronedi.segments.heading.*;
import com.moisesarrona.arronedi.segments.summary.*;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

/**
 * @author moisesarrona
 * @version 1.0
 */
@Data
public class Test implements TestInterface {

    final String pathJson = "./edi/edi.json";

    final String pathEdi = "./edi/edi.x12";

    /**
     * Read content JSON file
     *
     * @return Content from JSON file
     */
    @Override
    public String getStrJson () {
        Utility utility = new Utility();
        return utility.readFile(pathJson);
    }

    /**
     * Read content EDIx12 file
     *
     * @return Content from EDIx12 file
     */
    @Override
    public String getStrEdi () {
        Utility utility = new Utility();
        return utility.readFile(pathEdi);
    }

    /**
     * Set attributes to build EDI class
     *
     * @return Body EDIx12 class
     */
    @Override
    public Body getObjectEdi() {
        //HEAD
        ISA isa = new ISA();
        isa.setAuthorizationInformationQualifier("00");
        isa.setAuthorizationInformation("Authorizat");
        isa.setSecurityInformationQualifier("00");
        isa.setSecurityInformation("Security I");
        isa.setInterchangeIDQualifier1("01");
        isa.setInterchangeSenderID("Interchange Sen");
        isa.setInterchangeIDQualifier2("01");
        isa.setInterchangeReceiverID("004293478      ");
        isa.setInterchangeDate("020926");
        isa.setInterchangeTime("2218");
        isa.setInterchangeControlStandardsIdentifier("U");
        isa.setInterchangeControlVersionNumber("00401");
        isa.setInterchangeControlNumber("000017955");
        isa.setAcknowledgmentRequested("0");
        isa.setUsageIndicator("P");
        isa.setComponentElementSeparator("^");

        GS gs = new GS();
        gs.setFunctionalIdentifierCode("SH");
        gs.setApplicationSenderCode("Application Sen");
        gs.setApplicationReceiverCode("Application Rec");
        gs.setDate("19960515");
        gs.setTime("2218");
        gs.setGroupControlNumber("000000001");
        gs.setResponsibleAgencyCode("X");
        gs.setVersionReleaseIndustryIdentifierCode("004010");

        ST st = new ST();
        st.setTransactionSetIdentifierCode("856");
        st.setTransactionSetControlNumber("0001");

        BSN bsn = new BSN();
        bsn.setTransactionSetPurposeCode("00");
        bsn.setShipmentIdentification("Shipm");
        bsn.setDate("19960515");
        bsn.setTime("2218");

        DTM dtm = new DTM();
        dtm.setDateTimeQualifier("011");
        dtm.setDate("19960515");
        dtm.setTime("2218");
        dtm.setTimeCode("PT");//Ojo

        HL hl = new HL();
        hl.setHierarchicalIdNumber("1");
        hl.setHierarchicalParentIdNumber("0");
        hl.setHierarchicalLevelCode("S");

        MEA mea = new MEA();
        mea.setMeasurementReferenceIdCode("PD");
        mea.setMeasurementQualifier("G");
        mea.setMeasurementValue("14652");
        mea.setUnitOrBasisForMeasurementCode("KG");

        TD1 td1 = new TD1();
        td1.setPackagingCode("BOX");
        td1.setLadingQuantity("15337");

        TD5 td5 = new TD5();
        td5.setRoutingSequenceCode("B");
        td5.setIdentificationCodeQualifier("2");
        td5.setIdentificationCode("12345ABC");
        td5.setTransportationMethodTypeCode("A");

        REF ref = new REF();
        ref.setReferenceIdentificationQualifier("BM");
        ref.setReferenceIdentification("12345");

        FOB fob = new FOB();
        fob.setReferenceIdentificationQualifier("CC");

        N1 n1 = new N1();
        n1.setEntityIdentifierCode("SF");
        n1.setName("Name");
        n1.setIdentificationCodeQualifier("1");
        n1.setIdentificationCode("12345XXXX");

        N1 n1_ = new N1();
        n1_.setEntityIdentifierCode("ST");
        n1_.setName("Name");
        n1_.setIdentificationCodeQualifier("92");
        n1_.setIdentificationCode("01");

        HL hl_ = new HL();
        hl_.setHierarchicalIdNumber("2");
        hl_.setHierarchicalParentIdNumber("1");
        hl_.setHierarchicalLevelCode("I");

        LIN lin = new LIN();
        lin.setAssignedIdentification("");
        lin.setProductServiceIdQualifier("BP");
        lin.setProductServiceID("Product/");

        SN1 sn1 = new SN1();
        sn1.setAssignedIdentification("");
        sn1.setNumberOfUnitsShipped("12540");//N
        sn1.setUnitOrBasisForMeasurementCode("EA");
        sn1.setQuantityShippedToDate("126034");//N

        PRF prf = new PRF();
        prf.setPurchaseOrderNumber("12345");
        prf.setReleaseNumber("01");

        PID pid = new PID();
        pid.setItemDescriptionType("F");
        pid.setProductProcessCharacteristicCode("");
        pid.setAgencyQualifierCode("");
        pid.setProductDescriptionCode("");
        pid.setDescription("description");

        TD1 td1_ = new TD1();
        td1_.setPackagingCode("ROL");
        td1_.setLadingQuantity("8");

        REF ref_ = new REF();
        ref_.setReferenceIdentificationQualifier("SO");
        ref_.setReferenceIdentification("INVOICE #");

        CTT ctt = new CTT();
        ctt.setNumberOfLineItems("1");//N
        ctt.setHashTotal("12540");//N

        SE se = new SE();
        se.setNumberOfIncludedSegments("20");//N
        se.setTransactionSetControlNumber("0001");

        GE ge = new GE();
        ge.setNumberOfTransactionSetsIncluded("1");//N
        ge.setGroupControlNumber("000000001");

        IEA iea = new IEA();
        iea.setNumberOfIncludedFunctionalGroups("1");//N
        iea.setInterchangeControlNumber("000017955");


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
        detail.setN1(n1_);
        detail.setHl(hl_);
        detail.setLin(lin);
        detail.setSn1(sn1);
        detail.setPrf(prf);
        detail.setPid(pid);
        detail.setTd1(td1);
        detail.setRef(ref);
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
