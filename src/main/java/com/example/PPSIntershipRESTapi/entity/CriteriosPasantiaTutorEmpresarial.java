package com.example.PPSIntershipRESTapi.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "criteriosevaluacionpasantiatutorempresarial")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CriteriosPasantiaTutorEmpresarial {
    @Id
    @Column(name = "criteriaid")
    private Integer criteriaId;

    @Column(name = "criterianame")
    private String criteriaName;

    @Column(name = "criteriadescription")
    private String criteriaDescription;

    @Column(name = "maxnote")
    private Integer maxNote;

    @Column(name = "model")
    private String model;

    @Column(name = "status")
    private Boolean status;

    @Column(name = "seccionid")
    private Integer seccionId;
}
