package com.example.PPSIntershipRESTapi.services;

import com.example.PPSIntershipRESTapi.entity.CriteriosPasantiaTutorAcademico;
import com.example.PPSIntershipRESTapi.entity.CriteriosPasantiaTutorEmpresarial;
import com.example.PPSIntershipRESTapi.entity.SeccionesEvaluacionPasantiaTutorAcademico;
import com.example.PPSIntershipRESTapi.repository.CriteriosPasantiaTutorAcademicoRepository;
import com.example.PPSIntershipRESTapi.repository.CriteriosPasantiaTutorEmpresarialRepository;
import com.example.PPSIntershipRESTapi.responses.MessageResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Service
public class CriteriosPasantiaTutorAcademicoService {

    private final CriteriosPasantiaTutorAcademicoRepository criteriosPasantiaTutorAcademicoRepository;

    public CriteriosPasantiaTutorAcademicoService(CriteriosPasantiaTutorAcademicoRepository criteriosPasantiaTutorAcademicoRepository) {
        this.criteriosPasantiaTutorAcademicoRepository = criteriosPasantiaTutorAcademicoRepository;
    }


    public ResponseEntity<MessageResponse> deleteCriteriosPasantiaTutorAcademicobyId(Integer id){
        criteriosPasantiaTutorAcademicoRepository.deleteById(id);
        return ResponseEntity.ok(new MessageResponse("El criterio ha sido eliminado exitosamente"));
    }

    public List<CriteriosPasantiaTutorAcademico> getAllCriteriosPasantiaTutorAcademico(){
        return (List<CriteriosPasantiaTutorAcademico>) criteriosPasantiaTutorAcademicoRepository.findAll();
    }

    public List<CriteriosPasantiaTutorAcademico> getAllCriteriosPasantiaTutorAcademicoBySchool(String schoolName){
        return criteriosPasantiaTutorAcademicoRepository.getAllCriteriosPasantiaTutorAcademicoBySchool(schoolName);
    }

    public List<CriteriosPasantiaTutorAcademico> getCriteriosPasantiaTutorAcademicoBySeccion(Integer id){
        return criteriosPasantiaTutorAcademicoRepository.getCriteriosPasantiaTutorAcademicoBySeccion(id);
    }

    public CriteriosPasantiaTutorAcademico changeCriteria(Integer criteriaId, CriteriosPasantiaTutorAcademico criteriosPasantiaTutorAcademico){
        CriteriosPasantiaTutorAcademico criteriaSearch = criteriosPasantiaTutorAcademicoRepository.findById(criteriaId).orElse(null);
        if(criteriaSearch != null){
            criteriaSearch.setCriteriaName(criteriosPasantiaTutorAcademico.getCriteriaName());
            criteriaSearch.setMaxNote(criteriosPasantiaTutorAcademico.getMaxNote());
            return criteriosPasantiaTutorAcademicoRepository.save(criteriaSearch);
        }
        return null;
    }

    public CriteriosPasantiaTutorAcademico createCriteria(CriteriosPasantiaTutorAcademico criteriaData){
        return criteriosPasantiaTutorAcademicoRepository.save(criteriaData);
    }

}
