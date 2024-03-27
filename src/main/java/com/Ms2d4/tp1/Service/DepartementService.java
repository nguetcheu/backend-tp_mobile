package com.Ms2d4.tp1.Service;

import com.Ms2d4.tp1.Error.EnseignantNotFoundException;
import com.Ms2d4.tp1.Model.Departement;

import java.util.List;

public interface DepartementService {

    List<Departement> getDepartementList();

    Departement getDepartementById(Long departementId) throws EnseignantNotFoundException;
}
