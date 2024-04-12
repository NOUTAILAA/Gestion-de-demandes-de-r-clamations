package com.sjprogramming.restapi.repository;

import com.sjprogramming.restapi.entity.Demande;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DemandeRepository extends JpaRepository<Demande, Integer> {
    // Ici, vous pouvez ajouter des méthodes de recherche personnalisées si nécessaire
}
