package com.Ms2d4.tp1.Repository;

import com.Ms2d4.tp1.Error.EnseignantNotFoundException;
import com.Ms2d4.tp1.Model.Enseignant;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EnseignantRepo extends JpaRepository<Enseignant, Long> {
    void deleteEnseignantById(Long studentId);

    Enseignant findEnseignantById(Long studentId) throws EnseignantNotFoundException;

    Enseignant findByEmailAndPassword(String email, String password);
}
