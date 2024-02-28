package com.example.PPSIntershipRESTapi.repository;

import com.example.PPSIntershipRESTapi.entity.SeccionesEvaluacionPasantiaTutorAcademico;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SeccionesEvaluacionPasantiaTutorAcademicoRepository extends CrudRepository<SeccionesEvaluacionPasantiaTutorAcademico,Integer> {
    @Query(
            value = "SELECT *\n" +
                    "FROM seccionesevaluacionpasantiatutoracademico\n" +
                    "WHERE schoolname = :schoolName",
            nativeQuery = true
    )
    public List<SeccionesEvaluacionPasantiaTutorAcademico> getAllSeccionesBySchool(@Param("schoolName") String schoolName);
}
