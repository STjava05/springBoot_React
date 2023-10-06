package com.student.utile.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;

import com.student.utile.exception.UserNotFoundException;

import com.student.utile.model.utilisateur;
import com.student.utile.repository.UtilisateurRepository;
import java.util.List;


@RestController
@CrossOrigin(origins = "http://localhost:3001")
public class utilisateurController {

    @Autowired
    private UtilisateurRepository utilisateurRepository;


    @PostMapping ("/eleve")
    utilisateur newUser(@RequestBody utilisateur newUser) {
        return utilisateurRepository.save(newUser);
    }

    @GetMapping ("/eleves")
    List<utilisateur> getAllUtilisateurs() {
        return utilisateurRepository.findAll();
    }

    @GetMapping ("/eleve/{id}")
    utilisateur getUtilisateurById(@PathVariable Long id) {
       
        return utilisateurRepository.findById(id)
                .orElseThrow(() -> new UserNotFoundException(id));
    }

    @PutMapping ("/eleve/{id}")
    utilisateur replaceUtilisateur(@RequestBody utilisateur newUtilisateur, @PathVariable Long id) {
        
        return utilisateurRepository.findById(id)
                .map(utilisateur -> {
                    utilisateur.setNom(newUtilisateur.getNom());
                    utilisateur.setPrenom(newUtilisateur.getPrenom());
                    utilisateur.setEmail(newUtilisateur.getEmail());
                   
                    return utilisateurRepository.save(utilisateur);
                })
                .orElseThrow(() -> {
                    return new UserNotFoundException(id);
                });
    }

    @DeleteMapping ("/eleve/{id}")  
    void deleteUtilisateur(@PathVariable Long id) {
        if (!utilisateurRepository.existsById(id)) {
            throw new UserNotFoundException(id);
        }
        utilisateurRepository.deleteById(id);
        

    }


   


    
}
