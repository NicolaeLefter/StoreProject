package com.example.StoreProject.controller.employesController;

import com.example.StoreProject.entity.employes.Employes;
import com.example.StoreProject.repository.employesRepository.EmployesRepository;
import com.example.StoreProject.service.employesService.EmployesServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/employes")
public class EmployesController {

    @Autowired
    EmployesRepository employesRepository;
    @Autowired
    EmployesServiceImpl employesService;
    @PostMapping("/save")
    public ResponseEntity<Object> saveEmployee(@RequestBody Employes employes){
        return ResponseEntity.status(HttpStatus.OK).body(employesRepository.save(employes));
    }
    @PostMapping("/saveAll")
    public ResponseEntity<Object> saveAllEmployes(@RequestBody List<Employes> employesList){
        return ResponseEntity.status(HttpStatus.OK).body(employesRepository.saveAll(employesList));
    }
    @GetMapping("/getAll")
    public ResponseEntity<Object> getAll(){
        return ResponseEntity.status(HttpStatus.OK).body(employesRepository.findAll());
    }
    @GetMapping("/get/{id}")
    public ResponseEntity<Object> getEmployeeById(@PathVariable Integer id){
        return ResponseEntity.status(HttpStatus.OK).body(employesRepository.findById(id));
    }
    @DeleteMapping("/delete/{idEmployee}")
    public ResponseEntity<Object> deleteById(@PathVariable Integer idEmployee){
        return ResponseEntity.status(HttpStatus.OK).body(employesRepository.deleteByIdEmployee(idEmployee));
    }
    @PutMapping("/update/{id}")
    public ResponseEntity<Object> updateEmployee(@RequestBody Employes employes, @PathVariable Integer id){
        return ResponseEntity.status(HttpStatus.OK).body(employesService.updateEmployee(employes,id));
    }
}
