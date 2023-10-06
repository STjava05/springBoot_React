package com.student.utile.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;


@Entity
public class utilisateur {

    @Id
    @GeneratedValue(strategy =GenerationType.IDENTITY)
    private Long id;
    private String nom ;
    private String prenom ;
    private String email ;


    public utilisateur() {
    }


    public utilisateur( String nom, String prenom, String email) {
        
        this.nom = nom;
        this.prenom = prenom;
        this.email = email;
    }


    public Long getId () {
        return id ;
    }
    public void setId (Long id ) {
        this.id  = id ;
    }


    public String getNom () {
        return nom ;
    }
    public void setNom (String nom ) {
        this.nom  = nom ;
    }
    public String getPrenom () {
        return prenom ;
    }
    public void setPrenom (String prenom ) {
        this.prenom  = prenom ;
    }
    public String getEmail () {
        return email ;
    }
    public void setEmail (String email ) {
        this.email  = email ;
    }

    
}
