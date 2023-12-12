package com.example.StoreProject.repository.employesRepository;

import com.example.StoreProject.entity.employes.Employes;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmployesRepository extends JpaRepository<Employes, Integer> {

    Object deleteByIdEmployee(Integer idEmployee);
}
