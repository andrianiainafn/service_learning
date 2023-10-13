package org.sid.compteservice.web;

import org.sid.compteservice.dtos.VirementRequestDTO;
import org.sid.compteservice.service.CompteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AccountRestController {
    @Autowired
    CompteService compteService;

    @PutMapping(path = "comptes/virement")
    private void virement(@RequestBody VirementRequestDTO requestDTO){
        compteService.virement(requestDTO.getCodeSource(), requestDTO.getCodeDestination(), requestDTO.getMontant());
    }
}
