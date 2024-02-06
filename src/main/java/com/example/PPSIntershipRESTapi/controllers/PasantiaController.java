package com.example.PPSIntershipRESTapi.controllers;

import com.example.PPSIntershipRESTapi.entity.Pasantia;
import com.example.PPSIntershipRESTapi.request.CreatePasantiaRequest;
import com.example.PPSIntershipRESTapi.request.EvaluateIntershipReportRequest;
import com.example.PPSIntershipRESTapi.services.PasantiaService;
import org.springframework.web.bind.annotation.*;

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
}
