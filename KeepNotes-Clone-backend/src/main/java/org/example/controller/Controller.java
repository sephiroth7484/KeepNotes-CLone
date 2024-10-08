package org.example.controller;

import org.example.model.model;
import org.example.services.service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.persistence.EntityNotFoundException;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/models")
public class Controller {

    @Autowired
    service serviceObj;

    // Trial API endpoint
    @GetMapping("/welcome")
    public String welcome() {
        return "Welcome to Keep Note";
    }



    // Add a Note
    @PostMapping("/add")
    public ResponseEntity<String> addModel(@RequestBody model m) {
        serviceObj.addModel(m);
        return new ResponseEntity<>("Model Added Successfully", HttpStatus.ACCEPTED);
    }



    //Get All Note
    @GetMapping("/getAll")
    public ResponseEntity<List<model>> getAllModel() {
        List<model> models = serviceObj.getAllModels();
        return new ResponseEntity<>(models, HttpStatus.ACCEPTED);
    }



    // Get a note by id
    @GetMapping("/getById/{id}")
    public ResponseEntity<model> getById(@PathVariable long id) {
        Optional<model> fetchedModel = serviceObj.getModelById(id);
        if (fetchedModel.isPresent()) {
            return new ResponseEntity<>(fetchedModel.get(), HttpStatus.ACCEPTED);
        } else {
            throw new EntityNotFoundException("Model with ID " + id + " not found");
        }
    }



    //Delete a note by id
    @DeleteMapping("/deleteById/{id}")
    public ResponseEntity<String> deleteById(@PathVariable long id) {
        Optional<model> fetchedModel = serviceObj.getModelById(id);
        if (fetchedModel.isPresent()) {
            serviceObj.deleteModelById(id);
            return new ResponseEntity<>("Model Deleted Successfully", HttpStatus.ACCEPTED);
        } else {
            throw new EntityNotFoundException("Model with ID " + id + " not found");
        }
    }
}
