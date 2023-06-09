package com.ism.exam.controllers;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import com.ism.exam.entities.*;
import com.ism.exam.services.AttacheService;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;


@Controller
public class AttacheController {

    @Autowired
    private AttacheService attacheService;

    @GetMapping("/")
    public String Home() {
        return "connexion";
    }

    @GetMapping("/professeurs")
    public String listProfesseursByMail(@RequestParam(defaultValue = "") String mail, Model model) {
        List<Professeur> professeurs;
        if (mail.equals("")) {
            professeurs = attacheService.findProf();
        } else {
            professeurs = attacheService.findProfesseursByMailContaining(mail);
        }
        model.addAttribute("profs", professeurs);
        return "list";
    }
    

    @GetMapping("/professeurs/{id}/sessions")
    public String listSessionsByProfesseur(@PathVariable Long id, Model model) {
        List<Session> sessions = attacheService.findSessionsByProfesseurId(id);
        Professeur professeur = attacheService.findProfesseurById(id);
        professeur.setNomComplet(professeur.getNomComplet());
        model.addAttribute("professeur", professeur);
        model.addAttribute("sessions", sessions);
        return "sessions";
    }
    
    @GetMapping("/{sessionId}/etudiants")
    public String getEtudiantsPresent(@PathVariable Long sessionId, Model model) {
        Session session = attacheService.findById(sessionId);
        List<Etudiant> etudiantsPresent = attacheService.getEtudiantsPresent(session);
        Presence presence = attacheService.findPres(session);
        model.addAttribute("etudiantsPresent", etudiantsPresent);
        model.addAttribute("sessionn",session);
        model.addAttribute("presence", presence);
        return "ListePresence";
    }

    @GetMapping("/sessions/update{id}")
        public String updateSessionEtat( Long id,  String etat,Model model) {
        Session session = attacheService.findById(id);
        Professeur professeur = attacheService.findProfesseurById(session.getProfesseur().getId());
        List<Session> sessions = attacheService.findSessionsByProfesseurId(professeur.getId());
        professeur.setNomComplet(professeur.getNomComplet());
        model.addAttribute("professeur", professeur);
        model.addAttribute("sessions", sessions);
        session.setEtat(etat);
        attacheService.save(session);
        return "sessions";
    }

    @GetMapping("/{sessionId}/etudiants/valider/{id}")
    public String validerPresenceEtat(@PathVariable Long sessionId, @PathVariable Long id, Model model) {
        Session session = attacheService.findById(sessionId);
        Presence presence = attacheService.findPre(session.getPresence().getId());
        List<Etudiant> etudiantsPresent = attacheService.getEtudiantsPresent(session);
        model.addAttribute("etudiantsPresent", etudiantsPresent);
        model.addAttribute("presence", presence);
        model.addAttribute("sessionn", session);
        presence.setEtat("present");
        attacheService.savePresence(presence);
        attacheService.save(session);
        return "ListePresence";
    }
    
    @GetMapping("/{sessionId}/etudiants/invalider/{id}")
    public String invaliderPresenceEtat(@PathVariable Long sessionId, @PathVariable Long id, Model model) {
        Session session = attacheService.findById(sessionId);
        Presence presence = attacheService.findPre(session.getPresence().getId());
        List<Etudiant> etudiantsPresent = attacheService.getEtudiantsPresent(session);
        model.addAttribute("etudiantsPresent", etudiantsPresent);
        model.addAttribute("presence", presence);
        model.addAttribute("sessionn", session);
        presence.setEtat("absent");
        attacheService.savePresence(presence);
        attacheService.save(session);
        return "ListePresence";
    }
    
    @GetMapping("/justification/{etudiantId}/{sessionId}")
    public String getJustification(@PathVariable("etudiantId") Long etudiantId, @PathVariable("sessionId") Long sessionId, Model model) {
    Etudiant etudiant = attacheService.findEtudiant(etudiantId);
    Session session = attacheService.findById(sessionId);
    Justification justification = attacheService.findJustificationByEtudiantAndSession(etudiantId, sessionId);
    model.addAttribute("etudiant", etudiant);
    model.addAttribute("sessionn", session);
    model.addAttribute("justification", justification);
    return "justification";
}



    @GetMapping("/accepter/{justificationId}/{etudiantId}/{sessionId}")
    public String acceptJustification(@PathVariable Long justificationId,@PathVariable Long etudiantId,@PathVariable Long sessionId,Model model) {
        Etudiant etudiant = attacheService.findEtudiant(etudiantId);
        Session session = attacheService.findById(sessionId);
        attacheService.acceptJustification(justificationId);
        Justification justification = attacheService.findJustificationByEtudiantAndSession(etudiantId, sessionId);
        model.addAttribute("etudiant", etudiant);
        model.addAttribute("sessionn", session);
        model.addAttribute("justification", justification);
        return "justification"; 
    }

    @GetMapping("/refuser/{justificationId}/{etudiantId}/{sessionId}")
    public String refuseJustification(@PathVariable Long justificationId,@PathVariable Long etudiantId,@PathVariable Long sessionId,Model model) {
        Etudiant etudiant = attacheService.findEtudiant(etudiantId);
        Session session = attacheService.findById(sessionId);
        attacheService.refuseJustification(justificationId);
        Justification justification = attacheService.findJustificationByEtudiantAndSession(etudiantId, sessionId);
        model.addAttribute("etudiant", etudiant);
        model.addAttribute("sessionn", session);
        model.addAttribute("justification", justification);
        return "Justification"; 
    }

    @PostMapping("/login")
    public String login(@RequestParam("adresseEmail") String adresseEmail, @RequestParam("motDePasse") String motDePasse,@RequestParam(defaultValue = "") String mail,Model model) {
        //Users user = attacheService.login(adresseEmail, motDePasse);
        Attache attache = attacheService.loggin(adresseEmail, motDePasse);
        String error = "";
        
        if (attache != null   ) {
            List<Professeur> professeurs;
            if (mail.equals("")) {
                professeurs = attacheService.findProf();
            } else {
                professeurs = attacheService.findProfesseursByMailContaining(mail);
            }
            model.addAttribute("profs", professeurs);
            return "list";
        } else {
            error="Vérifiez le mail ou le mot de passe";
            model.addAttribute("err", error);
            return "connexion";
        }
        /*&& user.getRoles().equals("ATTACHE") */
    }
   
}