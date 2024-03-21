package com.example.PPSIntershipRESTapi.services;

import com.example.PPSIntershipRESTapi.entity.SeccionesEvaluacionPasantiaTutorAcademico;
import com.example.PPSIntershipRESTapi.entity.SeccionesEvaluacionPasantiaTutorEmpresarial;
import com.example.PPSIntershipRESTapi.repository.SeccionesEvaluacionPasantiaTutorEmpresarialRepository;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@Service
public class SeccionesEvaluacionPasantiaTutorEmpresarialService {
    private final SeccionesEvaluacionPasantiaTutorEmpresarialRepository seccionesEvaluacionPasantiaTutorEmpresarialRepository;

    public SeccionesEvaluacionPasantiaTutorEmpresarialService(SeccionesEvaluacionPasantiaTutorEmpresarialRepository seccionesEvaluacionPasantiaTutorEmpresarialRepository) {
        this.seccionesEvaluacionPasantiaTutorEmpresarialRepository = seccionesEvaluacionPasantiaTutorEmpresarialRepository;
    }

    public List<SeccionesEvaluacionPasantiaTutorEmpresarial> getAllSecciones(){
        return (List<SeccionesEvaluacionPasantiaTutorEmpresarial>) seccionesEvaluacionPasantiaTutorEmpresarialRepository.findAll();
    }

    public SeccionesEvaluacionPasantiaTutorEmpresarial changeSeccion (Integer id, SeccionesEvaluacionPasantiaTutorEmpresarial seccionesEvaluacionPasantiaTutorEmpresarial){
        SeccionesEvaluacionPasantiaTutorEmpresarial seccionSearch = seccionesEvaluacionPasantiaTutorEmpresarialRepository.findById(id).orElse(null);
        if(seccionSearch != null){
            seccionSearch.setSeccionName(seccionesEvaluacionPasantiaTutorEmpresarial.getSeccionName());
            seccionSearch.setMaxNote(seccionesEvaluacionPasantiaTutorEmpresarial.getMaxNote());
            return seccionesEvaluacionPasantiaTutorEmpresarialRepository.save(seccionesEvaluacionPasantiaTutorEmpresarial);
        }
        return null;
    }

    public SeccionesEvaluacionPasantiaTutorEmpresarial changeStatus (Integer id, Boolean status){
        SeccionesEvaluacionPasantiaTutorEmpresarial seccionSearch = seccionesEvaluacionPasantiaTutorEmpresarialRepository.findById(id).orElse(null);
        if(seccionSearch != null){
            seccionSearch.setStatus(status);
            return seccionesEvaluacionPasantiaTutorEmpresarialRepository.save(seccionSearch);
        }
        return null;
    }

    public SeccionesEvaluacionPasantiaTutorEmpresarial createSeccion(SeccionesEvaluacionPasantiaTutorEmpresarial seccionData){
        return seccionesEvaluacionPasantiaTutorEmpresarialRepository.save(seccionData);
    }
    public List<SeccionesEvaluacionPasantiaTutorEmpresarial> getAllSeccionesBySchool(String schoolName){
        return  seccionesEvaluacionPasantiaTutorEmpresarialRepository.getAllSeccionesBySchool(schoolName);
    }

    public SeccionesEvaluacionPasantiaTutorEmpresarial getSeccionById( Integer id ){
        return seccionesEvaluacionPasantiaTutorEmpresarialRepository.findById(id).orElse(null);
    }

}
