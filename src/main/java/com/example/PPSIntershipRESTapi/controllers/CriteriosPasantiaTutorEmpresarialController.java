package com.example.PPSIntershipRESTapi.controllers;

import com.example.PPSIntershipRESTapi.entity.CriteriosPasantiaTutorEmpresarial;
import com.example.PPSIntershipRESTapi.services.CriteriosPasantiaTutorEmpresarialService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
}
