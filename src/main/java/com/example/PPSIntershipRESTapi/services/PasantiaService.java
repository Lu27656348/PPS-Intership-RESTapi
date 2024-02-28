package com.example.PPSIntershipRESTapi.services;

import com.example.PPSIntershipRESTapi.entity.Pasantia;
import com.example.PPSIntershipRESTapi.repository.PasantiaRepository;
import com.example.PPSIntershipRESTapi.request.CreatePasantiaRequest;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Service;

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

    public List<String> getStudentForProposalPending(){
        return pasantiaRepository.getStudentForProposalPending();
    }
}
