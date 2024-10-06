package org.example.services;

import org.example.model.model;
import org.example.repository.repo;
import org.springframework.beans.factory.annotation.Autowired;

public class serviceImpl implements service {

    @Autowired
    repo JPARepoObj;
    @Override
    public void addModel(model m) {
    this.JPARepoObj.save(m);
    }
}
