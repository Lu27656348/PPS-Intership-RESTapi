package com.example.PPSIntershipRESTapi.repository;

import com.example.PPSIntershipRESTapi.entity.SeccionesEvaluacionPasantiaTutorAcademico;
import com.example.PPSIntershipRESTapi.entity.SeccionesEvaluacionPasantiaTutorEmpresarial;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SeccionesEvaluacionPasantiaTutorEmpresarialRepository extends CrudRepository<SeccionesEvaluacionPasantiaTutorEmpresarial, Integer> {
    @Query(
            value = "SELECT *\n" +
                    "FROM seccionesevaluacionpasantiatutorempresarial\n" +
                    "WHERE schoolname = :schoolName",
            nativeQuery = true
    )
    public List<SeccionesEvaluacionPasantiaTutorEmpresarial> getAllSeccionesBySchool(@Param("schoolName") String schoolName);
}
