package com.student.utile.repository;
import com.student.utile.model.utilisateur;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UtilisateurRepository extends JpaRepository<utilisateur,Long>   {
    
}
