package com.example.PPSIntershipRESTapi.repository;

import com.example.PPSIntershipRESTapi.entity.SeccionesEvaluacionPasantiaTutorAcademico;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SeccionesEvaluacionPasantiaTutorAcademicoRepository extends CrudRepository<SeccionesEvaluacionPasantiaTutorAcademico,Integer> {
}
