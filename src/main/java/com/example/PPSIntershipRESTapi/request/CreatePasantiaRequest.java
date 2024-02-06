package com.example.PPSIntershipRESTapi.request;

import lombok.Data;

import java.util.Date;

@Data
public class CreatePasantiaRequest {
    private Integer intershipId;
    private Integer intershipStatusCode;
    private String intershipTitle;
    private Integer enterpriseId;
    private Date intershipStartDate;
    private Date intershipCompletionDate;
    private String studentDNI;
    private String schoolCouncilId;
    private String schoolCouncilDecision;
    private String corporateTutorDNI;
}
