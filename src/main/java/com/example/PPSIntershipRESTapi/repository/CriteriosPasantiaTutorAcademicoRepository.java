package com.example.PPSIntershipRESTapi.repository;

import com.example.PPSIntershipRESTapi.entity.CriteriosPasantiaTutorAcademico;
import com.example.PPSIntershipRESTapi.entity.CriteriosPasantiaTutorEmpresarial;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CriteriosPasantiaTutorAcademicoRepository extends CrudRepository<CriteriosPasantiaTutorAcademico,Integer> {

    @Query(
            value = "SELECT *\n" +
                    "FROM criteriosevaluacionpasantiatutoracademico\n" +
                    "WHERE seccionId = :seccionId",
            nativeQuery = true
    )
    public List<CriteriosPasantiaTutorAcademico> getCriteriosPasantiaTutorAcademicoBySeccion(@Param("seccionId") Integer seccionId);

    @Query(
            value = "SELECT *\n" +
                    "FROM criteriosevaluacionpasantiatutoracademico\n" +
                    "WHERE schoolname = :schoolName",
            nativeQuery = true
    )
    public List<CriteriosPasantiaTutorAcademico> getAllCriteriosPasantiaTutorAcademicoBySchool(@Param("schoolName") String schoolName);
}
