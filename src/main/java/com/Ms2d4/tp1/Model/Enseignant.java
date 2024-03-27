package com.Ms2d4.tp1.Model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Enseignant implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false, updatable = false)
    private Long id;

    @Column(unique = true, nullable = false)
    private String nom;

    @Column(unique = true, nullable = false)
    private String email;

    private String role;

    private String prenom;

    private int phone;

    private String password;

    @ManyToOne
    @JsonBackReference
    @JoinColumn(name = "departement_id")
    private Departement departement;

    private int annee;
}
