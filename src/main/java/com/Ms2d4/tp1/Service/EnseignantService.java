package com.Ms2d4.tp1.Service;

import com.Ms2d4.tp1.Error.EnseignantNotFoundException;
import com.Ms2d4.tp1.Model.Departement;
import com.Ms2d4.tp1.Model.Enseignant;

import java.util.List;

public interface EnseignantService {
    List<Enseignant> getEnseignantList();

    Enseignant getEnseignantById(Long enseignantId) throws EnseignantNotFoundException;

    Enseignant saveEnseignant(Enseignant enseignant);

    Enseignant updateEnseignant(Long enseignantId, Enseignant enseignant);

    void deleteEnseignantById(Long enseignantId);

    Enseignant findEnseignant(String email, String password);
}
