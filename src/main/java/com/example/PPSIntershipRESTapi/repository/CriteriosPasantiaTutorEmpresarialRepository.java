package com.example.PPSIntershipRESTapi.repository;

import com.example.PPSIntershipRESTapi.entity.CriteriosPasantiaTutorEmpresarial;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CriteriosPasantiaTutorEmpresarialRepository extends CrudRepository<CriteriosPasantiaTutorEmpresarial,Integer> {

    @Query(
            value = "SELECT *\n" +
                    "FROM criteriosevaluacionpasantiatutorempresarial\n" +
                    "WHERE seccionId = :seccionId",
            nativeQuery = true
    )
    public List<CriteriosPasantiaTutorEmpresarial> getCriteriosPasantiaTutorEmpresarialBySeccion(@Param("seccionId") Integer seccionId);
}
