# ArronEdi - x12
Open source library written in java 17 to translate and convert EDIx12 documents to json, classes, natural language. Library is under initial construction, so it will undergo important structural changes.

>__v0.1.0__  
__Author:__ [@moisesarrona](https://github.com/mosesarrona)  
__Description:__ Read and convert object class to json.

## Features

### Methods
- Json
  - `jsonFileToObject()` - Convert json to abstract classes for handling in java. **Parameters:** path: String.
  - `jsonStringToObject()` Convert json to abstract classes for handling in java. **Parameters:** json: String.
  - `jsonFileToEdi()` - Convert json to format EDIx12. **Parameters:** json: String, path: boolean.
- Object
  - `objectToJson()` - Convert object to json. **Parameters:** body: Body.class.
  - `objectToEdi()` - Convert object to EDIx12. **Parameters:** body: Body.class.
- EDI

### Technologies
- Java 17: Java 17 is the `core` of the library, the most recent features of the version are used.
- Lombok: It is used for code reduction, in `mapping` classes
- Gson: It is used `temporarily`, it is intended that in future versions it will be `replaced`, by functions created by us.

## About this

### Community
If you want to contribute in this project, you can do it, you do fork this repository and work in your changes, create pull request to our maintainer team verify yor changes and we create merge.

If you want to use this library, you can by downloading the .jar of the version you want to use. At this moment we do not have a maven repository, we are working on it.

### Versioning
- MAJOR: version when you make incompatible API changes.
- MINOR: version when you add functionality in a backward compatible manner.
- PATCH: version when you make backward compatible bug fixes.

## Output and input formats
JSON format output
```json
{
  "head": {
    "isa": {
      "authorizationInformationQualifier": "AI",
      "authorizationInformation": "1234567890",
      "securityInformationQualifier": "SI",
      "securityInformation": "1234567890",
      "interchangeIdQualifier1": "ZZ",
      "interchangeSenderId": "SENDER1234567890",
      "interchangeIdQualifier2": "ZZ",
      "interchangeReceiverId": "RECEIVER1234567",
      "interchangeDate": "220315",
      "interchangeTime": "1200",
      "interchangeControlStandardsIdentifier": "U",
      "interchangeControlVersionNumber": "00401",
      "interchangeControlNumber": "000000001",
      "acknowledgmentRequested": "0",
      "usageIndicator": "P",
      "componentElementSeparator": ":"
    },
    "gs": {
      "functionalIdentifierCode": "FI",
      "applicationSendersCode": "ASCode",
      "applicationReceiversCode": "ARCode",
      "date": "20220315",
      "time": "1200",
      "groupControlNumber": "123456789",
      "responsibleAgencyCode": "RA",
      "versionReleaseIndustryIdentifierCode": "VRIC"
    },
    "st": {
      "transactionSetIdentifierCode": "123",
      "transactionSetControlNumber": "456789"
    },
    "bsn": {
      "transactionSetPurposeCode": "XX",
      "shipmentIdentification": "123456789",
      "date": "20220315",
      "time": "1530"
    },
    "dtm": {
      "dateTimeQualifier": "DTM",
      "date": "20220315",
      "time": "1245",
      "timeCode": "PT"
    }
  },
  "details": [
    {
      "hl": {
        "hierarchicalIDNumber": "1234567890",
        "hierarchicalParentIDNumber": "0987654321",
        "hierarchicalLevelCode": "1"
      },
      "mea": {
        "measurementReferenceIDCode": "01",
        "measurementQualifier": "WE",
        "measurementValue": "100",
        "compositeUnitOfMeasure": "LB"
      },
      "td1": {
        "packagingCode": "PKG",
        "ladingQuantity": "1000"
      },
      "td5": {
        "routingSequenceCode": "1",
        "identificationCodeQualifier": "ZZ",
        "identificationCode": "Carrier123",
        "transportationMethodCode": "AA"
      },
      "ref": {
        "referenceIdentificationQualifier": "IA",
        "referenceIdentification": "1234"
      },
      "fob": {
        "shipmentMethodOfPayment": "PP"
      },
      "n1": {
        "entityIdentifierCode": "AC",
        "name": "ABC Corporation",
        "identificationCodeQualifier": "91",
        "identificationCode": "123456789"
      },
      "n3": {
        "addressInformation": "123 Main St.",
        "addressInformation2": "Suite 100"
      },
      "n4": {
        "cityName": "Los Angeles",
        "stateOrProvinceCode": "CA",
        "postalCode": "90001",
        "countryCode": "US"
      },
      "lin": {
        "assignedIdentification": "12345",
        "productServiceIDQualifier": "AB",
        "productServiceID": "6789"
      },
      "sn1": {
        "assignedIdentification": "12345",
        "numberOfUnitsShipped": 100,
        "unitOrBasisForMeasurementCode": "EA",
        "quantityShippedToDate": 500
      },
      "prf": {
        "purchaseOrderNumber": "12345",
        "releaseNumber": "01",
        "changeOrderSequenceNumber": "12345678"
      },
      "pid": {
        "itemDescriptionType": "1",
        "productDescription": "Product Description",
        "agencyQualifierCode": "AG"
      }
    }
  ],
  "summary": {
    "ctt": {
      "numberOfLineItems": 10,
      "hashTotal": 1234.56
    },
    "se": {
      "numberOfIncludedSegments": 20,
      "transactionSetControlNumber": "0001"
    },
    "ge": {
      "numberOfTransactionSetsIncluded": 2,
      "groupControlNumber": "123456789"
    },
    "iea": {
      "numberOfIncludedGroups": 1,
      "interchangeControlNumber": "000000001"
    }
  }
}
```

EDIx12 format output
```
ISA*00*Authorizat*00*Security I*01*Interchange Sen*01*004293478      *020926*2218*U*00401*000017955*0*P*^~
GS*SH*Application Sen*Application Rec*19960515*2218*000000001*X*004010~
ST*856*0001~
BSN*00*Shipm*19960515*2218~
DTM*011*19960515*2218~
DTM*017*19960515*2330~
HL*1*0*S~
MEA*PD*G*14652*KG~
TD1*BOX*15337~
TD5*B*2*12345ABC*A~
REF*BM*12345~
FOB*CC~
N1*SF*Name*1*12345XXXX~
N1*ST*Name*92*01~
HL*2*1*I~
LIN**BP*Product/~
SN1**12540*EA*126034~
PRF*12345*01~
PID*F****Description~
TD1*ROL*8~
REF*SO*INVOICE #~
CTT*1*12540~
SE*20*0001~
GE*1*000000001~
IEA*1*000017955~
```

Object format input
```java
ISA isa = new ISA();
GS gs = new GS();
ST st = new ST();

BSN bsn = new BSN();
DTM dtm = new DTM();
HL hl = new HL();
MEA mea = new MEA();
TD1 td1 = new TD1();
TD5 td5 = new TD5();
REF ref = new REF();
FOB fob = new FOB();
N1 n1 = new N1();
N3 n3 = new N3();
N4 n4 = new N4();
LIN lin = new LIN();
SN1 sn1 = new SN1();
PRF prf = new PRF();
PID pid = new PID();

CTT ctt = new CTT();
GE ge = new GE();
IEA iea = new IEA();
SE se = new SE();

Head head = new Head();
List<Detail> details = new ArrayList<>();
Detail detail = new Detail();
Summary summary = new Summary();

Body body = new Body();

```

### About me 👨‍💻
Hi, my name is **Moises Arrona** I'm creator this library, follow me in [Github](https://github.com/mosesarrona) for more projects or [Instagram](https://www.instagram.com/moisesarrona/) for anything