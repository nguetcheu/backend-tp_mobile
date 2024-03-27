package com.Ms2d4.tp1.Service;

import com.Ms2d4.tp1.Error.EnseignantNotFoundException;
import com.Ms2d4.tp1.Model.Departement;
import com.Ms2d4.tp1.Model.Enseignant;
import com.Ms2d4.tp1.Repository.DepartementRepo;
import com.Ms2d4.tp1.Repository.EnseignantRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EnseignantServiceImpl implements EnseignantService {

    DepartementRepo departementRepo;
    public final EnseignantRepo enseignantRepo;

    public EnseignantServiceImpl(DepartementRepo departementRepo, EnseignantRepo enseignantRepo) {
        this.departementRepo = departementRepo;
        this.enseignantRepo = enseignantRepo;
    }

    @Override
    public List<Enseignant> getEnseignantList() {
        return enseignantRepo.findAll();
    }

    @Override
    public Enseignant getEnseignantById(Long studentId) throws EnseignantNotFoundException {
        Optional<Enseignant> enseignant = Optional.ofNullable(enseignantRepo.findEnseignantById(studentId));

        if(!enseignant.isPresent()){
            throw new EnseignantNotFoundException("Enseignant non existant");
        }

        return enseignant.get();
    }

    @Override
    public Enseignant saveEnseignant(Enseignant enseignant) {
        enseignant.setRole("user");
        return enseignantRepo.save(enseignant);
    }

    @Override
    public Enseignant updateEnseignant(Long studentId, Enseignant enseignant) {
        Enseignant enseignant1 = enseignantRepo.getById(studentId);
        enseignant1.setNom(enseignant.getNom());
        enseignant1.setPrenom(enseignant.getPrenom());
        enseignant1.setAnnee(enseignant.getAnnee());
        enseignant1.setRole("user");
        enseignant1.setDepartement(enseignant.getDepartement());
        enseignant1.setPhone(enseignant.getPhone());
        enseignant1.setEmail(enseignant.getEmail());
        return enseignantRepo.save(enseignant1);
    }

    @Override
    public void deleteEnseignantById(Long studentId) {
        enseignantRepo.deleteEnseignantById(studentId);
    }

    @Override
    public Enseignant findEnseignant(String email, String password) {
        return enseignantRepo.findByEmailAndPassword(email, password);
    }
}
