package com.example.PPSIntershipRESTapi.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Entity
@Table(name = "pasantia")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Pasantia {
    @Id
    @Column(name = "intershipid")
    private Integer intershipId;

    @Column(name = "intershiptitle")
    private String intershipTitle;

    @Column(name = "intershipstartdate")
    private Date intershipStartDate;

    @Column(name = "intershipcompletiondate")
    private Date intershipCompletionDate;

    @Column(name = "studentdni")
    private String studentDNI;

    @Column(name = "enterpriseid")
    private Integer enterpriseId;

    @Column(name = "academictutordni")
    private String academicTutorDNI;

    @Column(name = "corporatetutordni")
    private String corporateTutorDNI;

    @Column(name = "intershipstatuscode")
    private String intershipStatusCode;

    @Column(name = "schoolcouncilid")
    private String schoolCouncilId;

    @Column(name = "schoolcouncildecision")
    private String schoolCouncilDecision;
}
