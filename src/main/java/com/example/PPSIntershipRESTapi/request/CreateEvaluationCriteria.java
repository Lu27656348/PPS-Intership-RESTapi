package com.example.PPSIntershipRESTapi.request;

import lombok.Data;

@Data
public class CreateEvaluationCriteria {
    String userDNI;
    Integer intershipId;
    Integer criteriaId;
    Integer criteriaNote;
    Integer maxNote;
}
