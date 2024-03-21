package com.example.PPSIntershipRESTapi.controllers;

import com.example.PPSIntershipRESTapi.entity.SeccionesEvaluacionPasantiaTutorAcademico;
import com.example.PPSIntershipRESTapi.entity.SeccionesEvaluacionPasantiaTutorEmpresarial;
import com.example.PPSIntershipRESTapi.services.SeccionesEvaluacionPasantiaTutorAcademicoService;
import com.example.PPSIntershipRESTapi.services.SeccionesEvaluacionPasantiaTutorEmpresarialService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/pasantia/secciones/academico")
public class SeccionesEvaluacionPasantiaTutorAcademicoController {

    private final SeccionesEvaluacionPasantiaTutorAcademicoService seccionesEvaluacionPasantiaTutorAcademicoService;


    public SeccionesEvaluacionPasantiaTutorAcademicoController(SeccionesEvaluacionPasantiaTutorAcademicoService seccionesEvaluacionPasantiaTutorAcademicoService) {
        this.seccionesEvaluacionPasantiaTutorAcademicoService = seccionesEvaluacionPasantiaTutorAcademicoService;
    }

    @GetMapping("/get")
    public List<SeccionesEvaluacionPasantiaTutorAcademico> getAllSecciones(){
        return seccionesEvaluacionPasantiaTutorAcademicoService.getAllSecciones();
    }

    @GetMapping("/get/by/school/{schoolName}")
    public List<SeccionesEvaluacionPasantiaTutorAcademico> getAllSeccionesBySchool(@PathVariable String schoolName){
        return seccionesEvaluacionPasantiaTutorAcademicoService.getAllSeccionesBySchool(schoolName);
    }



    @PutMapping("/put/{id}")
    public SeccionesEvaluacionPasantiaTutorAcademico changeSeccion(@PathVariable Integer id, @RequestBody SeccionesEvaluacionPasantiaTutorAcademico seccionesEvaluacionPasantiaTutorAcademico){
        return seccionesEvaluacionPasantiaTutorAcademicoService.changeSeccion(id,seccionesEvaluacionPasantiaTutorAcademico);
    }

    @PostMapping("/post")
    public SeccionesEvaluacionPasantiaTutorAcademico createSeccion(@RequestBody SeccionesEvaluacionPasantiaTutorAcademico seccionData){
        return seccionesEvaluacionPasantiaTutorAcademicoService.createSeccion(seccionData);
    }

    @GetMapping("/get/by/{id}")
    public SeccionesEvaluacionPasantiaTutorAcademico getSeccionById(@PathVariable Integer id){
        return seccionesEvaluacionPasantiaTutorAcademicoService.getSeccionbyId(id);
    }

    @PutMapping("/put/{id}/status/{status}")
    public SeccionesEvaluacionPasantiaTutorAcademico changeSeccion(@PathVariable Integer id, @PathVariable Boolean status){
        return seccionesEvaluacionPasantiaTutorAcademicoService.changeStatus(id,status);
    }

}
