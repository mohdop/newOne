package com.ism.exam.api.Controller;

import com.ism.exam.api.dto.*;
import com.ism.exam.entities.*;
import com.ism.exam.entities.Module;
import com.ism.exam.repositories.*;

import java.time.LocalDate;
import java.util.*;
import java.util.stream.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/rp")
@CrossOrigin(origins ="http://127.0.0.1:4200")
public class ResponsablePedagogiqueController {

    @Autowired
    private ModuleRepository moduleRepository;
    @Autowired
    private SalleDeCoursRepository salleDeCoursRepository;
    @Autowired
    private EtudiantRepository etudiantRepository;
    @Autowired
    private CoursRepository coursRepository;

    @PostMapping("/modules")
    public ResponseEntity<Module> createModule(@RequestBody Module module) {
        Module savedModule = moduleRepository.save(module);
        return new ResponseEntity<>(savedModule, HttpStatus.CREATED);
    }
    

    @PostMapping("/salles")
    public ResponseEntity<SalleDeCours> createSalleDeCours(@RequestBody SalleDeCours salleDeCours) {
        SalleDeCours newSalleDeCours = salleDeCoursRepository.save(salleDeCours);
        return new ResponseEntity<>(newSalleDeCours, HttpStatus.CREATED);
    }

    @PostMapping("/etudiants")
    public ResponseEntity<Etudiant> inscrireEtudiant(@RequestBody Etudiant etudiant) {
        Etudiant nouvelEtudiant = etudiantRepository.save(etudiant);
        return new ResponseEntity<>(nouvelEtudiant, HttpStatus.CREATED);
    }
    @PostMapping("/cours")
    public ResponseEntity<Cours> planifierCours(@RequestBody Cours cours) {
        Cours newcours = coursRepository.save(cours);
        return new ResponseEntity<>(newcours, HttpStatus.CREATED);
    }

    @GetMapping("/cours/{id}/etudiants")
    public ResponseEntity<List<Etudiant>> getEtudiantsByCours(@PathVariable("id") Long coursId) {
        Optional<Cours> cours = coursRepository.findById(coursId);
        if (cours.isPresent()) {
            List<Etudiant> etudiants = etudiantRepository.findByCours(cours.get());
            return new ResponseEntity<>(etudiants, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

}
