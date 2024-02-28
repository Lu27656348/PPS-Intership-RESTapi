package com.example.PPSIntershipRESTapi.entity;

import jakarta.persistence.*;
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
    @GeneratedValue(strategy = GenerationType.IDENTITY)
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

    @Column(name = "schoolname")
    private String schoolName;
}
