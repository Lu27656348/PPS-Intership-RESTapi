package com.example.PPSIntershipRESTapi.services;

import com.example.PPSIntershipRESTapi.entity.CriteriosPasantiaTutorEmpresarial;
import com.example.PPSIntershipRESTapi.repository.CriteriosPasantiaTutorEmpresarialRepository;
import com.example.PPSIntershipRESTapi.responses.MessageResponse;
import org.apache.coyote.Response;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class CriteriosPasantiaTutorEmpresarialService {
    private final CriteriosPasantiaTutorEmpresarialRepository criteriosPasantiaTutorEmpresarialRepository;

    public CriteriosPasantiaTutorEmpresarialService(CriteriosPasantiaTutorEmpresarialRepository criteriosPasantiaTutorEmpresarialRepository) {
        this.criteriosPasantiaTutorEmpresarialRepository = criteriosPasantiaTutorEmpresarialRepository;
    }
    /*
    public CriteriosPasantiaTutorEmpresarial createCriteriosPasantiaTutorEmpresarial(){

    }
    */
    /*
    public CriteriosPasantiaTutorEmpresarial CriteriosPasantiaTutorEmpresarialpdateCriteriosPasantiaTutorEmpresarial(){

    }
    */
    public ResponseEntity<MessageResponse> deleteCriteriosPasantiaTutorEmpresarialbyId(Integer id){
        criteriosPasantiaTutorEmpresarialRepository.deleteById(id);
        return ResponseEntity.ok(new MessageResponse("El criterio ha sido eliminado exitosamente"));
    }

    public List<CriteriosPasantiaTutorEmpresarial> getAllCriteriosPasantiaTutorEmpresarial(){
        return (List<CriteriosPasantiaTutorEmpresarial>) criteriosPasantiaTutorEmpresarialRepository.findAll();
    }

    /*
        public CriteriosPasantiaTutorEmpresarial getCriteriosPasantiaTutorEmpresarialById(){

        }

*/
}
