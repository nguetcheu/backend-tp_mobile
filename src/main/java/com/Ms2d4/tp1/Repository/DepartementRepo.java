package com.Ms2d4.tp1.Repository;

import com.Ms2d4.tp1.Error.EnseignantNotFoundException;
import com.Ms2d4.tp1.Model.Departement;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DepartementRepo extends JpaRepository<Departement, Long> {

    Departement findDepartementById(Long departementId) throws EnseignantNotFoundException;
}
