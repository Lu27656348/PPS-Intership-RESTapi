package com.example.PPSIntershipRESTapi.controllers;

import com.example.PPSIntershipRESTapi.entity.SeccionesEvaluacionPasantiaTutorEmpresarial;
import com.example.PPSIntershipRESTapi.services.SeccionesEvaluacionPasantiaTutorEmpresarialService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/pasantia/secciones/empresarial")
public class SeccionesEvaluacionPasantiaTutorEmpresarialController {
    private final SeccionesEvaluacionPasantiaTutorEmpresarialService seccionesEvaluacionPasantiaTutorEmpresarialService;


    public SeccionesEvaluacionPasantiaTutorEmpresarialController(SeccionesEvaluacionPasantiaTutorEmpresarialService seccionesEvaluacionPasantiaTutorEmpresarialService) {
        this.seccionesEvaluacionPasantiaTutorEmpresarialService = seccionesEvaluacionPasantiaTutorEmpresarialService;
    }

    @GetMapping("/get")
    public List<SeccionesEvaluacionPasantiaTutorEmpresarial> getAllSecciones(){
        return seccionesEvaluacionPasantiaTutorEmpresarialService.getAllSecciones();
    }
}
