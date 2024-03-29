package com.example.PPSIntershipRESTapi.controllers;

import com.example.PPSIntershipRESTapi.entity.CriteriosPasantiaTutorAcademico;
import com.example.PPSIntershipRESTapi.entity.CriteriosPasantiaTutorEmpresarial;
import com.example.PPSIntershipRESTapi.entity.SeccionesEvaluacionPasantiaTutorEmpresarial;
import com.example.PPSIntershipRESTapi.services.CriteriosPasantiaTutorEmpresarialService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/pasantia/criterios/empresarial")
public class CriteriosPasantiaTutorEmpresarialController {
    private final CriteriosPasantiaTutorEmpresarialService criteriosPasantiaTutorEmpresarialService;

    public CriteriosPasantiaTutorEmpresarialController(CriteriosPasantiaTutorEmpresarialService criteriosPasantiaTutorEmpresarialService) {
        this.criteriosPasantiaTutorEmpresarialService = criteriosPasantiaTutorEmpresarialService;
    }


    @GetMapping("get")
    public List<CriteriosPasantiaTutorEmpresarial> getAllCriteriosPasantiaTutorEmpresarial(){
        return criteriosPasantiaTutorEmpresarialService.getAllCriteriosPasantiaTutorEmpresarial();
    }

    @GetMapping("get/by/seccion/{id}")
    public List<CriteriosPasantiaTutorEmpresarial> getCriteriosPasantiaTutorEmpresarialBySeccion(@PathVariable Integer id){
        return criteriosPasantiaTutorEmpresarialService.getCriteriosPasantiaTutorEmpresarialBySeccion(id);
    }

    @PutMapping("/put/{id}")
    public CriteriosPasantiaTutorEmpresarial changeCriteria(@PathVariable Integer id, @RequestBody CriteriosPasantiaTutorEmpresarial criteriosPasantiaTutorEmpresarial){
        return criteriosPasantiaTutorEmpresarialService.changeCriteria(id,criteriosPasantiaTutorEmpresarial);
    }

    @PutMapping("/put/{id}/status/{status}")
    public CriteriosPasantiaTutorEmpresarial changeCriteriaStatus(@PathVariable Integer id, @PathVariable Boolean status){
        return criteriosPasantiaTutorEmpresarialService.changeCriteriaStatus(id,status);
    }


    @GetMapping("/get/by/school/{schoolName}")
    public List<CriteriosPasantiaTutorEmpresarial> getAllCriteriosPasantiaTutorEmpresarialBySchool(@PathVariable String schoolName){
        return criteriosPasantiaTutorEmpresarialService.getAllCriteriosPasantiaTutorEmpresarialBySchool(schoolName);
    }
    @PostMapping("/post")
    public CriteriosPasantiaTutorEmpresarial createCriteria(@RequestBody CriteriosPasantiaTutorEmpresarial criteriaData){
        return criteriosPasantiaTutorEmpresarialService.createCriteria(criteriaData);
    }


}
