package com.example.PPSIntershipRESTapi.controllers;

import com.example.PPSIntershipRESTapi.entity.CriteriosPasantiaTutorAcademico;
import com.example.PPSIntershipRESTapi.entity.CriteriosPasantiaTutorEmpresarial;
import com.example.PPSIntershipRESTapi.entity.Pasantia;
import com.example.PPSIntershipRESTapi.interfaces.CriteriosPasantiaTutorAcademicoProjection;
import com.example.PPSIntershipRESTapi.request.CreateEvaluationCriteria;
import com.example.PPSIntershipRESTapi.request.CreatePasantiaRequest;
import com.example.PPSIntershipRESTapi.request.EvaluateIntershipReportRequest;
import com.example.PPSIntershipRESTapi.responses.MessageResponse;
import com.example.PPSIntershipRESTapi.services.PasantiaService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.function.EntityResponse;

import java.util.List;

@RestController
@RequestMapping("/pasantia")
public class PasantiaController {

    private final PasantiaService pasantiaService;

    public PasantiaController(PasantiaService pasantiaService) {
        this.pasantiaService = pasantiaService;
    }

    @GetMapping("/status/{id}")
    public List<Pasantia> getPasantiaByStatus(@PathVariable Integer id){
        return pasantiaService.getPasantiasByStatus(id);
    }

    @PostMapping("/create")
    public Boolean createPasantia(@RequestBody CreatePasantiaRequest createPasantiaRequest){
        return pasantiaService.createPasantia(createPasantiaRequest);
    }

    @PostMapping("/change/status")
    public Boolean changeStatus(@RequestBody CreatePasantiaRequest createPasantiaRequest){
        return pasantiaService.changeStatus(createPasantiaRequest);
    }

    @PostMapping("/evaluate/proposal")
    public Boolean evaluateIntershipProposal(@RequestBody CreatePasantiaRequest createPasantiaRequest){
        System.out.println(createPasantiaRequest);
        return pasantiaService.evaluateIntershipProposal(
                createPasantiaRequest.getIntershipId(),
                createPasantiaRequest.getIntershipStatusCode(),
                createPasantiaRequest.getSchoolCouncilId(),
                createPasantiaRequest.getSchoolCouncilDecision(),
                createPasantiaRequest.getCorporateTutorDNI()
        );
    }

    @PostMapping("/evaluate/report")
    public Boolean evaluateIntershipReport(@RequestBody EvaluateIntershipReportRequest evaluateIntershipReportRequest){
        return pasantiaService.evaluateIntershipReport(
                evaluateIntershipReportRequest.getIntershipId(),
                evaluateIntershipReportRequest.getEvaluacionTutorAcademico(),
                evaluateIntershipReportRequest.getEvaluacionTutorEmpresarial()
        );
    }

    @GetMapping("/get/{id}")
    public Pasantia getPasantiaById(@PathVariable Integer id){
        return pasantiaService.getPasantiaById(id);
    }

    @GetMapping("/get/by/student/{id}")
    public Pasantia getStudentCurrentPasantia(@PathVariable String id){
        return pasantiaService.getStudentCurrentPasantia(id);
    }


    @GetMapping("/status/{id}/school/{schoolname}")
    public List<Pasantia> getPasantiasByStatusCodeAndSchool(@PathVariable Integer id,@PathVariable String schoolname){
        System.out.println(schoolname);
        return pasantiaService.getPasantiasByStatusCodeAndSchool(id,schoolname);
    }
    @GetMapping("/proposal/pending/{schoolName}")
    public List<String> getStudentForProposalPending(@PathVariable String schoolName){
        return pasantiaService.getStudentForProposalPending(schoolName);
    }

    /* Generar Evaluacion de Tutores */
    @PostMapping("/generar/evaluacion/tutor/academico")
    public ResponseEntity<MessageResponse> asociarCriterioConEvaluacionDeTutorAcademico(@RequestBody CreateEvaluationCriteria createEvaluationCriteria){
        pasantiaService.asociarCriterioConEvaluacionDeTutorAcademico(createEvaluationCriteria);
        return ResponseEntity.ok(new MessageResponse("Criterio asociado exitosamente"));
    }

    @PostMapping("/generar/evaluacion/tutor/empresarial")
    public ResponseEntity<MessageResponse> asociarCriterioConEvaluacionDeTutorEmpresarial(@RequestBody CreateEvaluationCriteria createEvaluationCriteria){
        pasantiaService.asociarCriterioConEvaluacionDeTutorEmpresarial(createEvaluationCriteria);
        return ResponseEntity.ok(new MessageResponse("Criterio asociado exitosamente"));
    }



    @PostMapping("/obtener/evaluacion/tutor/academico")
    public ResponseEntity<List<CriteriosPasantiaTutorAcademicoProjection>> obtenerCriterioEvaluacionTutorAcademico(@RequestBody CreateEvaluationCriteria createEvaluationCriteria){
        return ResponseEntity.ok(pasantiaService.obtenerCriterioEvaluacionTutorAcademico(createEvaluationCriteria));
    }

    @PostMapping("/obtener/evaluacion/tutor/empresarial")
    public ResponseEntity<List<CriteriosPasantiaTutorAcademicoProjection>> obtenerCriterioEvaluacionTutorEmpresarial(@RequestBody CreateEvaluationCriteria createEvaluationCriteria){
        return ResponseEntity.ok(pasantiaService.obtenerCriterioEvaluacionTutorEmpresarial(createEvaluationCriteria));
    }


    @PostMapping("/calificar/evaluacion/tutor/academico")
    public ResponseEntity<Boolean> calificarCriterioEvaluacionTutorAcademico(@RequestBody CreateEvaluationCriteria createEvaluationCriteria){
        return pasantiaService.calificarCriterioEvaluacionTutorAcademico(createEvaluationCriteria);
    }

    @PostMapping("/calificar/evaluacion/tutor/empresarial")
    public ResponseEntity<Boolean> calificarCriterioEvaluacionTutorEmpresarial(@RequestBody CreateEvaluationCriteria createEvaluationCriteria){
        return pasantiaService.calificarCriterioEvaluacionTutorEmpresarial(createEvaluationCriteria);
    }


}
