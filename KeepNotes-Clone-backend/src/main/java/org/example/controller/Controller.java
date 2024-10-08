package org.example.controller;

import org.example.model.modelDTO;
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
    public ResponseEntity<String> addModel(@RequestBody modelDTO modelDTO) {
        modelDTO entityModel = new modelDTO();
        entityModel.setId(modelDTO.getId());
        entityModel.setHeading(modelDTO.getHeading());
        entityModel.setDescription(modelDTO.getDescription());
        this.serviceObj.addModel(entityModel);
        return new ResponseEntity<>("Model Added Successfully", HttpStatus.OK);
    }



    //Get All Note
    @GetMapping("/getAll")
    public ResponseEntity<List<modelDTO>> getAllModel() {
        List<modelDTO> modelDTOS = serviceObj.getAllModels();
        return new ResponseEntity<>(modelDTOS, HttpStatus.OK);
    }



    // Get a note by id
    @GetMapping("/getById/{id}")
    public ResponseEntity<modelDTO> getById(@PathVariable long id) {
        Optional<modelDTO> fetchedModel = serviceObj.getModelById(id);
        if (fetchedModel.isPresent()) {
            return new ResponseEntity<>(fetchedModel.get(), HttpStatus.ACCEPTED);
        } else {
            throw new EntityNotFoundException("Model with ID " + id + " not found");
        }
    }



    //Delete a note by id
    @DeleteMapping("/deleteById/{id}")
    public ResponseEntity<String> deleteById(@PathVariable long id) {
        Optional<modelDTO> fetchedModel = serviceObj.getModelById(id);
        if (fetchedModel.isPresent()) {
            serviceObj.deleteModelById(id);
            return new ResponseEntity<>("Model Deleted Successfully", HttpStatus.OK);
        } else {
            throw new EntityNotFoundException("Model with ID " + id + " not found");
        }
    }

    @PutMapping("/editById/{id}")
    public ResponseEntity<String> editModel(@PathVariable long id, @RequestBody modelDTO modelDTO) {
        Optional<modelDTO> fetchedModel = serviceObj.getModelById(id);
        if (fetchedModel.isPresent()) {
            modelDTO existingModel= fetchedModel.get();

            existingModel.setHeading(modelDTO.getHeading());
            existingModel.setDescription(modelDTO.getDescription());
            serviceObj.editModel(existingModel);
            return new ResponseEntity<>("Model Updated Successfully", HttpStatus.OK);
        } else {
            throw new EntityNotFoundException("Model with details " + modelDTO.getId() + " not found");
        }
    }
}
