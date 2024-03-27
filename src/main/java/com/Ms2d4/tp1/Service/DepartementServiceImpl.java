package com.Ms2d4.tp1.Service;

import com.Ms2d4.tp1.Error.EnseignantNotFoundException;
import com.Ms2d4.tp1.Model.Departement;
import com.Ms2d4.tp1.Repository.DepartementRepo;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DepartementServiceImpl implements DepartementService{

    private DepartementRepo departementRepo;

    public DepartementServiceImpl(DepartementRepo departementRepo) {
        this.departementRepo = departementRepo;
    }

    @Override
    public List<Departement> getDepartementList() {
        return departementRepo.findAll();
    }

    @Override
    public Departement getDepartementById(Long departementId) throws EnseignantNotFoundException {
        Optional<Departement> departement = Optional.ofNullable(departementRepo.findDepartementById(departementId));

        if(!departement.isPresent()){
            throw new EnseignantNotFoundException("Departement non existant");
        }

        return departement.get();
    }
}
