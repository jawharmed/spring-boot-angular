package com.formation.springbootangular.service;

import com.formation.springbootangular.entity.Adresse;
import com.formation.springbootangular.repository.AdresseRepository;
import org.springframework.stereotype.Service;

@Service
public class AdresseService {

    private final AdresseRepository adresseRepository;

    public AdresseService(AdresseRepository adresseRepository) {
        this.adresseRepository = adresseRepository;
    }

    public Adresse create(Adresse adresse) throws Exception {
        Adresse tempAdresse = adresseRepository.findAdresseByNumeroAndRueAndCodePostalAndVille(adresse.getNumero(), adresse.getRue(), adresse.getCodePostal(), adresse.getVille());
        if(tempAdresse!=null){
            throw new Exception("Adresse existe déjà.");
        }
        //TODO : mettre en maj l'Adresse
        return adresseRepository.save(adresse);
    }

    public Adresse update(Adresse adresse) throws Exception {
        adresseRepository.findById(adresse.getId()).orElseThrow(() -> new Exception("Adresse n'existe pas."));
        return adresseRepository.save(adresse);
    }

    public boolean delete(Integer id) throws Exception {
        adresseRepository.findById(id).orElseThrow(Exception::new);
        adresseRepository.deleteById(id);
        return !adresseRepository.findById(id).isPresent();
    }
}
