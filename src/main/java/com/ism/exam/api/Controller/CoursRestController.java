package com.ism.exam.api.Controller;

import com.ism.exam.api.dto.*;
import com.ism.exam.entities.*;
import com.ism.exam.repositories.*;

import java.time.LocalDate;
import java.util.*;
import java.util.stream.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/cours")
@CrossOrigin(origins ="http://localhost:4200")
public class CoursRestController {

    @Autowired
    private CoursRepository coursRepository;

    @Autowired
    private SessionRepository sessionRepository;

    @GetMapping
    public ResponseEntity<List<CoursDto>> getAllCours() {
        List<CoursDto> coursList = coursRepository.findAll()
            .stream()
            .map(CoursDto::new)
            .collect(Collectors.toList());
        return new ResponseEntity<>(coursList, HttpStatus.OK);
    }

    @GetMapping("/professeur/{id}")
    public ResponseEntity<List<CoursDto>> getCoursByProfesseur(@PathVariable("id") Professeur professeur) {
        List<CoursDto> coursList = coursRepository.findByProfesseur(professeur)
            .stream()
            .map(CoursDto::new)
            .collect(Collectors.toList());
        return new ResponseEntity<>(coursList, HttpStatus.OK);
    }

    @GetMapping("/cours/{id}/sessions")
    public ResponseEntity<List<SessionDto>> getSessionsByCoursId(@PathVariable("id") Long id) {
        List<SessionDto> sessions = sessionRepository.findByCoursId(id)
            .stream()
            .map(SessionDto::new)
            .collect(Collectors.toList());
        return new ResponseEntity<>(sessions, HttpStatus.OK);
    }

    @GetMapping("/sessions-by-date")
    public ResponseEntity<List<SessionDto>> getSessionsByDate(@RequestParam("date") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate date) {
        List<SessionDto> sessions = sessionRepository.findByDate(date)
                .stream()
                .map(SessionDto::new)
                .collect(Collectors.toList());
        return new ResponseEntity<>(sessions, HttpStatus.OK);
    }

}
