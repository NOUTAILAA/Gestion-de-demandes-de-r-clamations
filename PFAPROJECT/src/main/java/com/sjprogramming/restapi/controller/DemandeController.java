package com.sjprogramming.restapi.controller;

import java.util.List;

import com.sjprogramming.restapi.repository.DemandeRepository;
import com.sjprogramming.restapi.entity.Demande;
import com.sjprogramming.restapi.ResourceNotFoundException.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/demandes") // Base URL for all demandes endpoints
@CrossOrigin(origins = "*")
public class DemandeController {

    @Autowired
    private DemandeRepository demandeRepository;

    // Get all demandes
    @GetMapping
    public List<Demande> getAllDemandes() {
        return demandeRepository.findAll();
    }

    // Get a single demande
    @GetMapping("/{id}")
    public Demande getDemandeById(@PathVariable int id) {
        return demandeRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Demande not found with id: " + id));
    }

    // Create a new demande
    @PostMapping("/add")
    @ResponseStatus(HttpStatus.CREATED)
    public Demande createDemande(@RequestBody Demande demande) {
        return demandeRepository.save(demande);
    }

    // Update a demande
    @PutMapping("/update/{id}")
    public ResponseEntity<Demande> updateDemande(@PathVariable int id, @RequestBody Demande demandeDetails) {
        Demande demande = demandeRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Demande not found with id: " + id));

        demande.setSujet(demandeDetails.getSujet());
        demande.setDescription(demandeDetails.getDescription());
        demande.setDateReclamation(demandeDetails.getDateReclamation());
        demande.setEtat(demandeDetails.getEtat());
        // Notice we're not updating user here. If needed, add user update logic.
        
        final Demande updatedDemande = demandeRepository.save(demande);
        return ResponseEntity.ok(updatedDemande);
    }

    // Delete a demande
    @DeleteMapping("/delete/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteDemande(@PathVariable int id) {
        Demande demande = demandeRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Demande not found with id: " + id));
        demandeRepository.delete(demande);
    }
}
