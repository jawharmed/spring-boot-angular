// FEAT-userprofile

package com.formation.springbootangular.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.lang.NonNull;

import javax.persistence.*;
import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "user_Profile")
public class UserProfile {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @NonNull
    @Column(name = "type")
    private String type ;

    @NonNull
    @Column(name = "pseudo")
    private String pseudo ;

    @NonNull
    @Column(name = "date_creation")
    private Date dateCreation ;

    @NonNull
    @Column(name = "date_maj")
    private Date dateMAJ ;

    @NonNull
    @Column(name = "centres_interets")
    private String centresInterets;

    @NonNull
    @Column(name = "resume")
    private String resume ;

}
