package com.example.PPSIntershipRESTapi.interfaces;

import jakarta.persistence.Column;

public interface CriteriosPasantiaTutorAcademicoProjection {
     Integer getCriteriaId();


     String getCriteriaName();


     String getCriteriaDescription();


     Integer getMaxNote();


     String getModel();


     Boolean getStatus();


     Integer getSeccionId();

     String getSeccionName();


     String getSchoolName();
}
