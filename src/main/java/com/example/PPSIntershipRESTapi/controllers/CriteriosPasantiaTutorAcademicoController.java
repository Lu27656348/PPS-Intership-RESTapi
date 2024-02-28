package com.example.PPSIntershipRESTapi.controllers;

import com.example.PPSIntershipRESTapi.entity.CriteriosPasantiaTutorAcademico;
import com.example.PPSIntershipRESTapi.entity.SeccionesEvaluacionPasantiaTutorAcademico;
import com.example.PPSIntershipRESTapi.services.CriteriosPasantiaTutorAcademicoService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/pasantia/criterios/academico")
public class CriteriosPasantiaTutorAcademicoController {
    private final CriteriosPasantiaTutorAcademicoService criteriosPasantiaTutorAcademicoServiceService;

    public CriteriosPasantiaTutorAcademicoController(CriteriosPasantiaTutorAcademicoService criteriosPasantiaTutorAcademicoServiceService) {
        this.criteriosPasantiaTutorAcademicoServiceService = criteriosPasantiaTutorAcademicoServiceService;
    }


    @GetMapping("get")
    public List<CriteriosPasantiaTutorAcademico> getAllCriteriosPasantiaTutorAcademico(){
        return criteriosPasantiaTutorAcademicoServiceService.getAllCriteriosPasantiaTutorAcademico();
    }

    @GetMapping("/get/by/school/{schoolName}")
    public List<CriteriosPasantiaTutorAcademico> getAllCriteriosPasantiaTutorAcademicoBySchool(@PathVariable String schoolName){
        return criteriosPasantiaTutorAcademicoServiceService.getAllCriteriosPasantiaTutorAcademicoBySchool(schoolName);
    }



    @GetMapping("get/by/seccion/{id}")
    public List<CriteriosPasantiaTutorAcademico> getCriteriosPasantiaTutorAcademicoBySeccion(@PathVariable Integer id){
        return criteriosPasantiaTutorAcademicoServiceService.getCriteriosPasantiaTutorAcademicoBySeccion(id);
    }

    @PutMapping("/put/{id}")
    public CriteriosPasantiaTutorAcademico changeCriteria(@PathVariable Integer id, @RequestBody CriteriosPasantiaTutorAcademico criteriosPasantiaTutorAcademico){
        return criteriosPasantiaTutorAcademicoServiceService.changeCriteria(id,criteriosPasantiaTutorAcademico);
    }

    @PostMapping("/post")
    public CriteriosPasantiaTutorAcademico createCriteria(@RequestBody CriteriosPasantiaTutorAcademico criteriaData){
        return criteriosPasantiaTutorAcademicoServiceService.createCriteria(criteriaData);
    }
}
