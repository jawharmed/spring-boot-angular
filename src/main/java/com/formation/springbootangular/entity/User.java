package com.formation.springbootangular.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.lang.NonNull;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "user_")
public class User {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @NonNull
    @Column(name = "nom")
    private String nom;

    @NonNull
    @Column(name = "prenom")
    private String prenom;

    @NonNull
    @Column(name = "login" )
    private String login;

    @NonNull
    @Column(name = "password")
    private String password;

    @Column(name = "email", nullable = true)
    private String email;

    @Column(name = "date_creation")
    private Date dateCreation;

    // FIX-ModificationUSER -- OLD OneToOne
    @OneToMany(cascade = {CascadeType.PERSIST, CascadeType.MERGE, CascadeType.REFRESH})
    private List<Adresse> adresse;

}
