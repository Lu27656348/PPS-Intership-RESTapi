package com.example.PPSIntershipRESTapi.services;

import com.example.PPSIntershipRESTapi.entity.SeccionesEvaluacionPasantiaTutorAcademico;
import com.example.PPSIntershipRESTapi.entity.SeccionesEvaluacionPasantiaTutorEmpresarial;
import com.example.PPSIntershipRESTapi.repository.SeccionesEvaluacionPasantiaTutorAcademicoRepository;
import com.example.PPSIntershipRESTapi.repository.SeccionesEvaluacionPasantiaTutorEmpresarialRepository;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@Service
public class SeccionesEvaluacionPasantiaTutorAcademicoService {
    private final SeccionesEvaluacionPasantiaTutorAcademicoRepository seccionesEvaluacionPasantiaTutorAcademicoRepository;

    public SeccionesEvaluacionPasantiaTutorAcademicoService(SeccionesEvaluacionPasantiaTutorAcademicoRepository seccionesEvaluacionPasantiaTutorAcademicoRepository) {
        this.seccionesEvaluacionPasantiaTutorAcademicoRepository = seccionesEvaluacionPasantiaTutorAcademicoRepository;
    }

    public SeccionesEvaluacionPasantiaTutorAcademico createSeccion(SeccionesEvaluacionPasantiaTutorAcademico seccionData){
        return seccionesEvaluacionPasantiaTutorAcademicoRepository.save(seccionData);
    }


    public List<SeccionesEvaluacionPasantiaTutorAcademico> getAllSecciones(){
        return (List<SeccionesEvaluacionPasantiaTutorAcademico>) seccionesEvaluacionPasantiaTutorAcademicoRepository.findAll();
    }

    public List<SeccionesEvaluacionPasantiaTutorAcademico> getAllSeccionesBySchool(String schoolName){
        return  seccionesEvaluacionPasantiaTutorAcademicoRepository.getAllSeccionesBySchool(schoolName);
    }


    public SeccionesEvaluacionPasantiaTutorAcademico getSeccionbyId(Integer id){
        return seccionesEvaluacionPasantiaTutorAcademicoRepository.findById(id).orElse(null);
    }


    public SeccionesEvaluacionPasantiaTutorAcademico changeSeccion (Integer id, SeccionesEvaluacionPasantiaTutorAcademico seccionesEvaluacionPasantiaTutorAcademico){
        SeccionesEvaluacionPasantiaTutorAcademico seccionSearch = seccionesEvaluacionPasantiaTutorAcademicoRepository.findById(id).orElse(null);
        if(seccionSearch != null){
            seccionSearch.setSeccionName(seccionesEvaluacionPasantiaTutorAcademico.getSeccionName());
            seccionSearch.setMaxNote(seccionesEvaluacionPasantiaTutorAcademico.getMaxNote());
            return seccionesEvaluacionPasantiaTutorAcademicoRepository.save(seccionSearch);
        }
        return null;
    }

    public SeccionesEvaluacionPasantiaTutorAcademico changeStatus (Integer id, Boolean status){
        SeccionesEvaluacionPasantiaTutorAcademico seccionSearch = seccionesEvaluacionPasantiaTutorAcademicoRepository.findById(id).orElse(null);
        if(seccionSearch != null){
            seccionSearch.setStatus(status);
            return seccionesEvaluacionPasantiaTutorAcademicoRepository.save(seccionSearch);
        }
        return null;
    }

}
