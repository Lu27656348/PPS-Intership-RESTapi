package com.example.PPSIntershipRESTapi.request;

import lombok.Data;

@Data
public class EvaluateIntershipReportRequest {
    private Integer intershipId;
    private Integer evaluacionTutorAcademico;
    private Integer evaluacionTutorEmpresarial;
}
