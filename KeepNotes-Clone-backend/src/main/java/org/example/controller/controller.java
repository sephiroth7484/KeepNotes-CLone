package org.example.controller;

import org.example.model.model;
import org.example.services.service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class controller {

    @Autowired
    service seviceObj;

    @GetMapping("/welcome")
    public String welcome(){
        return "Welcome to keep Note";
    }

    @PostMapping("/add")
    public ResponseEntity<?> addModel(@RequestBody model m){
        try{
            this.seviceObj.addModel(m);
            return new ResponseEntity<>("Model Added Successfully", HttpStatus.ACCEPTED);
        }catch (Exception e){
            return new ResponseEntity<>("Error Occured:" + e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }
    @GetMapping("/getAll")
    public ResponseEntity<?> getAllModel(@RequestBody model m){
        try{
            List<model> amodels = this.seviceObj.getAllModels(m);
            return new ResponseEntity<>("Model Added Successfully", HttpStatus.ACCEPTED);
        }catch (Exception e){
            return new ResponseEntity<>("Error Occured:" + e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }
}
