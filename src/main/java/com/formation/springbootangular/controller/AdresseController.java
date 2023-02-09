package com.formation.springbootangular.controller;

import com.formation.springbootangular.entity.Adresse;
import com.formation.springbootangular.service.AdresseService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/adresse")
public class AdresseController {

    private final AdresseService adresseService;


    public AdresseController(AdresseService adresseService) {
        this.adresseService = adresseService;
    }

    @PostMapping("/create")
    public Adresse createAdresse(@RequestBody Adresse adresse) throws Exception {
        return adresseService.create(adresse);
    }

    @PutMapping
    public Adresse updateAdresse(@RequestBody Adresse adresse) throws Exception {
        return adresseService.update(adresse);
    }

    @DeleteMapping("/delete/{id}")
    public boolean deleteAdresse(@PathVariable Integer id) throws Exception {
        return adresseService.delete(id);
    }
}
