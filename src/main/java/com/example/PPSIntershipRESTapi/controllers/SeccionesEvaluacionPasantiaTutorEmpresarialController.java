package com.example.PPSIntershipRESTapi.controllers;

import com.example.PPSIntershipRESTapi.entity.SeccionesEvaluacionPasantiaTutorAcademico;
import com.example.PPSIntershipRESTapi.entity.SeccionesEvaluacionPasantiaTutorEmpresarial;
import com.example.PPSIntershipRESTapi.services.SeccionesEvaluacionPasantiaTutorEmpresarialService;
import org.springframework.web.bind.annotation.*;

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

    @GetMapping("/get/by/{id}")
    public SeccionesEvaluacionPasantiaTutorEmpresarial getSeccionById(@PathVariable Integer id){
        return seccionesEvaluacionPasantiaTutorEmpresarialService.getSeccionById(id);
    }


    @PutMapping("/put/{id}")
    public SeccionesEvaluacionPasantiaTutorEmpresarial changeSeccion(@PathVariable Integer id, @RequestBody SeccionesEvaluacionPasantiaTutorEmpresarial seccionesEvaluacionPasantiaTutorEmpresarial){
        return seccionesEvaluacionPasantiaTutorEmpresarialService.changeSeccion(id,seccionesEvaluacionPasantiaTutorEmpresarial);
    }

    @PutMapping("/put/{id}/status/{status}")
    public SeccionesEvaluacionPasantiaTutorEmpresarial changeSeccion(@PathVariable Integer id, @PathVariable Boolean status){
        return seccionesEvaluacionPasantiaTutorEmpresarialService.changeStatus(id,status);
    }




    @GetMapping("/get/by/school/{schoolName}")
    public List<SeccionesEvaluacionPasantiaTutorEmpresarial> getAllSeccionesBySchool(@PathVariable String schoolName){
        return seccionesEvaluacionPasantiaTutorEmpresarialService.getAllSeccionesBySchool(schoolName);
    }
    @PostMapping("/post")
    public SeccionesEvaluacionPasantiaTutorEmpresarial createSeccion(@RequestBody SeccionesEvaluacionPasantiaTutorEmpresarial seccionData){
        return seccionesEvaluacionPasantiaTutorEmpresarialService.createSeccion(seccionData);
    }


}
