package com.Ms2d4.tp1.Controller;

import com.Ms2d4.tp1.Error.EnseignantNotFoundException;
import com.Ms2d4.tp1.Model.Enseignant;
import com.Ms2d4.tp1.Service.EnseignantService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin("*")
@RequestMapping("/enseignant")
public class EnseignantController {

    private final EnseignantService enseignantService;

    @Autowired
    public EnseignantController(EnseignantService enseignantService) {
        this.enseignantService = enseignantService;
    }

    @GetMapping("/all")
    public ResponseEntity<List<Enseignant>> getAllEnseignants () {
        List<Enseignant> enseignantList = enseignantService.getEnseignantList();
        return new ResponseEntity<>(enseignantList, HttpStatus.OK);
    }

    @GetMapping("/find/{id}")
    public ResponseEntity<Enseignant> getEnseignantById (@PathVariable("id") Long enseignantId) throws EnseignantNotFoundException {
        Enseignant enseignant = enseignantService.getEnseignantById(enseignantId);
        return new ResponseEntity<>(enseignant, HttpStatus.OK);
    }

    @PostMapping("/add")
    public ResponseEntity<Enseignant> addEnseignant (@RequestBody Enseignant enseignant) {
        Enseignant newEnseignant = enseignantService.saveEnseignant(enseignant);
        return new ResponseEntity<>(newEnseignant, HttpStatus.OK);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<Enseignant> updateEnseignant (@PathVariable("id") Long enseignantId, @RequestBody Enseignant enseignant)  {
        Enseignant updateEnseignant = enseignantService.updateEnseignant(enseignantId, enseignant);
        return new ResponseEntity<>(updateEnseignant, HttpStatus.OK);
    }

    @Transactional
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deleteEnseignant (@PathVariable("id") Long enseignantId)  {
        enseignantService.deleteEnseignantById(enseignantId);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PostMapping("/login")
    public ResponseEntity<Enseignant>  connexion(@RequestBody Enseignant enseignant){
        Enseignant enseignant1 = enseignantService.findEnseignant(enseignant.getEmail(), enseignant.getPassword());
        return new ResponseEntity<>(enseignant1,HttpStatus.OK);
    }

}
