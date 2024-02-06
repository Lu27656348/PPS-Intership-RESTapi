package com.example.PPSIntershipRESTapi.controllers;

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
}
