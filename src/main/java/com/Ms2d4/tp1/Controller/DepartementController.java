package com.Ms2d4.tp1.Controller;

import com.Ms2d4.tp1.Error.EnseignantNotFoundException;
import com.Ms2d4.tp1.Model.Departement;
import com.Ms2d4.tp1.Service.DepartementService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/departement")
@CrossOrigin("*")
public class DepartementController {

    private DepartementService departementService;

    public DepartementController(DepartementService departementService) {
        this.departementService = departementService;
    }

    @GetMapping("/all")
    public ResponseEntity<List<Departement>> getAllDepartements(){
        List<Departement> departementList = departementService.getDepartementList();
        return new ResponseEntity<>(departementList, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Departement> getDepartementById(@PathVariable("id") Long departementId) throws EnseignantNotFoundException {
        Departement departement = departementService.getDepartementById(departementId);
        return new ResponseEntity<>(departement, HttpStatus.OK);
    }
}
