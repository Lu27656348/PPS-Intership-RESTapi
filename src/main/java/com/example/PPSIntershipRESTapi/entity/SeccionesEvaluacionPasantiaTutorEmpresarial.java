package com.example.PPSIntershipRESTapi.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "seccionesevaluacionpasantiatutorempresarial")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class SeccionesEvaluacionPasantiaTutorEmpresarial {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "seccionid")
    private Integer seccionId;

    @Column(name = "seccionname")
    private String seccionName;

    @Column(name = "maxnote")
    private Integer maxNote;

    @Column(name = "schoolname")
    private String schoolName;

    @Column(name = "status")
    private Boolean status;

}
