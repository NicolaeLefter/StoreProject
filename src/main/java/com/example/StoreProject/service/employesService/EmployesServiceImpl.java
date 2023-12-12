package com.example.StoreProject.service.employesService;

import com.example.StoreProject.entity.employes.EmployeeFunction;
import com.example.StoreProject.entity.employes.Employes;
import com.example.StoreProject.exception.employesException.EmployesNotFoundException;
import com.example.StoreProject.repository.employesRepository.EmployesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.validation.ObjectError;

import java.util.HashMap;
import java.util.Map;

@Service
public class EmployesServiceImpl {
    @Autowired
    EmployesRepository employesRepository;

    @Transactional
    public ResponseEntity<Object> updateEmployee(Employes employee, Integer idEmployee) {

        Employes employes = employesRepository.findById(idEmployee).orElseThrow(() ->
                new EmployesNotFoundException("Nu a fost gasit angajatul cu id-ul: " + idEmployee));

        Map<Object, String> map = new HashMap<>();
        employes.setEmployeeFunction(employee.getEmployeeFunction());
        employes.setFirstName(employee.getFirstName());
        employes.setLastName(employee.getLastName());
        employes.setPhoneNumber(employee.getPhoneNumber());
        employes.setStore(employee.getStore());

        return ResponseEntity.ok("Angajatul a fost actualizat cu succes!");
    }
}
