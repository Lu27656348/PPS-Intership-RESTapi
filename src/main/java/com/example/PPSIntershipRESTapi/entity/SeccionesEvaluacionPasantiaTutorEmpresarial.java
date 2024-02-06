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
@Table(name = "seccionesevaluacionpasantiatutorempresarial")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class SeccionesEvaluacionPasantiaTutorEmpresarial {
    @Id
    @Column(name = "seccionid")
    private Integer seccionId;

    @Column(name = "seccionname")
    private String seccionName;

    @Column(name = "maxnote")
    private Integer maxNote;

}
