package com.example.PPSIntershipRESTapi.services;

import com.example.PPSIntershipRESTapi.entity.SeccionesEvaluacionPasantiaTutorEmpresarial;
import com.example.PPSIntershipRESTapi.repository.SeccionesEvaluacionPasantiaTutorEmpresarialRepository;
import org.springframework.stereotype.Service;

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
}
