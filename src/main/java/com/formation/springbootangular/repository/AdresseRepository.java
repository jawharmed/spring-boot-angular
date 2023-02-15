package com.formation.springbootangular.repository;

import com.formation.springbootangular.entity.Adresse;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AdresseRepository extends JpaRepository<Adresse, Integer> {

    Adresse findAdresseByNumeroAndRueAndCodePostalAndVille(int numero, String rue, String codePostal, String ville);
}
