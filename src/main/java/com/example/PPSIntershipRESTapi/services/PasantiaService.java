package com.example.PPSIntershipRESTapi.services;

import com.example.PPSIntershipRESTapi.entity.CriteriosPasantiaTutorAcademico;
import com.example.PPSIntershipRESTapi.entity.CriteriosPasantiaTutorEmpresarial;
import com.example.PPSIntershipRESTapi.entity.Pasantia;
import com.example.PPSIntershipRESTapi.interfaces.CriteriosPasantiaTutorAcademicoProjection;
import com.example.PPSIntershipRESTapi.repository.PasantiaRepository;
import com.example.PPSIntershipRESTapi.request.CreateEvaluationCriteria;
import com.example.PPSIntershipRESTapi.request.CreatePasantiaRequest;
import org.springframework.data.repository.query.Param;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

@Service
public class PasantiaService {

    private final PasantiaRepository pasantiaRepository;

    public PasantiaService(PasantiaRepository pasantiaRepository) {
        this.pasantiaRepository = pasantiaRepository;
    }

    public List<Pasantia> getPasantiasByStatus(Integer statuscode){
        return pasantiaRepository.getPasantiasByStatusCode(statuscode);
    }

    public Boolean createPasantia(CreatePasantiaRequest createPasantiaRequest){
        return pasantiaRepository.createPasantia(
                createPasantiaRequest.getIntershipTitle(),
                createPasantiaRequest.getEnterpriseId(),
                createPasantiaRequest.getIntershipStartDate(),
                createPasantiaRequest.getStudentDNI(),
                createPasantiaRequest.getCorporateTutorDNI(),
                createPasantiaRequest.getIntershipCompletionDate()
        );
    }

    public Boolean changeStatus(CreatePasantiaRequest createPasantiaRequest){
        return pasantiaRepository.changeStatus(createPasantiaRequest.getIntershipId(),createPasantiaRequest.getIntershipStatusCode());
    }

    public Boolean evaluateIntershipProposal (Integer intershipId, Integer intershipStatusCode, String schoolCouncilId, String schoolCouncilDecision, String academicTutorDNI){
        return pasantiaRepository.evaluateIntershipProposal(intershipId,intershipStatusCode,schoolCouncilId,schoolCouncilDecision,academicTutorDNI);
    }

    public Boolean evaluateIntershipReport(Integer intershipId, Integer academicTutorEvaluation, Integer corporateTutorEvaluation){
        return pasantiaRepository.evaluateIntershipReport(intershipId,academicTutorEvaluation,corporateTutorEvaluation);
    }

    public Pasantia getPasantiaById(Integer intershipId){
        return pasantiaRepository.getPasantiaById(intershipId);
    }

    public Pasantia getStudentCurrentPasantia(String studentDNI){
        return pasantiaRepository.getStudentCurrentPasantia(studentDNI);
    }

    public List<Pasantia> getPasantiasByStatusCodeAndSchool(Integer id, String schoolName){
        return pasantiaRepository.getPasantiasByStatusCodeAndSchool(id,schoolName);
    }

    public List<String> getStudentForProposalPending(String schoolName){
        return pasantiaRepository.getStudentForProposalPending(schoolName);
    }

    public String asociarCriterioConEvaluacionDeTutorAcademico(CreateEvaluationCriteria createEvaluationCriteria){
        pasantiaRepository.asociarCriterioConEvaluacionDeTutorAcademico(
                createEvaluationCriteria.getUserDNI(),
                createEvaluationCriteria.getIntershipId(),
                createEvaluationCriteria.getCriteriaId(),
                createEvaluationCriteria.getMaxNote()
        );
        return "Criterio asociado exitosamente";
    }

    public String asociarCriterioConEvaluacionDeTutorEmpresarial(CreateEvaluationCriteria createEvaluationCriteria){
        pasantiaRepository.asociarCriterioConEvaluacionDeTutorEmpresarial(
                createEvaluationCriteria.getUserDNI(),
                createEvaluationCriteria.getIntershipId(),
                createEvaluationCriteria.getCriteriaId(),
                createEvaluationCriteria.getMaxNote()
        );
        return "Criterio asociado exitosamente";
    }



    public List<CriteriosPasantiaTutorAcademicoProjection> obtenerCriterioEvaluacionTutorAcademico(CreateEvaluationCriteria createEvaluationCriteria){
        return pasantiaRepository.obtenerCriterioEvaluacionTutorAcademico(
                createEvaluationCriteria.getUserDNI(),
                createEvaluationCriteria.getIntershipId()
        );
    }

    public List<CriteriosPasantiaTutorAcademicoProjection> obtenerCriterioEvaluacionTutorEmpresarial(CreateEvaluationCriteria createEvaluationCriteria){
        return pasantiaRepository.obtenerCriterioEvaluacionTutorEmpresarial(
                createEvaluationCriteria.getUserDNI(),
                createEvaluationCriteria.getIntershipId()
        );
    }


    public ResponseEntity<Boolean> calificarCriterioEvaluacionTutorAcademico(@RequestBody CreateEvaluationCriteria createEvaluationCriteria){
        return ResponseEntity.ok(
                pasantiaRepository.calificarCriterioEvaluacionTutorAcademico(
                    createEvaluationCriteria.getUserDNI(),
                    createEvaluationCriteria.getIntershipId(),
                    createEvaluationCriteria.getCriteriaId(),
                    createEvaluationCriteria.getCriteriaNote()
                )
        );
    }

    public ResponseEntity<Boolean> calificarCriterioEvaluacionTutorEmpresarial(@RequestBody CreateEvaluationCriteria createEvaluationCriteria){
        return ResponseEntity.ok(
                pasantiaRepository.calificarCriterioEvaluacionTutorEmpresarial(
                    createEvaluationCriteria.getUserDNI(),
                    createEvaluationCriteria.getIntershipId(),
                    createEvaluationCriteria.getCriteriaId(),
                    createEvaluationCriteria.getCriteriaNote()
                )
        );
    }
}
