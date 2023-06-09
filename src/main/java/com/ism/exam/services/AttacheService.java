package com.ism.exam.services;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.*;

import com.ism.exam.entities.Cours;
import com.ism.exam.entities.*;
import com.ism.exam.repositories.*;

@Service
public class AttacheService {
    @Autowired
    private AttacheRepository attacheRepository;
    @Autowired
    private CoursRepository coursRepository;
    @Autowired
    private ProfesseurRepository professeurRepository;
    @Autowired
    private SessionRepository sessionRepository;
    @Autowired
    private PresenceRepository presenceRepository;
    @Autowired
    private JustificationRepository justificationRepository;
    @Autowired
    private EtudiantRepository etudiantRepository;
    @Autowired
    private UserRepository userRepository;

    public Presence validerPresence(Etudiant etudiant, Session session) {
        Presence presence = new Presence();
        presence.setEtudiant(etudiant);
        presence.setSession(session);
        presence.setEtat("présent");
        return presenceRepository.save(presence);
    }
 
    public List<Session> findSessionsByProfesseurId(Long professeurId) {
        return sessionRepository.findByProfesseurId(professeurId);
    }
  
    public List<Users> findByRole(String roles) {
        return attacheRepository.findByRoles(roles);
    }
    public List<Professeur> findProfesseursByMailContaining(String mail) {
        return professeurRepository.findByAdresseEmailContaining(mail);
    }
    
    public Session findById(Long id){
        return sessionRepository.findOneById(id);
    }

    public Session save(Session session){
        return sessionRepository.save(session);
    }
    
    public Presence savePresence(Presence presence){
        return presenceRepository.save(presence);
    }
    public List<Cours> findCours() {
        return coursRepository.findAll();
    }
    public List<Professeur> findProf() {
        return professeurRepository.findAll();
    }
    public Professeur findProfesseurById(Long id){
        return professeurRepository.findOneById(id);
    }
    public Presence findByEtudiant(Etudiant etudiant) {
        return presenceRepository.findByEtudiant(etudiant);
    }

    public List<Session> findSessionsByProfesseurIdAndDateBetween(Long professeurId, LocalDateTime debut, LocalDateTime fin) {
        return sessionRepository.findByProfesseurIdAndDateBetween(professeurId, debut, fin);
    }
    
    public List<Etudiant> getEtudiantsPresent(Session session) {
        List<Presence> presences = presenceRepository.findBySession(session);
        List<Etudiant> etudiantsPresent = new ArrayList<>();
        for (Presence presence : presences) {
            etudiantsPresent.add(presence.getEtudiant());
        }
        return etudiantsPresent;
    }
    public Presence findPres(Session session){
        return presenceRepository.findOneBySession(session);
    }
    

    public Presence findPre(Long id){
        return presenceRepository.findOneById(id);
    }

    public Justification findJustificationByEtudiantAndSession(Long etudiantId, Long sessionId) {
        return justificationRepository.findByEtudiantIdAndSessionId(etudiantId, sessionId);
    }
    
    public void acceptJustification(Long justificationId) {
        Justification justification = justificationRepository.findOneById(justificationId);
        if (justification != null) {
            justification.setEtat("accepté");
            justificationRepository.save(justification);
        }
    }

    public void refuseJustification(Long justificationId) {
        Justification justification = justificationRepository.findOneById(justificationId);
        if (justification != null) {
            justification.setEtat("refusé");
            justificationRepository.save(justification);
        }
    }
    
    public Etudiant findEtudiant(Long id){
        return etudiantRepository.findOneById(id);
    } 

    public Users login(String email, String password){
        return userRepository.findByadresseEmailAndMotDePasse(email, password);
    }

    public Attache loggin(String email, String password){
        return attacheRepository.findOneByAdresseEmailAndMotDePasse(email, password);
    }
    

    
}
