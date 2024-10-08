package org.example.services;

import org.example.model.modelDTO;
import org.example.repository.repo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.util.List;
import java.util.Optional;

@Service
public class serviceImpl implements service {

    @Autowired
    repo JPARepoObj;
    @Override
    public void addModel(modelDTO m) {
    this.JPARepoObj.save(m);
    }

    @Override
    public List<modelDTO> getAllModels() {
        return this.JPARepoObj.findAll();
    }

    @Override
    public Optional<modelDTO> getModelById(long id) {
        return this.JPARepoObj.findById(id);
    }

    @Override
    public void deleteModelById(long id) {
        this.JPARepoObj.deleteById(id);
    }

    @Override
    public void editModel(modelDTO updatedModelDTO) {

            this.JPARepoObj.save(updatedModelDTO);
    }

}
