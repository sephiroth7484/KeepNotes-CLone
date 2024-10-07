package org.example.controller;

import org.example.model.model;
import org.example.services.service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/models")
public class controller {

    @Autowired
    service serviceObj;

    @GetMapping("/welcome")
    public String welcome(){
        return "Welcome to keep Note";
    }

    @PostMapping("/add")
    public ResponseEntity<?> addModel(@RequestBody model m){
        try{
            this.serviceObj.addModel(m);
            return new ResponseEntity<>("Model Added Successfully", HttpStatus.ACCEPTED);
        }catch (Exception e){
            return new ResponseEntity<>("Error Occured:" + e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }
    @GetMapping("/getAll")
    public ResponseEntity<?> getAllModel(){
        try{
            List<model> models = this.serviceObj.getAllModels();
            return new ResponseEntity<>(models, HttpStatus.ACCEPTED);
        }catch (Exception e){
            return new ResponseEntity<>("Error Occured:" + e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping("/getById/{id}")
    public ResponseEntity<?> getById(@PathVariable long id){
        try{
            Optional<model> fetchedModel = this.serviceObj.getModelById(id);
            if ( fetchedModel.isPresent()) {
                return new ResponseEntity<>(fetchedModel, HttpStatus.ACCEPTED);
            }else {
                return new ResponseEntity<>("Model not found", HttpStatus.NOT_FOUND);
            }
        }catch (Exception e){
            return new ResponseEntity<>("Error Occured:" + e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }
    @DeleteMapping("/deleteById/{id}")
    public ResponseEntity<?> deleteById(@PathVariable long id){
        try{
            Optional<model> fetchedModel = this.serviceObj.getModelById(id);
            if ( fetchedModel.isPresent()) {
                this.serviceObj.deleteModelById(id);
                return new ResponseEntity<>("Model Deleted Successfully", HttpStatus.ACCEPTED);
            }else {
                return new ResponseEntity<>("Model not found", HttpStatus.NOT_FOUND);
            }
        }catch (Exception e){
            return new ResponseEntity<>("Error Occured:" + e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }
}
